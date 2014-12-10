package com.qianqian.report.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.qianqian.comment.constant.CommentConstant;
import com.qianqian.comment.model.Rate;
import com.qianqian.comment.service.IProductRateDubboService;
import com.qianqian.order.dto.Result;
import com.qianqian.order.dto.UpdateStateDTO;
import com.qianqian.order.model.OrderChild;
import com.qianqian.order.service.IOrderDubboService;
import com.qianqian.order.utils.OrderConstants;
import com.qianqian.report.bo.ReportBO;
import com.qianqian.report.model.Report;
import com.qianqian.report.service.IReportDubboService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	private static Logger log = LoggerFactory.getLogger(ReportController.class);
	
	@Resource
	private IOrderDubboService orderDubboService;
	
	@Autowired
	private IReportDubboService reportService;
	
	@Autowired
	private static IProductRateDubboService prdRateService;
	
	@RequestMapping("/toFillReport")
	public String toFillReport(Long orderChildId, Model model){
		log.info("跳转页面");
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 5 : session.getId();
		
		OrderChild child = orderDubboService.getOrderChild(orderChildId);
		
		model.addAttribute("orderId", child.getOrderId());
		model.addAttribute("activityId", child.getActivityId());
		model.addAttribute("userId", userId);
		model.addAttribute("applyId", child.getApplyId());
		model.addAttribute("orderChildId", orderChildId);
		model.addAttribute("lastState", child.getReportState());
		log.info("reportState---------->"+child.getReportState());
		
		return "report/fillReport";
	}
	
	/**
	 * 处理提交报告的方法
	 *  @Method_Name    : submitReport
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月7日 下午8:26:13
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/submitReport")
	public String submitReport(Model model, ReportBO reportBO){
		log.info("reportTitle-------"+reportBO.getReportTitle());
		log.info("reportContent-------"+reportBO.getReportContent());
		log.info("产品喜好度为："+reportBO.getPrdRef());
		log.info("品牌喜好度为："+reportBO.getBrdRef());
		log.info("activityId------->"+reportBO.getActivityId());
		log.info("orderChildId-------->"+reportBO.getOrderChildId());
		log.info("lastState--------->"+reportBO.getLastState());
		
		SessionData sd = SessionUtil.getSessionData();
		long userId = sd == null ? 5 : sd.getId();
		log.info("userId------->"+userId);
		
		Report report = new Report();
		report.setActivityId(reportBO.getActivityId());
		report.setChildOrderId(reportBO.getOrderChildId());
		report.setUserId(userId);
		report.setCommitDatetime(new Date());
		report.setReportTitle(reportBO.getReportTitle());
		report.setReportContent(reportBO.getReportContent());
		
		//将报告存入report表
		reportService.saveReport(report);
		
		Rate rate = new Rate();
		rate.setAgain(null);
		rate.setAgainState(CommentConstant.NO_AGAIN);
		rate.setBrandId(reportBO.getBrandId());
		rate.setBrandName(reportBO.getBrandName());
		rate.setBrdPreference(reportBO.getBrdRef());
		if(reportBO.getBrdRef() == CommentConstant.BRAND_PREFERENCE_DISLIKE_BYTE){
			rate.setBrdPreferenceContent(CommentConstant.BRAND_PREFERENCE_DISLIKE_STR);
		}
		if(reportBO.getBrdRef() == CommentConstant.BRAND_PREFERENCE_LIKE_BYTE){
			rate.setBrdPreferenceContent(CommentConstant.BRAND_PREFERENCE_LIKE_STR);
		}
		if(reportBO.getBrdRef() == CommentConstant.BRAND_PREFERENCE_ORDINARY_BYTE){
			rate.setBrdPreferenceContent(CommentConstant.BRAND_PREFERENCE_ORDINARY_STR);
		}
		rate.setCommentTime(new Date());
		rate.setPrdPreference(reportBO.getPrdRef());
		if(reportBO.getPrdRef() == CommentConstant.PRODUCT_PREFERENCE_BAD_BYTE){
			rate.setPrdPreferenceContent(CommentConstant.PRODUCT_PREFERENCE_BAD_STR);
		}
		if(reportBO.getPrdRef() == CommentConstant.PRODUCT_PREFERENCE_GOOD_BYTE){
			rate.setPrdPreferenceContent(CommentConstant.PRODUCT_PREFERENCE_GOOD_STR);
		}
		if(reportBO.getPrdRef() == CommentConstant.PRODUCT_PREFERENCE_ORDINARY_BYTE){
			rate.setPrdPreferenceContent(CommentConstant.PRODUCT_PREFERENCE_ORDINARY_STR);
		}
		
		//将评价存入productComment表
		prdRateService.save(rate);
		
		//存入成功后修改订单状态
		UpdateStateDTO updateState = new UpdateStateDTO();
		updateState.setLastState(reportBO.getLastState());
		updateState.setCurrentState(OrderConstants.STATE_WAIT_CHECK);
		updateState.setOperationPlatform(OrderConstants.OPERATOR_TYPE_BUYER);
		updateState.setOperationType(OrderConstants.OPERATION_TYPE_REPORT);
		updateState.setOperator(userId);
		updateState.setOrderChildId(reportBO.getOrderChildId());
		updateState.setRemark("用户主动提交报告");
		
		Result result = new Result();
		try {
			result = orderDubboService.updateReportState(updateState);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		log.info("lastState--------->"+reportBO.getLastState());
		log.debug("result---------->"+result.getResult());
		
		model.addAttribute("userId", userId);
		model.addAttribute("activityId", reportBO.getActivityId());
		model.addAttribute("applyId", reportBO.getApplyId());
		log.info("userId------>"+userId);
		log.info("activityId-------->"+reportBO.getActivityId());
		log.info("applyId---------->"+reportBO.getApplyId());
		
		log.info("update success!");
		
		return "report/fillReport";
	}
	
}
