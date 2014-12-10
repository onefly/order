package com.qianqian.cart.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.qianqian.common.utils.Constants;

/**
 * 用户购物车内的品牌体验车
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.cart.model.BrandCart.java
 * @ClassName : BrandCart
 * @Author : caozhifei
 * @CreateDate : 2014年6月16日 下午1:43:55
 */
public class BrandCart implements Serializable {
	/**
	 * @Fields serialVersionUID :
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = 8354977377865501910L;
	private List<Commodity> commoditys = new ArrayList<Commodity>();// 品牌购物车内商品列表
	private int ingots;// 消耗体验宝数量
	private BigDecimal amount = new BigDecimal(0.00);// 合计金额
	private long brandId;// 品牌ID
	private String brandName;// 品牌名称
	private String brandImgSmall;//品牌小图片
	private String brandImgBig;//品牌大图片
	private int commdityNum;// 商品数量

	/**
	 * 添加新的商品到商品列表
	 * 
	 * @Method_Name : addCommodity
	 * @param commodity
	 * @return : int 1,添加成功；2,商品已经存在；3,已经达到购物车存放商品数量最大值
	 * @Creation Date : 2014年6月16日 下午2:31:44
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public int addCommodity(Commodity commodity) {
		if (commoditys.contains(commodity)) {
			return 2;
		}
		if (commdityNum >= Constants.CART_MAX_COMMODITY_NUM) {
			return 3;
		}
		commoditys.add(commodity);
		ingots = ingots + commodity.getIngot();
		commdityNum = commdityNum + 1;
		amount = amount.add(commodity.getNaked());
		brandId = commodity.getBrandId();
		brandName = commodity.getBrandName();
		brandImgSmall = commodity.getBrandImgSmall();
		brandImgBig = commodity.getBrandImgBig();
		return 1;

	}

	/**
	 * 从商品列表中移除商品
	 * 
	 * @Method_Name : deleteCommodity
	 * @param commodity
	 * @return : boolean true 移除成功 false移除失败
	 * @Creation Date : 2014年6月16日 下午2:47:22
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public boolean deleteCommodity(Commodity commodity) {
		boolean result = commoditys.remove(commodity);
		if (result) {
			ingots = ingots - commodity.getIngot();
			commdityNum = commdityNum - 1;
			amount = amount.subtract(commodity.getNaked());
			return true;
		}
		return false;
	}

	public int getIngots() {
		return ingots;
	}

	public List<Commodity> getCommoditys() {
		return commoditys;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
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

	public int getCommdityNum() {
		if (commoditys == null) {
			return commdityNum;
		} else {
			return commoditys.size();
		}
	}

	
	public BrandCart(List<Commodity> commoditys, int ingots, BigDecimal amount,
			long brandId, String brandName, String brandImgSmall,
			String brandImgBig, int commdityNum) {
		super();
		this.commoditys = commoditys;
		this.ingots = ingots;
		this.amount = amount;
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandImgSmall = brandImgSmall;
		this.brandImgBig = brandImgBig;
		this.commdityNum = commdityNum;
	}

	

	@Override
	public String toString() {
		return "BrandCart [commoditys=" + commoditys + ", ingots=" + ingots
				+ ", amount=" + amount + ", brandId=" + brandId
				+ ", brandName=" + brandName + ", brandImgSmall="
				+ brandImgSmall + ", brandImgBig=" + brandImgBig
				+ ", commdityNum=" + commdityNum + "]";
	}

	public BrandCart() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (brandId ^ (brandId >>> 32));
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
		BrandCart other = (BrandCart) obj;
		if (brandId != other.brandId)
			return false;
		return true;
	}

}
