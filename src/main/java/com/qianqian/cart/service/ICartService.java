package com.qianqian.cart.service;

import com.qianqian.cart.model.BrandCart;
import com.qianqian.cart.model.Commodity;
import com.qianqian.cart.model.UserCart;

/**
 * 用户体验车操作service
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.cart.service.ICartService.java
 * @ClassName	: ICartService 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年6月16日 下午1:45:51
 */
public interface ICartService {
	/**
	 * 添加商品到用户购物车
	 *  @Method_Name    : addCart
	 *  @param commodity
	 *  @return 
	 *  @return         : int 1,添加成功；2,商品已经存在；3,已经达到购物车数量最大值
	 *  @Creation Date  : 2014年6月16日 下午1:52:34
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public int addCommodityToCart(Commodity commodity);
	/**
	 * 从购物车中删除商品
	 *  @Method_Name    : deleteCart
	 *  @param commodity 
	 *  @return 
	 *  @return         : int 1  操作成功
	 *  @Creation Date  : 2014年6月16日 下午1:52:45
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public boolean deleteCommodityFromCart(Commodity commodity);
	/**
	 * 根据品牌ID移除购物车
	 *  @Method_Name    : clearCart
	 *  @param brandId
	 *  @return 
	 *  @return         : int 1  操作成功
	 *  @Creation Date  : 2014年6月16日 下午1:53:02
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public boolean removeCartByBrandId(long brandId);
	/**
	 * 清空用户所有购物车
	 *  @Method_Name    : removeAllCart
	 *  @return 
	 *  @return         : long
	 *  @Creation Date  : 2014年6月17日 上午9:13:00
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public boolean removeAllCart();
	/**
	 * 获取用户的购物车
	 *  @Method_Name    : getUserCart
	 *  @return 
	 *  @return         : UserCart
	 *  @Creation Date  : 2014年6月16日 下午4:15:27
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public UserCart getUserCart();
	/**
	 * 根据品牌ID获取该品牌的购物车
	 *  @Method_Name    : getBrandCartByBrandId
	 *  @param brandId
	 *  @return 
	 *  @return         : BrandCart
	 *  @Creation Date  : 2014年6月16日 下午4:15:38
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public BrandCart getBrandCartByBrandId(long brandId);
}
