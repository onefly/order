
package com.qianqian.order.dto;

import java.io.Serializable;

/** 
 * 判断是否符合活动标准的返回类型
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.order.dto.JudgeActivityResult.java
 * @ClassName	: JudgeActivityResult 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年7月2日 下午1:28:22  
 */
public class JudgeResult implements Serializable {
	/**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = -8888278308265269194L;
	/**是否符合活动标准**/
	private boolean result;
	/**角色是否符合**/
	private boolean isRole;
	/**等级是否符合**/
	private boolean isLevel;
	/**勋章数是否足够**/
	private boolean isMedal;
	/**活动地区是否符合**/
	private boolean isArea;
	/**年龄是否符合**/
	private boolean isAge;
	/**性别是否符合**/
	private boolean isGender;
	/**是否是初次体验**/
	private boolean isFirst;
	
	public boolean getIsFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public boolean getIsRole() {
		return isRole;
	}
	public void setRole(boolean isRole) {
		this.isRole = isRole;
	}
	public boolean getIsLevel() {
		return isLevel;
	}
	public void setLevel(boolean isLevel) {
		this.isLevel = isLevel;
	}
	public boolean getIsMedal() {
		return isMedal;
	}
	public void setMedal(boolean isMedal) {
		this.isMedal = isMedal;
	}
	public boolean getIsArea() {
		return isArea;
	}
	public void setArea(boolean isArea) {
		this.isArea = isArea;
	}
	public boolean getIsAge() {
		return isAge;
	}
	public void setAge(boolean isAge) {
		this.isAge = isAge;
	}
	public boolean getIsGender() {
		return isGender;
	}
	public void setGender(boolean isGender) {
		this.isGender = isGender;
	}
	@Override
	public String toString() {
		return "JudgeResult [result=" + result + ", isRole=" + isRole
				+ ", isLevel=" + isLevel + ", isMedal=" + isMedal + ", isArea="
				+ isArea + ", isAge=" + isAge + ", isGender=" + isGender
				+ ", isFirst=" + isFirst + "]";
	}
	
	
}