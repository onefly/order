package com.qianqian.apply.controller;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import com.framelib.common.RedisConstants;
import com.framelib.common.SessionData;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.SessionUtil;
import com.qianqian.apply.model.ApplyForm;
import com.qianqian.apply.model.ApplyHandleLog;
import com.qianqian.apply.model.ApplySupportRecord;
import com.qianqian.apply.service.IApplyFormService;
import com.qianqian.apply.service.IApplyHandleLogService;
import com.qianqian.apply.service.IApplySupportRecordService;
import com.qianqian.apply.util.ApplyConstants;
import com.qianqian.member.model.User;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductStandard;
import com.qianqian.product.service.IProductDubboService;

/**
 * 免费试用申请单操作控制器
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.apply.controller.ApplyFormController.java
 * @ClassName : ApplyFormController
 * @Author : caozhifei
 * @CreateDate : 2014年6月25日 下午5:38:32
 */
@RequestMapping("apply")
@Controller
public class ApplyFormController {
	private static Logger log = LoggerFactory
			.getLogger(ApplyFormController.class);
	/**
	 * 填写申请单页面
	 */
	private static final String ADD_INIT = "apply/addApply";
	/**
	 * 申请单详情页
	 */
	private static final String APPLY_DETAIL = "apply/applyDetail";
	/**
	 * 申请单拉赞求支持页面
	 */
	private static final String FOR_SUPPORT = "apply/forSupport";
	
	/**
	 * 申请单操作service
	 */
	@Resource
	private IApplyFormService applyFormService;
	/**
	 * redis操作对象
	 */
	@Resource
	private IRedisUtil redisUtil;
	/**
	 * 申请单支持操作service
	 */
	@Resource
	private IApplySupportRecordService applySupportRecordService;
	/**
	 * 申请单处理日志表操作service
	 */
	@Resource
	private IApplyHandleLogService applyHandleLogService;
	/**
	 * 用户信息操作service
	 */
	@Resource
	private IUserDubboService userDubboService;
	/**
	 * 产品信息操作service
	 */
	@Resource
	private IProductDubboService productDubboService;

	/**
	 * 提交申请单
	 * 
	 * @Method_Name : addApplyForm
	 * @param apply
	 * @return 1 操作成功 ，2 操作失败,3已经存在,4积分不够
	 * @return : String
	 * @Creation Date : 2014年6月25日 下午5:37:14
	 * @version : v1.00
	 * @throws Exception
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("addApplyForm")
	public String addApplyForm(ApplyForm apply, ModelMap map) {
		log.debug("addApplyForm:" + apply);
		int result = 0;
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 110 : session.getId();
		apply.setUserId(userId);
		boolean isScoreEnough = userDubboService.getUser(userId).getScore() >= ApplyConstants.APPLY_DEDUCT_SCORE;
		//TODO 判断活动状态，当活动状态处于申请期的时候才可以进行操作，其他状态则提示活动已经结束
		//判断用户积分是否足够
		if (isScoreEnough) {
			if (applyFormService.canAddApply(apply)) {
				String nickname = userDubboService.getUser(userId).getNickname();
				Product product = productDubboService.getProduct(apply.getProductCode(), apply.getVersion());
				BigDecimal price = product.getMarketPrice();
				String productName = product.getProductName();
				String note = MessageFormat.format(ApplyConstants.APPLY_NOTE, nickname, price, productName);
				apply.setApplyNote(note);
				apply.setSupportCount(0);
				apply.setSlogan(HtmlUtils.htmlEscape(apply.getSlogan()));
				apply.setReason(HtmlUtils.htmlEscape(apply.getReason()));
				//TODO 设置申请时的品牌海报，品牌logo，品牌简介信息
				
				try {
					result = applyFormService.addApplyForm(apply);
					System.out.println("add after="+apply.getId());
					if (result == 1) {
						// 申请成功后扣除相应积分
						userDubboService.deductScore(userId,
								ApplyConstants.APPLY_DEDUCT_SCORE);
					}
				} catch (Exception e) {
					result = 2;
					String redisKey = RedisConstants.USER_APPLY_PREFIX
							+ apply.getUserId() +":"+ apply.getProductCode();
					redisUtil.freeLock(redisKey);
					log.error(e.toString(), e);
				}
			} else {
				result = 3;
			}
		} else {
			result = 4;
		}
		String applyId = String.valueOf(apply.getId());
		System.out.println("add ="+apply.getId());
		map.put("result", result);
		map.put("applyId", applyId);
		return null;
	}

	/**
	 * 初始化申请单提交页面数据
	 *  @Method_Name    : addInit
	 *  @param activityId 活动ID
	 *  @param standardId 产品规格ID
	 *  @param map
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月9日 上午11:56:23
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("addInit")
	public String addInit(Long activeId,Long standardId,ModelMap map) {
		log.debug("activityId="+activeId+",standardId="+standardId);
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 110 : session.getId();
		ProductActivity activity = productDubboService.getPrdActivity(activeId);
		//TODO 判断活动状态，当活动状态处于申请期的时候才可以进行操作，其他状态则提示活动已经结束
		ApplyForm apply = new ApplyForm();
		apply.setUserId(userId);
		apply.setActiveId(activeId);
		apply.setProductCode(activity.getProductCode());
		apply.setVersion(activity.getVersion());
		apply.setStandardId(standardId);
		Product product = productDubboService.getProduct(activity.getProductCode(), activity.getVersion());
		apply.setBrandCode(product.getBrandId());
		map.put("apply", apply);
		map.put("costScore", ApplyConstants.APPLY_DEDUCT_SCORE);
		return ADD_INIT;
	}
	/**
	 * 测试方法，生产环境可以删除
	 *  @Method_Name    : addTest
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月7日 下午7:19:51
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("addTest")
	public String addTest() {
		//TODO 测试方法 可以删除
		return "apply/productDetail";
	}
	/**
	 * 查看申请单状态详情页
	 *  @Method_Name    : showDetail
	 *  @param id 申请单ID
	 *  @param map
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月6日 下午5:45:12
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("showDetail")
	public String showDetail(Long id,ModelMap map){
		log.debug("show detail id="+id);
		//查询申请单信息
		ApplyForm apply = applyFormService.getApplyFormByPrimaryKey(id);
		map.put("apply", apply);
		
		//查询当前用户信息
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 110 : session.getId();
		User user = userDubboService.getUser(userId);
		map.put("user", user);
		
		//查询申请单处理日志记录信息
		List<ApplyHandleLog> handleLogs = applyHandleLogService.getAllHandleLog(id);
		map.put("handleLogs", handleLogs);
		
		//查询活动信息
		ProductActivity activity = productDubboService.getPrdActivity(apply.getActiveId());
		map.put("activity", activity);
		
		//查询产品信息
		Product product = productDubboService.getProduct(apply.getProductCode(), apply.getVersion());
		map.put("product", product);
		
		//查询产品图片信息
		String picture = productDubboService.getOrderPic(apply.getProductCode(), apply.getVersion());
		map.put("picture", picture);
		
		//查询产品规格
		ProductStandard standard =productDubboService.getGoods(apply.getStandardId());
		map.put("standard", standard);
		
		//申请单消耗积分数量
		map.put("costSocre", ApplyConstants.APPLY_DEDUCT_SCORE);
		map.put("currentDate", new Date());
		
		return APPLY_DETAIL;
	}
	/**
	 * 返回拉赞求支持页面
	 * 
	 * @Method_Name : forSupport
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月26日 下午3:00:24
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("forSupport/{id}")
	public String forSupport(HttpServletRequest request, @PathVariable Long id,
			ModelMap map) {
		log.debug("id=" + id);
		ApplyForm apply = applyFormService.getApplyFormByPrimaryKey(id);
		SessionData session = null;
		try {
			session = SessionUtil.getSessionData(request);
		} catch (TimeoutException e) {
			log.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		} catch (MemcachedException e) {
			log.error(e.getMessage(), e);
		}
		int buttonState = 1;
		Date currentDate = new Date();
		if (session != null) {
			ApplySupportRecord record = new ApplySupportRecord();
			long userId = session == null ? 110 : session.getId();
			record.setUserId(userId);
			record.setApplyId(id);
			if (!applySupportRecordService.canSupport(record) ) {
				buttonState = 0;
			}
		}
		if(apply.getAuditStartTime().getTime() <= currentDate.getTime()){
			//如果进入审核期，按钮则不可点击
			buttonState = 0;
		}
		map.put("buttonState", buttonState);// 0 表示按钮灰色不能点击，1表示可以点击
		map.put("apply", apply);
		map.put("currentDate", currentDate);
		return FOR_SUPPORT;
	}
	
	
}
