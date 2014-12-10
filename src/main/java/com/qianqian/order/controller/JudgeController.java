package com.qianqian.order.controller;

import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.qianqian.order.dto.JudgeResult;
import com.qianqian.order.service.IOrderService;

@Controller
public class JudgeController {
	private Logger log =LoggerFactory.getLogger(JudgeController.class);
	@Resource
	private IOrderService orderService;
	@RequestMapping("/judge")
	public String judgeActivity(Long prdCode,int version,Long brandId,Long activityId,int type,Model model,HttpServletRequest request){
		SessionData session=null;
		try {
			session = SessionUtil.getSessionData(request);
		} catch (TimeoutException e) {
			log.error(e.toString()+e);
		
		} catch (InterruptedException e) {
			log.error(e.toString()+e);
			
		} catch (MemcachedException e) {
			log.error(e.toString()+e);
			
		}
		long userId=5l;
		if(session!=null){
			 userId=session.getId();
		}
		
		JudgeResult result=orderService.isCanExpOrTry(prdCode, version, userId, brandId, activityId, type);
		log.debug("judge result---->"+result);
		model.addAttribute("result", result);
		return null;
	}
}
