package com.qianqian.cart.bo;

import java.math.BigDecimal;
import java.util.List;

import com.qianqian.member.model.RecieveAddress;

/**
 * 提交订单页面业务封装对象
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.cart.bo.CartBO.java
 * @ClassName : CartBO
 * @Author : caozhifei
 * @CreateDate : 2014年6月18日 下午1:17:10
 */
public class CartBO {
	/**
	 * 默认收获地址
	 */
	private RecieveAddress receiver;
	/**
	 * 收货人地址列表
	 */
	private List<RecieveAddress> receiverList;
	/**
	 * 产品与活动的业务封装对象
	 */
	private List<ProductBO> productBoList;
	/**
	 * 合计消耗体验宝数量
	 */
	@SuppressWarnings("unused")
	private int ingot;
	/**
	 * 订单金额总计
	 */
	@SuppressWarnings("unused")
	private BigDecimal amount;
	/**
	 * 产品编码和版本号组合
	 */
	private String codeVersions;
	/**
	 * 品牌ID
	 */
	private Long brandId;
	/**
	 * 品牌名称
	 */
	private String brandName;
	/** 订单类型 10：裸价体验，20：免费试用 **/
	private int type = 10;
	/**
	 * 申请单编号
	 */
	private Long applyId;

	public RecieveAddress getReceiver() {
		return receiver;
	}

	public void setReceiver(RecieveAddress receiver) {
		this.receiver = receiver;
	}

	public List<RecieveAddress> getReceiverList() {
		return receiverList;
	}

	public void setReceiverList(List<RecieveAddress> receiverList) {
		this.receiverList = receiverList;
	}

	public List<ProductBO> getProductBoList() {
		return productBoList;
	}

	public void setProductBoList(List<ProductBO> productBoList) {
		this.productBoList = productBoList;
	}

	public int getIngot() {
		if (productBoList != null) {
			return productBoList.size();
		}
		return 0;
	}

	public BigDecimal getAmount() {
		BigDecimal sum = new BigDecimal(0.00);
		if (productBoList != null) {
			for (ProductBO pro : productBoList) {
				if (pro != null && pro.getActivity() != null) {
					sum = sum.add(pro.getActivity().getPrice());
				}
			}
		}
		return sum;
	}

	public String getCodeVersions() {
		return codeVersions;
	}

	public void setCodeVersions(String codeVersions) {
		this.codeVersions = codeVersions;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	
}
