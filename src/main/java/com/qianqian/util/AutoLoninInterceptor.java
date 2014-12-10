package com.qianqian.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.framelib.common.CommonConstants;
import com.framelib.common.SessionData;
import com.framelib.utils.CookieUtils;
import com.framelib.utils.SessionUtil;
import com.qianqian.member.model.User;
import com.qianqian.member.service.IUserDubboService;

/**
 * 登录权限鉴定拦截器
 * 
 * @Project : maxtp.framelib
 * @Program Name: com.framelib.interceptor.AuthenticateInterceptor.java
 * @ClassName : AuthenticateInterceptor
 * @Author : caozhifei
 * @CreateDate : 2014年4月21日 上午9:49:29
 */
public class AutoLoninInterceptor implements HandlerInterceptor {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IUserDubboService userDubboService;
	
	/**
	 * 参数展示方法
	 *  @Method_Name    : showParameters
	 *  @param request 
	 *  @return         : void
	 *  @Creation Date  : 2014年7月18日 上午10:05:37
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	private void showParameters(HttpServletRequest request){
		Enumeration<String> params = request.getParameterNames();//.getParameterMap();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			log.debug("show Parameters ==>"+name+"="+Arrays.toString(request.getParameterValues(name)));
		}
	}

	/**
	 * 用于拦截所有请求，判断cookie中是否有自动登陆标识，若有则将其手动设置为登陆状态，若没有
	 * 则交由其他拦截器作处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		showParameters(request);
		boolean loginFlag = isLoginStatus(request);
		Cookie cookie = CookieUtils.getCookieByName(request, CommonConstants.COOKIE_AUTOLOGIN_MARK);
		String mark_value = "";
		User user = null;
		// 判断用户是否登陆
		if(!loginFlag){
			if(cookie!=null){
				
				log.info("cookie != null");
				mark_value = cookie.getValue();
				log.info("mark_value = "+mark_value);
				
				//自动登陆状态
				if(CommonConstants.AUTOLOGIN_YES.equals(mark_value)){
					
					log.info("----进入自动登陆----");
					String phone = CookieUtils.getCookieByName(request, CommonConstants.COOKIE_USERNAME).getValue();
					log.info("cookie中取得手机号为："+phone);
					//TODO 等待dubbo服务接口
					user = new User();//userDubboService.selectByPhone(phone);
					user.setNickname("魅力天使");
					user.setUserId(110L);
					SessionData sd = new SessionData();
					
					//标记，具体讨论
					sd.setNickName(user.getNickname());
					sd.setId(user.getUserId());
					
					log.info("nickname = "+user.getNickname());
					
					try {
						//将手动登陆的用户放入memcached
						SessionUtil.ssoLogin(request, response, sd);
						log.info("放入memcached");
						
						user.setLastLoginTime(new Date());
						//userService.updateUser(user);
						
					} catch (TimeoutException e) {
						log.error(e.toString(), e);
						e.printStackTrace();
					} catch (InterruptedException e) {
						log.error(e.toString(), e);
						e.printStackTrace();
					} catch (MemcachedException e) {
						log.error(e.toString(), e);
						e.printStackTrace();
					}
					
				}else{//非自动登陆状态
					log.info("----非自动登陆----");
				}
				
			}else{
				log.info("cookie == null");
			}
		}
		return true;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	/**
	 * 判断当前的登录状态
	 * 
	 * @Method_Name : isLoginStatus
	 * @param request
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年4月21日 上午10:53:58
	 * @version : v1.00
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isLoginStatus(HttpServletRequest request) {
		SessionData sd = null;
		try {
			sd = SessionUtil.getSessionData(request);
		} catch (TimeoutException e) {
			log.error(e.toString(), e);
		} catch (InterruptedException e) {
			log.error(e.toString(), e);
		} catch (MemcachedException e) {
			log.error(e.toString(), e);
		}
		if (sd == null) {
			return false;
		} else {
			return true;
		}

	}

	
}
