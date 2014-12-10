package com.qianqian.cart.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.qianqian.common.utils.Constants;

/**
 * 品牌体验车中的商品
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.cart.model.Commodity.java
 * @ClassName	: Commodity 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年6月16日 下午1:44:11
 */
public class Commodity implements Serializable{
	
	/**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = 4690235547664531447L;
	private long activityId;//活动编号
	/**商品编号，规格id**/
	private long standardId;
	private long productCode;//产品编码
	private long brandId;//商品品牌
	private int version;//产品版本
	private String brandName;//品牌名称
	private String brandImgSmall;//品牌小图片
	private String brandImgBig;//品牌大图片
	private String name;//商品名称
	private String image;//商品图片
	private String standard;//商品规格
	private BigDecimal market;//市场价
	private BigDecimal naked;//裸价
	private int ingot = Constants.COST_INGOT_NUM;//消耗体验宝数量
	
	
	public long getActivityId() {
		return activityId;
	}


	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}


	public long getStandardId() {
		return standardId;
	}


	public void setStandardId(long standardId) {
		this.standardId = standardId;
	}


	public long getProductCode() {
		return productCode;
	}


	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}


	public long getBrandId() {
		return brandId;
	}


	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	


	public String getBrandImgSmall() {
		return brandImgSmall;
	}


	public void setBrandImgSmall(String brandImgSmall) {
		this.brandImgSmall = brandImgSmall;
	}


	public String getBrandImgBig() {
		return brandImgBig;
	}


	public void setBrandImgBig(String brandImgBig) {
		this.brandImgBig = brandImgBig;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	public BigDecimal getMarket() {
		return market;
	}


	public void setMarket(BigDecimal market) {
		this.market = market;
	}


	public BigDecimal getNaked() {
		return naked;
	}


	public void setNaked(BigDecimal naked) {
		this.naked = naked;
	}


	public int getIngot() {
		return ingot;
	}


	public void setIngot(int ingot) {
		this.ingot = ingot;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (productCode ^ (productCode >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (productCode != other.productCode)
			return false;
		return true;
	}


	public Commodity(long productCode, long brandId, int version, String name,
			String image, String standard, BigDecimal market, BigDecimal naked,
			int ingot) {
		super();
		this.productCode = productCode;
		this.brandId = brandId;
		this.version = version;
		this.name = name;
		this.image = image;
		this.standard = standard;
		this.market = market;
		this.naked = naked;
		this.ingot = ingot;
	}


	


	@Override
	public String toString() {
		return "Commodity [productCode=" + productCode + ", brandId=" + brandId
				+ ", version=" + version + ", brandName=" + brandName
				+ ", brandImgSmall=" + brandImgSmall + ", brandImgBig="
				+ brandImgBig + ", name=" + name + ", image=" + image
				+ ", standard=" + standard + ", market=" + market + ", naked="
				+ naked + ", ingot=" + ingot + "]";
	}


	public Commodity() {
		super();
	}


	public Commodity(long productCode, int version, String name, String image,
			String standard, BigDecimal market, BigDecimal naked, int ingot) {
		super();
		this.productCode = productCode;
		this.version = version;
		this.name = name;
		this.image = image;
		this.standard = standard;
		this.market = market;
		this.naked = naked;
		this.ingot = ingot;
	}


	public Commodity(long productCode, long brandId, int version,
			String brandName, String brandImgSmall, String brandImgBig,
			String name, String image, String standard, BigDecimal market,
			BigDecimal naked, int ingot) {
		super();
		this.productCode = productCode;
		this.brandId = brandId;
		this.version = version;
		this.brandName = brandName;
		this.brandImgSmall = brandImgSmall;
		this.brandImgBig = brandImgBig;
		this.name = name;
		this.image = image;
		this.standard = standard;
		this.market = market;
		this.naked = naked;
		this.ingot = ingot;
	}


	
	
}
