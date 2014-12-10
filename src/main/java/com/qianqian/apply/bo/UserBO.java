package com.qianqian.apply.bo;

import com.qianqian.member.model.User;
/**
 * 用户表的业务封装对象
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.apply.bo.UserBO.java
 * @ClassName	: UserBO 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年7月4日 上午11:30:33
 */
public class UserBO {
	/**
	 * 用户对象
	 */
	private User user;
	/**
	 * 关注他人数量
	 */
	private int focusCount;
	/**
	 * 粉丝数量
	 */
	private int fansCount;
	/**
	 * 收到赞数量
	 */
	private int supportCount;
	/**
	 * 提交的报告数量
	 */
	private int reportCount;
	/**
	 * 报告平均分
	 */
	private int aveScore;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFocusCount() {
		return focusCount;
	}
	public void setFocusCount(int focusCount) {
		this.focusCount = focusCount;
	}
	public int getFansCount() {
		return fansCount;
	}
	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}
	public int getSupportCount() {
		return supportCount;
	}
	public void setSupportCount(int supportCount) {
		this.supportCount = supportCount;
	}
	public int getReportCount() {
		return reportCount;
	}
	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}
	public int getAveScore() {
		return aveScore;
	}
	public void setAveScore(int aveScore) {
		this.aveScore = aveScore;
	}
	@Override
	public String toString() {
		return "UserBO [user=" + user + ", focusCount=" + focusCount
				+ ", fansCount=" + fansCount + ", supportCount=" + supportCount
				+ ", reportCount=" + reportCount + ", aveScore=" + aveScore
				+ "]";
	}
	
}
