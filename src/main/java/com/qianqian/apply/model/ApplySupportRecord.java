package com.qianqian.apply.model;

import java.io.Serializable;
import java.util.Date;

public class ApplySupportRecord implements Serializable{
	
    /**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = -5638325427679219867L;

	private Long id;

    private Long applyId;

    private Long userId;

    private Date supportTime;

    private String nickname;

    private String headImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getSupportTime() {
        return supportTime;
    }

    public void setSupportTime(Date supportTime) {
        this.supportTime = supportTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

	@Override
	public String toString() {
		return "ApplySupportRecord [id=" + id + ", applyId=" + applyId
				+ ", userId=" + userId + ", supportTime=" + supportTime
				+ ", nickname=" + nickname + ", headImg=" + headImg + "]";
	}
    
}