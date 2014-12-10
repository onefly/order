package com.qianqian.refund.model;

import java.io.Serializable;
import java.util.Date;

public class RefundLog implements Serializable {
    
	/**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = 2420021406117136389L;

	private Long id;

    private Integer refundType;

    private Long refundId;

    private Long orderChildId;

    private Date operationDate;

    private Integer operationType;

    private Integer operationPlatform;

    private Long operator;

    private String remark;

    private Integer orderBeforeState;

    private Integer orderCurrentState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getOrderChildId() {
        return orderChildId;
    }

    public void setOrderChildId(Long orderChildId) {
        this.orderChildId = orderChildId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Integer getOperationPlatform() {
        return operationPlatform;
    }

    public void setOperationPlatform(Integer operationPlatform) {
        this.operationPlatform = operationPlatform;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOrderBeforeState() {
        return orderBeforeState;
    }

    public void setOrderBeforeState(Integer orderBeforeState) {
        this.orderBeforeState = orderBeforeState;
    }

    public Integer getOrderCurrentState() {
        return orderCurrentState;
    }

    public void setOrderCurrentState(Integer orderCurrentState) {
        this.orderCurrentState = orderCurrentState;
    }
}