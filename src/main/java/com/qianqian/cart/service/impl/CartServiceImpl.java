package com.qianqian.cart.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.framelib.common.RedisConstants;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.SessionUtil;
import com.qianqian.cart.model.BrandCart;
import com.qianqian.cart.model.Commodity;
import com.qianqian.cart.model.UserCart;
import com.qianqian.cart.service.ICartService;

/**
 * 用户体验车service方法实现类
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.cart.service.impl.CartServiceImpl.java
 * @ClassName : CartServiceImpl
 * @Author : caozhifei
 * @CreateDate : 2014年6月16日 下午1:55:40
 */
@Service("cartService")
public class CartServiceImpl implements ICartService {
	private static Logger log = LoggerFactory.getLogger(CartServiceImpl.class);
	@Resource
	private IRedisUtil redisUtil;

	/**
	 * 添加商品到用户购物车
	 * 
	 * @Method_Name : addCart
	 * @param commodity
	 * @return
	 * @return : int 1,添加成功；2,商品已经存在；3,已经达到购物车数量最大值
	 * @Creation Date : 2014年6月16日 下午1:52:34
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public int addCommodityToCart(Commodity commodity) {
		String cartKey = RedisConstants.USER_CART_KEY; 
		String cartHashKey = null;
		if (SessionUtil.getSessionData() != null) {
			cartHashKey = String.valueOf(SessionUtil.getSessionData().getId());
		} else {
			cartHashKey = "101";
		}
		boolean isExist = redisUtil.hexists(cartKey, cartHashKey);
		int result = 1;
		if (isExist) {
			// 用户购物车在redis中已经存在
			UserCart userCart = (UserCart) redisUtil.hget(cartKey, cartHashKey);
			result = userCart.addCommodity(commodity);
			log.debug(userCart.toString());
			redisUtil.hset(cartKey, cartHashKey, userCart);
		} else {
			// 用户购物车在redis中不存在
			UserCart userCart = new UserCart();
			result = userCart.addCommodity(commodity);
			log.debug(userCart.toString());
			redisUtil.hset(cartKey, cartHashKey, userCart);
		}
		return result;
	}

	/**
	 * 从购物车中删除商品
	 * 
	 * @Method_Name : deleteCart
	 * @param commodity
	 * @return
	 * @return : int 1 操作成功
	 * @Creation Date : 2014年6月16日 下午1:52:45
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean deleteCommodityFromCart(Commodity commodity) {
		String cartKey = RedisConstants.USER_CART_KEY;
		String cartHashKey = null;
		if (SessionUtil.getSessionData() != null) {
			cartHashKey = String.valueOf(SessionUtil.getSessionData().getId());
		} else {
			cartHashKey = "101";
		}
		UserCart userCart = (UserCart) redisUtil.hget(cartKey, cartHashKey);
		boolean result = userCart.deleteCommodity(commodity);
		log.debug(userCart.toString());
		redisUtil.hset(cartKey, cartHashKey, userCart);
		return result;
	}

	/**
	 * 根据品牌ID移除购物车
	 * 
	 * @Method_Name : clearCart
	 * @param brandId
	 * @return
	 * @return : int 1 操作成功
	 * @Creation Date : 2014年6月16日 下午1:53:02
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean removeCartByBrandId(long brandId) {
		String cartKey = RedisConstants.USER_CART_KEY;
		String cartHashKey = null;
		if (SessionUtil.getSessionData() != null) {
			cartHashKey = String.valueOf(SessionUtil.getSessionData().getId());
		} else {
			cartHashKey = "101";
		}
		UserCart userCart = (UserCart) redisUtil.hget(cartKey, cartHashKey);
		boolean result = userCart.deleteBrandCartByBrandId(brandId);
		log.debug(userCart.toString());
		redisUtil.hset(cartKey, cartHashKey, userCart);
		return result;
	}

	/**
	 * 获取用户的购物车
	 * 
	 * @Method_Name : getUserCart
	 * @return
	 * @return : UserCart
	 * @Creation Date : 2014年6月16日 下午4:15:27
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public UserCart getUserCart() {
		String cartKey = RedisConstants.USER_CART_KEY;
		String cartHashKey = null;
		if (SessionUtil.getSessionData() != null) {
			cartHashKey = String.valueOf(SessionUtil.getSessionData().getId());
		} else {
			cartHashKey = "101";
		}
		UserCart userCart = (UserCart) redisUtil.hget(cartKey, cartHashKey);
		return userCart;
	}

	/**
	 * 根据品牌ID获取该品牌的购物车
	 * 
	 * @Method_Name : getBrandCartByBrandId
	 * @param brandId
	 * @return
	 * @return : BrandCart
	 * @Creation Date : 2014年6月16日 下午4:15:38
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public BrandCart getBrandCartByBrandId(long brandId) {
		String cartKey = RedisConstants.USER_CART_KEY;
		String cartHashKey = null;
		if (SessionUtil.getSessionData() != null) {
			cartHashKey = String.valueOf(SessionUtil.getSessionData().getId());
		} else {
			cartHashKey = "101";
		}
		UserCart userCart = (UserCart) redisUtil.hget(cartKey, cartHashKey);
		BrandCart brandCart = userCart.getBrandCartByBrandId(brandId);
		return brandCart;
	}

	/**
	 * 清空用户所有购物车
	 * 
	 * @Method_Name : removeAllCart
	 * @return
	 * @return : long
	 * @Creation Date : 2014年6月17日 上午9:13:00
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean removeAllCart() {
		String cartKey = RedisConstants.USER_CART_KEY;
		String cartHashKey = null;
		if (SessionUtil.getSessionData() != null) {
			cartHashKey = String.valueOf(SessionUtil.getSessionData().getId());
		} else {
			cartHashKey = "101";
		}
		long result = redisUtil.hdel(cartKey, cartHashKey);
		if(result >0){
			return true;
		}else{
			return false;
		}
	}

}
