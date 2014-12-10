package com.qianqian.report.bo;

/**
 * 报告业务封装对象类
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.report.bo.ReportBO.java
 * @ClassName	: ReportBO 
 * @Author 		: shensheng 
 * @CreateDate  : 2014年7月22日 下午2:34:38
 */
public class ReportBO {
	 /**
	  * 报告标题
	  */
	private String reportTitle;
	
	/**
	 * 报告内容
	 */
	private String reportContent;
	
	/**
	 * 产品喜好度
	 */
	private byte prdRef;
	
	/**
	 * 品牌喜好度
	 */
	private byte brdRef;
	
	/**
	 * 报告针对的活动ID
	 */
	private Long activityId;
	
	/**
	 * 报告针对的子订单ID
	 */
	private Long orderChildId;
	
	/**
	 * 提交报告前的报告状态
	 */
	private int lastState;
	
	/**
	 * 提交报告的用户ID
	 */
	private Long userId;
	
	/**
	 * 报告针对的申请信息ID
	 */
	private Long applyId;
	
	/**
	 * 报告针对的品牌ID
	 */
	private Long brandId;
	
	/**
	 * 报告针对的品牌名称
	 */
	private String brandName;
	
	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	
	public byte getPrdRef() {
		return prdRef;
	}

	public void setPrdRef(byte prdRef) {
		this.prdRef = prdRef;
	}

	public byte getBrdRef() {
		return brdRef;
	}

	public void setBrdRef(byte brdRef) {
		this.brdRef = brdRef;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getOrderChildId() {
		return orderChildId;
	}

	public void setOrderChildId(Long orderChildId) {
		this.orderChildId = orderChildId;
	}

	public int getLastState() {
		return lastState;
	}

	public void setLastState(int lastState) {
		this.lastState = lastState;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
