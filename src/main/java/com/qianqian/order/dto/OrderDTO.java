package com.qianqian.order.dto;

import java.io.Serializable;
import java.util.List;

import com.qianqian.order.model.OrderChild;

/**
 * 提交订单时需要传的参数
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.order.dto.OrderDTO.java
 * @ClassName	: OrderDTO 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年10月20日 下午4:27:09
 */
public class OrderDTO implements Serializable{
	
	/**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = 7863133852176003343L;
	/**订单类型 0：裸价体验，1：免费试用**/
	private int type;
	/**品牌id**/
	private Long brandId;
	/**品牌名称**/
	private String brandName;
	/**买家留言**/
	private String remark;
	/**是否需要发票**/
	private int hasInvoice;
	/**发票抬头**/
	private String invoiceTitle;
	/**发票类型**/
	private int invoiceType;
	/**发票内容**/
	private String invoiceContent;
	/**完整收获地址**/
	private String addrFullAddress;
	/**收货人姓名**/
	private String addrRecieveName;
	/**邮编**/
	private String addrZipCode;
	/**收货人手机**/
	private String addrRecieveMobile;
	/**收货人座机**/
	private String addrRecievePhone;
	/**申请单编号**/
	private Long applyId;
	/**子订单**/
	private OrderChild orderChild; 
	
	public Long getApplyId() {
		return applyId;
	}
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	
	public OrderChild getOrderChild() {
		return orderChild;
	}
	public void setOrderChild(OrderChild orderChild) {
		this.orderChild = orderChild;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getHasInvoice() {
		return hasInvoice;
	}
	public void setHasInvoice(int hasInvoice) {
		this.hasInvoice = hasInvoice;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public int getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(int invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceContent() {
		return invoiceContent;
	}
	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}
	
	public String getAddrFullAddress() {
		return addrFullAddress;
	}
	public void setAddrFullAddress(String addrFullAddress) {
		this.addrFullAddress = addrFullAddress;
	}
	public String getAddrRecieveName() {
		return addrRecieveName;
	}
	public void setAddrRecieveName(String addrRecieveName) {
		this.addrRecieveName = addrRecieveName;
	}
	public String getAddrZipCode() {
		return addrZipCode;
	}
	public void setAddrZipCode(String addrZipCode) {
		this.addrZipCode = addrZipCode;
	}
	public String getAddrRecieveMobile() {
		return addrRecieveMobile;
	}
	public void setAddrRecieveMobile(String addrRecieveMobile) {
		this.addrRecieveMobile = addrRecieveMobile;
	}
	public String getAddrRecievePhone() {
		return addrRecievePhone;
	}
	public void setAddrRecievePhone(String addrRecievePhone) {
		this.addrRecievePhone = addrRecievePhone;
	}
	@Override
	public String toString() {
		return "OrderDTO [type=" + type + ", brandId=" + brandId
				+ ", brandName=" + brandName + ", remark=" + remark
				+ ", hasInvoice=" + hasInvoice + ", invoiceTitle="
				+ invoiceTitle + ", invoiceType=" + invoiceType
				+ ", invoiceContent=" + invoiceContent + ", addrFullAddress="
				+ addrFullAddress + ", addrRecieveName=" + addrRecieveName
				+ ", addrZipCode=" + addrZipCode + ", addrRecieveMobile="
				+ addrRecieveMobile + ", addrRecievePhone=" + addrRecievePhone
				+ ", applyId=" + applyId + ", orderChild=" + orderChild + "]";
	}
	



	
	
}
