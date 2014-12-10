package com.qianqian.apply.bo;

import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductStat;
/**
 * 产品相关业务封装对象
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.apply.bo.ProductBO.java
 * @ClassName	: ProductBO 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年7月4日 上午11:53:50
 */
public class ProductBO {
	/**
	 * 产品信息
	 */
	private Product product;
	/**
	 * 活动信息
	 */
	private ProductActivity activity;
	/**
	 * 产品统计信息
	 */
	private ProductStat stat;
	/**
	 * 品牌海报
	 */
	private String poster;
	/**
	 * 品牌累计体验人数
	 */
	private int total=53614;
	/**
	 * 品牌喜欢人数
	 */
	private int like=48863;
	/**
	 * 品牌一般人数
	 */
	private int general=3632;
	/**
	 * 品牌不喜欢人数
	 */
	private int dislike=12536;
	/**
	 * 免费试用申请开始时间
	 */
	private String applyStartTime;
	/**
	 * 免费试用申请截止时间
	 */
	private String applyEndTime;
	/**
	 * 免费试用申请审核截止时间
	 */
	private String applyAuditTime;
	/**
	 * 当前时间
	 */
	private String currentDate;
	
	
	
	public String getApplyStartTime() {
		return applyStartTime;
	}
	public void setApplyStartTime(String applyStartTime) {
		this.applyStartTime = applyStartTime;
	}
	public String getApplyEndTime() {
		return applyEndTime;
	}
	public void setApplyEndTime(String applyEndTime) {
		this.applyEndTime = applyEndTime;
	}
	public String getApplyAuditTime() {
		return applyAuditTime;
	}
	public void setApplyAuditTime(String applyAuditTime) {
		this.applyAuditTime = applyAuditTime;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductActivity getActivity() {
		return activity;
	}
	public void setActivity(ProductActivity activity) {
		this.activity = activity;
	}
	public ProductStat getStat() {
		return stat;
	}
	public void setStat(ProductStat stat) {
		this.stat = stat;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getGeneral() {
		return general;
	}
	public void setGeneral(int general) {
		this.general = general;
	}
	public int getDislike() {
		return dislike;
	}
	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
	@Override
	public String toString() {
		return "ProductBO [product=" + product + ", activity=" + activity
				+ ", stat=" + stat + ", poster=" + poster + ", total=" + total
				+ ", like=" + like + ", general=" + general + ", dislike="
				+ dislike + ", applyEndTime=" + applyEndTime
				+ ", applyAuditTime=" + applyAuditTime + ", currentDate="
				+ currentDate + "]";
	}
	
	
}
