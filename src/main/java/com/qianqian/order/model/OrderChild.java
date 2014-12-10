package com.qianqian.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderChild implements Serializable {
    private Long id;

    private Long orderId;

    private String orderCode;

    private Integer state;

    private Integer evaluateState;

    private Integer reportState;

    private Integer refundStatice;

    private Integer refundStateRoles;

    private Long lastRefundId;

    private Integer lastRefudType;

    private Integer oricount;

    private Long refundFund;

    private Long prdId;

    private Integer prdVersion;

    private Long prdStandardId;

    private Long prdCode;

    private Long prdCategoryId;

    private String prdCategoryName;

    private Long prdBrandId;

    private String prdBrandName;

    private Long prdSeriesId;

    private Long applyId;

    private String prdSeriesName;

    private String prdName;

    private BigDecimal prdMarketPrice;

    private BigDecimal prdPric;

    private String prdStandard;

    private String prdPic;

    private Long buyerId;

    private String buyerNickname;

    private Integer type;

    private Long activityId;

    private String actiPurpose;

    private BigDecimal actiPrice;

    private Integer actiAgeMin;

    private Integer actiAgeMax;

    private Integer actiGender;

    private Integer actiGradeLow;

    private Integer actiGradeHigh;

    private Integer actiUserType;

    private Integer actiBrandNum;

    private String actiArea;

    private String actiAreaId;

    private Integer actiAreaType;

    private Integer actiReportDay;

    private String stanColorName;

    private Integer stanColorCode;

    private String stanSizeName;

    private Integer stanSizeCode;

    private Integer payIngotNum;

    private Integer refundIngotNum;

    private Date submitReportTime;

    private Date submitEvaluateTime;

    private Date returnDepositTime;

    private Date revertEvaluateTime;

    private Date orderCreateTime;

    private String orderResourceId;

    private Date orderClosedTime;

    private String orderClosedRemark;

    private Date buyerPaymentTime;

    private Integer orderClosedId;

    private BigDecimal realPicer;

    private Date buyerSigninTime;

    private Date sellerDeliverTi;

    private Integer isDelaySignin;

    private Date crontabTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEvaluateState() {
        return evaluateState;
    }

    public void setEvaluateState(Integer evaluateState) {
        this.evaluateState = evaluateState;
    }

    public Integer getReportState() {
        return reportState;
    }

    public void setReportState(Integer reportState) {
        this.reportState = reportState;
    }

    public Integer getRefundStatice() {
        return refundStatice;
    }

    public void setRefundStatice(Integer refundStatice) {
        this.refundStatice = refundStatice;
    }

    public Integer getRefundStateRoles() {
        return refundStateRoles;
    }

    public void setRefundStateRoles(Integer refundStateRoles) {
        this.refundStateRoles = refundStateRoles;
    }

    public Long getLastRefundId() {
        return lastRefundId;
    }

    public void setLastRefundId(Long lastRefundId) {
        this.lastRefundId = lastRefundId;
    }

    public Integer getLastRefudType() {
        return lastRefudType;
    }

    public void setLastRefudType(Integer lastRefudType) {
        this.lastRefudType = lastRefudType;
    }

    public Integer getOricount() {
        return oricount;
    }

    public void setOricount(Integer oricount) {
        this.oricount = oricount;
    }

    public Long getRefundFund() {
        return refundFund;
    }

    public void setRefundFund(Long refundFund) {
        this.refundFund = refundFund;
    }

    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }

    public Integer getPrdVersion() {
        return prdVersion;
    }

    public void setPrdVersion(Integer prdVersion) {
        this.prdVersion = prdVersion;
    }

    public Long getPrdStandardId() {
        return prdStandardId;
    }

    public void setPrdStandardId(Long prdStandardId) {
        this.prdStandardId = prdStandardId;
    }

    public Long getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(Long prdCode) {
        this.prdCode = prdCode;
    }

    public Long getPrdCategoryId() {
        return prdCategoryId;
    }

    public void setPrdCategoryId(Long prdCategoryId) {
        this.prdCategoryId = prdCategoryId;
    }

    public String getPrdCategoryName() {
        return prdCategoryName;
    }

    public void setPrdCategoryName(String prdCategoryName) {
        this.prdCategoryName = prdCategoryName == null ? null : prdCategoryName.trim();
    }

    public Long getPrdBrandId() {
        return prdBrandId;
    }

    public void setPrdBrandId(Long prdBrandId) {
        this.prdBrandId = prdBrandId;
    }

    public String getPrdBrandName() {
        return prdBrandName;
    }

    public void setPrdBrandName(String prdBrandName) {
        this.prdBrandName = prdBrandName == null ? null : prdBrandName.trim();
    }

    public Long getPrdSeriesId() {
        return prdSeriesId;
    }

    public void setPrdSeriesId(Long prdSeriesId) {
        this.prdSeriesId = prdSeriesId;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getPrdSeriesName() {
        return prdSeriesName;
    }

    public void setPrdSeriesName(String prdSeriesName) {
        this.prdSeriesName = prdSeriesName == null ? null : prdSeriesName.trim();
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
    }

    public BigDecimal getPrdMarketPrice() {
        return prdMarketPrice;
    }

    public void setPrdMarketPrice(BigDecimal prdMarketPrice) {
        this.prdMarketPrice = prdMarketPrice;
    }

    public BigDecimal getPrdPric() {
        return prdPric;
    }

    public void setPrdPric(BigDecimal prdPric) {
        this.prdPric = prdPric;
    }

    public String getPrdStandard() {
        return prdStandard;
    }

    public void setPrdStandard(String prdStandard) {
        this.prdStandard = prdStandard == null ? null : prdStandard.trim();
    }

    public String getPrdPic() {
        return prdPic;
    }

    public void setPrdPic(String prdPic) {
        this.prdPic = prdPic == null ? null : prdPic.trim();
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerNickname() {
        return buyerNickname;
    }

    public void setBuyerNickname(String buyerNickname) {
        this.buyerNickname = buyerNickname == null ? null : buyerNickname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActiPurpose() {
        return actiPurpose;
    }

    public void setActiPurpose(String actiPurpose) {
        this.actiPurpose = actiPurpose == null ? null : actiPurpose.trim();
    }

    public BigDecimal getActiPrice() {
        return actiPrice;
    }

    public void setActiPrice(BigDecimal actiPrice) {
        this.actiPrice = actiPrice;
    }

    public Integer getActiAgeMin() {
        return actiAgeMin;
    }

    public void setActiAgeMin(Integer actiAgeMin) {
        this.actiAgeMin = actiAgeMin;
    }

    public Integer getActiAgeMax() {
        return actiAgeMax;
    }

    public void setActiAgeMax(Integer actiAgeMax) {
        this.actiAgeMax = actiAgeMax;
    }

    public Integer getActiGender() {
        return actiGender;
    }

    public void setActiGender(Integer actiGender) {
        this.actiGender = actiGender;
    }

    public Integer getActiGradeLow() {
        return actiGradeLow;
    }

    public void setActiGradeLow(Integer actiGradeLow) {
        this.actiGradeLow = actiGradeLow;
    }

    public Integer getActiGradeHigh() {
        return actiGradeHigh;
    }

    public void setActiGradeHigh(Integer actiGradeHigh) {
        this.actiGradeHigh = actiGradeHigh;
    }

    public Integer getActiUserType() {
        return actiUserType;
    }

    public void setActiUserType(Integer actiUserType) {
        this.actiUserType = actiUserType;
    }

    public Integer getActiBrandNum() {
        return actiBrandNum;
    }

    public void setActiBrandNum(Integer actiBrandNum) {
        this.actiBrandNum = actiBrandNum;
    }

    public String getActiArea() {
        return actiArea;
    }

    public void setActiArea(String actiArea) {
        this.actiArea = actiArea == null ? null : actiArea.trim();
    }

    public String getActiAreaId() {
        return actiAreaId;
    }

    public void setActiAreaId(String actiAreaId) {
        this.actiAreaId = actiAreaId == null ? null : actiAreaId.trim();
    }

    public Integer getActiAreaType() {
        return actiAreaType;
    }

    public void setActiAreaType(Integer actiAreaType) {
        this.actiAreaType = actiAreaType;
    }

    public Integer getActiReportDay() {
        return actiReportDay;
    }

    public void setActiReportDay(Integer actiReportDay) {
        this.actiReportDay = actiReportDay;
    }

    public String getStanColorName() {
        return stanColorName;
    }

    public void setStanColorName(String stanColorName) {
        this.stanColorName = stanColorName == null ? null : stanColorName.trim();
    }

    public Integer getStanColorCode() {
        return stanColorCode;
    }

    public void setStanColorCode(Integer stanColorCode) {
        this.stanColorCode = stanColorCode;
    }

    public String getStanSizeName() {
        return stanSizeName;
    }

    public void setStanSizeName(String stanSizeName) {
        this.stanSizeName = stanSizeName == null ? null : stanSizeName.trim();
    }

    public Integer getStanSizeCode() {
        return stanSizeCode;
    }

    public void setStanSizeCode(Integer stanSizeCode) {
        this.stanSizeCode = stanSizeCode;
    }

    public Integer getPayIngotNum() {
        return payIngotNum;
    }

    public void setPayIngotNum(Integer payIngotNum) {
        this.payIngotNum = payIngotNum;
    }

    public Integer getRefundIngotNum() {
        return refundIngotNum;
    }

    public void setRefundIngotNum(Integer refundIngotNum) {
        this.refundIngotNum = refundIngotNum;
    }

    public Date getSubmitReportTime() {
        return submitReportTime;
    }

    public void setSubmitReportTime(Date submitReportTime) {
        this.submitReportTime = submitReportTime;
    }

    public Date getSubmitEvaluateTime() {
        return submitEvaluateTime;
    }

    public void setSubmitEvaluateTime(Date submitEvaluateTime) {
        this.submitEvaluateTime = submitEvaluateTime;
    }

    public Date getReturnDepositTime() {
        return returnDepositTime;
    }

    public void setReturnDepositTime(Date returnDepositTime) {
        this.returnDepositTime = returnDepositTime;
    }

    public Date getRevertEvaluateTime() {
        return revertEvaluateTime;
    }

    public void setRevertEvaluateTime(Date revertEvaluateTime) {
        this.revertEvaluateTime = revertEvaluateTime;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getOrderResourceId() {
        return orderResourceId;
    }

    public void setOrderResourceId(String orderResourceId) {
        this.orderResourceId = orderResourceId == null ? null : orderResourceId.trim();
    }

    public Date getOrderClosedTime() {
        return orderClosedTime;
    }

    public void setOrderClosedTime(Date orderClosedTime) {
        this.orderClosedTime = orderClosedTime;
    }

    public String getOrderClosedRemark() {
        return orderClosedRemark;
    }

    public void setOrderClosedRemark(String orderClosedRemark) {
        this.orderClosedRemark = orderClosedRemark == null ? null : orderClosedRemark.trim();
    }

    public Date getBuyerPaymentTime() {
        return buyerPaymentTime;
    }

    public void setBuyerPaymentTime(Date buyerPaymentTime) {
        this.buyerPaymentTime = buyerPaymentTime;
    }

    public Integer getOrderClosedId() {
        return orderClosedId;
    }

    public void setOrderClosedId(Integer orderClosedId) {
        this.orderClosedId = orderClosedId;
    }

    public BigDecimal getRealPicer() {
        return realPicer;
    }

    public void setRealPicer(BigDecimal realPicer) {
        this.realPicer = realPicer;
    }

    public Date getBuyerSigninTime() {
        return buyerSigninTime;
    }

    public void setBuyerSigninTime(Date buyerSigninTime) {
        this.buyerSigninTime = buyerSigninTime;
    }

    public Date getSellerDeliverTi() {
        return sellerDeliverTi;
    }

    public void setSellerDeliverTi(Date sellerDeliverTi) {
        this.sellerDeliverTi = sellerDeliverTi;
    }

    public Integer getIsDelaySignin() {
        return isDelaySignin;
    }

    public void setIsDelaySignin(Integer isDelaySignin) {
        this.isDelaySignin = isDelaySignin;
    }

    public Date getCrontabTime() {
        return crontabTime;
    }

    public void setCrontabTime(Date crontabTime) {
        this.crontabTime = crontabTime;
    }
}