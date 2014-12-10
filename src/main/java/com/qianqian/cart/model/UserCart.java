package com.qianqian.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qianqian.common.utils.Constants;

/**
 * 用户购物车
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.cart.model.UserCart.java
 * @ClassName : UserCart
 * @Author : caozhifei
 * @CreateDate : 2014年6月16日 下午1:43:40
 */
public class UserCart implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = -4551349903220075659L;
	private List<BrandCart> brandCarts = new ArrayList<BrandCart>();// 品牌 体验车列表
	private int cartNum;// 品牌体验车数量

	/**
	 * 向购物车内添加商品
	 * 
	 * @Method_Name : addCommodity
	 * @param commodity
	 * @return : int 1,添加成功；2,商品已经存在；3,已经达到购物车数量最大值
	 * @Creation Date : 2014年6月16日 下午3:09:29
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public int addCommodity(Commodity commodity) {
		BrandCart brandCart = new BrandCart();
		brandCart.setBrandId(commodity.getBrandId());
		if (brandCarts.contains(brandCart)) {
			int result = 1;
			for (BrandCart cart : brandCarts) {
				if (cart.equals(brandCart)) {
					result = cart.addCommodity(commodity);
				}
			}
			return result;
		} else {
			if (cartNum < Constants.USER_MAX_CART_NUM) {
				int result = brandCart.addCommodity(commodity);
				brandCarts.add(brandCart);
				cartNum = cartNum + 1;
				return result;
			} else {
				return 3;
			}
		}
	}

	/**
	 * 购物车中删除商品
	 * 
	 * @Method_Name : deleteCommodity
	 * @param commodity
	 * @return : boolean true 删除商品成功 false 删除商品失败
	 * @Creation Date : 2014年6月16日 下午3:14:23
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public boolean deleteCommodity(Commodity commodity) {
		BrandCart brandCart = new BrandCart();
		brandCart.setBrandId(commodity.getBrandId());
		if (brandCarts.contains(brandCart)) {
			for (BrandCart cart : brandCarts) {
				if (cart.equals(brandCart)) {
					boolean r = cart.deleteCommodity(commodity);
					if (cart.getCommdityNum() == 0 && r) {
						boolean result = brandCarts.remove(cart);
						if (result) {
							cartNum = cartNum - 1;
							return true;
						}
					}
					if(cart.getCommdityNum()>0 && r){
						cartNum = cartNum - 1;
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 根据品牌ID获得品牌购物车
	 * 
	 * @Method_Name : getBrandCartByBrandId
	 * @param brandId
	 * @return
	 * @return : BrandCart
	 * @Creation Date : 2014年6月16日 下午3:20:49
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public BrandCart getBrandCartByBrandId(long brandId) {
		BrandCart brandCart = new BrandCart();
		brandCart.setBrandId(brandId);
		for (BrandCart cart : brandCarts) {
			if (brandCart.equals(cart)) {
				return cart;
			}
		}
		return null;
	}

	/**
	 * 根据品牌ID删除品牌购物车
	 * 
	 * @Method_Name : getBrandCartByBrandId
	 * @param brandId
	 * @return boolean true 删除成功 false 删除失败
	 * @return : BrandCart
	 * @Creation Date : 2014年6月16日 下午3:20:49
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public boolean deleteBrandCartByBrandId(long brandId) {
		BrandCart brandCart = new BrandCart();
		brandCart.setBrandId(brandId);
		boolean result = brandCarts.remove(brandCart);
		if (result) {
			cartNum = cartNum - 1;
			return true;
		}
		return false;
	}

	public List<BrandCart> getBrandCarts() {
		return brandCarts;
	}

	public int getCartNum() {
		if (brandCarts == null) {
			return cartNum;
		} else {
			return brandCarts.size();
		}
	}

	public UserCart(List<BrandCart> brandCarts, int cartNum) {
		super();
		this.brandCarts = brandCarts;
		this.cartNum = cartNum;
	}

	@Override
	public String toString() {
		return ("UserCart [brandCarts=" + brandCarts + ", cartNum="
				+ (brandCarts == null ? 0 : brandCarts.size()) + "]");
	}

	public UserCart() {
		super();
	}

}
