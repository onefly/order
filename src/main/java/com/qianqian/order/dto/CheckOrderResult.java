
package com.qianqian.order.dto;

import java.io.Serializable;

/** 订单提交时返回的校验结果
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.order.dto.CheckOrderResult.java
 * @ClassName	: CheckOrderResult 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年7月2日 下午1:48:02  
 */
public class CheckOrderResult implements Serializable {
	/**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = -7313396472650247112L;
	private boolean result;
	//是否重复下单
	private boolean submitOrder;
	//库存是否足够
	private boolean repertory;
	//活动是否结束
	private boolean activityOver;
	//是否符合活动标准
	private JudgeResult judgeResult;
	//是否是初次体验
	private boolean firstExperience;
	//体验宝是否充足
	private boolean ingotCount;
	//是否在订单提交期
	private boolean inSubmitTime;
	public boolean getSubmitOrder() {
		return submitOrder;
	}
	public void setSubmitOrder(boolean submitOrder) {
		this.submitOrder = submitOrder;
	}
	public boolean getRepertory() {
		return repertory;
	}
	public void setRepertory(boolean repertory) {
		this.repertory = repertory;
	}
	public boolean getActivityOver() {
		return activityOver;
	}
	public void setActivityOver(boolean activityOver) {
		this.activityOver = activityOver;
	}
	public JudgeResult getJudgeResult() {
		return judgeResult;
	}
	public void setJudgeResult(JudgeResult judgeResult) {
		this.judgeResult = judgeResult;
	}
	public boolean getFirstExperience() {
		return firstExperience;
	}
	public void setFirstExperience(boolean firstExperience) {
		this.firstExperience = firstExperience;
	}
	public boolean getIngotCount() {
		return ingotCount;
	}
	public void setIngotCount(boolean ingotCount) {
		this.ingotCount = ingotCount;
	}
	public boolean getInSubmitTime() {
		return inSubmitTime;
	}
	public void setInSubmitTime(boolean inSubmitTime) {
		this.inSubmitTime = inSubmitTime;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	
}
