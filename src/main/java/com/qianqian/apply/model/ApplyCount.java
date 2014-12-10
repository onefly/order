package com.qianqian.apply.model;

import java.io.Serializable;

public class ApplyCount implements Serializable{
	
    /**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = -6847274341303634380L;

	private Long id;

    private Long userId;

    private Long brandId;

    private Integer applyNum;

    private Integer successNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }
}