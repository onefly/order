package com.qianqian.refund.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Refund implements Serializable {
    
	/**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = 6645971460271975064L;

	private Long id;

    private Long orderId;

    private Long orderChildId;

    private Integer refundState;

    private Date refundCreateTime;

    private Integer orderType;

    private Integer refundType;

    private String refundResson;

    private String refundDescription;

    private String voucherPic1;

    private String voucherPic2;

    private String voucherPic3;

    private Integer appealState;

    private Integer oricount;

    private String prdId;

    private Integer prdVersion;

    private Long prdStandardId;

    private String prdStandard;

    private Long prdCode;

    private String prdName;

    private Long prdBrandId;

    private String prdBrandName;

    private String prdPic;

    private String stanColorName;

    private Integer stanColorCode;

    private String stanSizeName;

    private Integer stanSizeCode;

    private Long buyerId;

    private String buyerNickname;

    private Long activityId;

    private String actiPurpose;

    private Date sysAgreeRefundApplicationTime;

    private Date sysCloseRefundApplicationInterveneTime;

    private Date sysWanningRefundApplicationInterveneTime;

    private Date sysCloseRefundApplicationTime;

    private Date sysAgreeRefundTime;

    private Date sysCloseRefundInterveneTime;

    private Date sysWanningRefundInterveneTime;

    private Date sysWanningRefundAffirmTime;

    private Date sysCloseAppealTime;

    private BigDecimal priceOrder;

    private BigDecimal priceRefund;

    private String addrProvinceName;

    private String addrCityName;

    private String addrDistrictName;

    private Integer addrProvinceId;

    private Integer addrCityId;

    private Integer addrDistrictId;

    private String addrAddress;

    private String addrFullAddress;

    private String addrRecieveName;

    private String addrZipCode;

    private String addrRecieveMobile;

    private String addrRecievePhone;

    private String expressNumbers;

    private String expressCompany;

    private String brandRefuseReason;

    private String maxtpRefuseReason;

    private Date sysCreateRefundTime;

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

    public Long getOrderChildId() {
        return orderChildId;
    }

    public void setOrderChildId(Long orderChildId) {
        this.orderChildId = orderChildId;
    }

    public Integer getRefundState() {
        return refundState;
    }

    public void setRefundState(Integer refundState) {
        this.refundState = refundState;
    }

    public Date getRefundCreateTime() {
        return refundCreateTime;
    }

    public void setRefundCreateTime(Date refundCreateTime) {
        this.refundCreateTime = refundCreateTime;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public String getRefundResson() {
        return refundResson;
    }

    public void setRefundResson(String refundResson) {
        this.refundResson = refundResson == null ? null : refundResson.trim();
    }

    public String getRefundDescription() {
        return refundDescription;
    }

    public void setRefundDescription(String refundDescription) {
        this.refundDescription = refundDescription == null ? null : refundDescription.trim();
    }

    public String getVoucherPic1() {
        return voucherPic1;
    }

    public void setVoucherPic1(String voucherPic1) {
        this.voucherPic1 = voucherPic1 == null ? null : voucherPic1.trim();
    }

    public String getVoucherPic2() {
        return voucherPic2;
    }

    public void setVoucherPic2(String voucherPic2) {
        this.voucherPic2 = voucherPic2 == null ? null : voucherPic2.trim();
    }

    public String getVoucherPic3() {
        return voucherPic3;
    }

    public void setVoucherPic3(String voucherPic3) {
        this.voucherPic3 = voucherPic3 == null ? null : voucherPic3.trim();
    }

    public Integer getAppealState() {
        return appealState;
    }

    public void setAppealState(Integer appealState) {
        this.appealState = appealState;
    }

    public Integer getOricount() {
        return oricount;
    }

    public void setOricount(Integer oricount) {
        this.oricount = oricount;
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
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

    public String getPrdStandard() {
        return prdStandard;
    }

    public void setPrdStandard(String prdStandard) {
        this.prdStandard = prdStandard == null ? null : prdStandard.trim();
    }

    public Long getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(Long prdCode) {
        this.prdCode = prdCode;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
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

    public String getPrdPic() {
        return prdPic;
    }

    public void setPrdPic(String prdPic) {
        this.prdPic = prdPic == null ? null : prdPic.trim();
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

    public Date getSysAgreeRefundApplicationTime() {
        return sysAgreeRefundApplicationTime;
    }

    public void setSysAgreeRefundApplicationTime(Date sysAgreeRefundApplicationTime) {
        this.sysAgreeRefundApplicationTime = sysAgreeRefundApplicationTime;
    }

    public Date getSysCloseRefundApplicationInterveneTime() {
        return sysCloseRefundApplicationInterveneTime;
    }

    public void setSysCloseRefundApplicationInterveneTime(Date sysCloseRefundApplicationInterveneTime) {
        this.sysCloseRefundApplicationInterveneTime = sysCloseRefundApplicationInterveneTime;
    }

    public Date getSysWanningRefundApplicationInterveneTime() {
        return sysWanningRefundApplicationInterveneTime;
    }

    public void setSysWanningRefundApplicationInterveneTime(Date sysWanningRefundApplicationInterveneTime) {
        this.sysWanningRefundApplicationInterveneTime = sysWanningRefundApplicationInterveneTime;
    }

    public Date getSysCloseRefundApplicationTime() {
        return sysCloseRefundApplicationTime;
    }

    public void setSysCloseRefundApplicationTime(Date sysCloseRefundApplicationTime) {
        this.sysCloseRefundApplicationTime = sysCloseRefundApplicationTime;
    }

    public Date getSysAgreeRefundTime() {
        return sysAgreeRefundTime;
    }

    public void setSysAgreeRefundTime(Date sysAgreeRefundTime) {
        this.sysAgreeRefundTime = sysAgreeRefundTime;
    }

    public Date getSysCloseRefundInterveneTime() {
        return sysCloseRefundInterveneTime;
    }

    public void setSysCloseRefundInterveneTime(Date sysCloseRefundInterveneTime) {
        this.sysCloseRefundInterveneTime = sysCloseRefundInterveneTime;
    }

    public Date getSysWanningRefundInterveneTime() {
        return sysWanningRefundInterveneTime;
    }

    public void setSysWanningRefundInterveneTime(Date sysWanningRefundInterveneTime) {
        this.sysWanningRefundInterveneTime = sysWanningRefundInterveneTime;
    }

    public Date getSysWanningRefundAffirmTime() {
        return sysWanningRefundAffirmTime;
    }

    public void setSysWanningRefundAffirmTime(Date sysWanningRefundAffirmTime) {
        this.sysWanningRefundAffirmTime = sysWanningRefundAffirmTime;
    }

    public Date getSysCloseAppealTime() {
        return sysCloseAppealTime;
    }

    public void setSysCloseAppealTime(Date sysCloseAppealTime) {
        this.sysCloseAppealTime = sysCloseAppealTime;
    }

    public BigDecimal getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(BigDecimal priceOrder) {
        this.priceOrder = priceOrder;
    }

    public BigDecimal getPriceRefund() {
        return priceRefund;
    }

    public void setPriceRefund(BigDecimal priceRefund) {
        this.priceRefund = priceRefund;
    }

    public String getAddrProvinceName() {
        return addrProvinceName;
    }

    public void setAddrProvinceName(String addrProvinceName) {
        this.addrProvinceName = addrProvinceName == null ? null : addrProvinceName.trim();
    }

    public String getAddrCityName() {
        return addrCityName;
    }

    public void setAddrCityName(String addrCityName) {
        this.addrCityName = addrCityName == null ? null : addrCityName.trim();
    }

    public String getAddrDistrictName() {
        return addrDistrictName;
    }

    public void setAddrDistrictName(String addrDistrictName) {
        this.addrDistrictName = addrDistrictName == null ? null : addrDistrictName.trim();
    }

    public Integer getAddrProvinceId() {
        return addrProvinceId;
    }

    public void setAddrProvinceId(Integer addrProvinceId) {
        this.addrProvinceId = addrProvinceId;
    }

    public Integer getAddrCityId() {
        return addrCityId;
    }

    public void setAddrCityId(Integer addrCityId) {
        this.addrCityId = addrCityId;
    }

    public Integer getAddrDistrictId() {
        return addrDistrictId;
    }

    public void setAddrDistrictId(Integer addrDistrictId) {
        this.addrDistrictId = addrDistrictId;
    }

    public String getAddrAddress() {
        return addrAddress;
    }

    public void setAddrAddress(String addrAddress) {
        this.addrAddress = addrAddress == null ? null : addrAddress.trim();
    }

    public String getAddrFullAddress() {
        return addrFullAddress;
    }

    public void setAddrFullAddress(String addrFullAddress) {
        this.addrFullAddress = addrFullAddress == null ? null : addrFullAddress.trim();
    }

    public String getAddrRecieveName() {
        return addrRecieveName;
    }

    public void setAddrRecieveName(String addrRecieveName) {
        this.addrRecieveName = addrRecieveName == null ? null : addrRecieveName.trim();
    }

    public String getAddrZipCode() {
        return addrZipCode;
    }

    public void setAddrZipCode(String addrZipCode) {
        this.addrZipCode = addrZipCode == null ? null : addrZipCode.trim();
    }

    public String getAddrRecieveMobile() {
        return addrRecieveMobile;
    }

    public void setAddrRecieveMobile(String addrRecieveMobile) {
        this.addrRecieveMobile = addrRecieveMobile == null ? null : addrRecieveMobile.trim();
    }

    public String getAddrRecievePhone() {
        return addrRecievePhone;
    }

    public void setAddrRecievePhone(String addrRecievePhone) {
        this.addrRecievePhone = addrRecievePhone == null ? null : addrRecievePhone.trim();
    }

    public String getExpressNumbers() {
        return expressNumbers;
    }

    public void setExpressNumbers(String expressNumbers) {
        this.expressNumbers = expressNumbers == null ? null : expressNumbers.trim();
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    public String getBrandRefuseReason() {
        return brandRefuseReason;
    }

    public void setBrandRefuseReason(String brandRefuseReason) {
        this.brandRefuseReason = brandRefuseReason == null ? null : brandRefuseReason.trim();
    }

    public String getMaxtpRefuseReason() {
        return maxtpRefuseReason;
    }

    public void setMaxtpRefuseReason(String maxtpRefuseReason) {
        this.maxtpRefuseReason = maxtpRefuseReason == null ? null : maxtpRefuseReason.trim();
    }

    public Date getSysCreateRefundTime() {
        return sysCreateRefundTime;
    }

    public void setSysCreateRefundTime(Date sysCreateRefundTime) {
        this.sysCreateRefundTime = sysCreateRefundTime;
    }
}