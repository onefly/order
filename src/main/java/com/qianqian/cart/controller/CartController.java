package com.qianqian.cart.controller;

import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.qianqian.cart.model.BrandCart;
import com.qianqian.cart.model.Commodity;
import com.qianqian.cart.model.UserCart;
import com.qianqian.cart.service.ICartService;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.product.service.IProductDubboService;

/**
 * 用户体验车的控制器
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.cart.controller.CartController.java
 * @ClassName : CartController
 * @Author : caozhifei
 * @CreateDate : 2014年6月20日 上午10:41:16
 */
@Controller
@RequestMapping("cart")
public class CartController {
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	private static final String EMPTY_CART = "cart/emptyCart";// 没有任何商品的购物车页面
	private static final String USER_CART = "cart/userCart";// 有商品的购物车页面
	private static final String BRAND_CART = "cart/brandCart";// 品牌购物车商品列表页面
	/**
	 * 购物车操作service
	 */
	@Resource
	private ICartService cartService;
	/**
	 * 收货人信息操作service
	 */
	@Resource
	private IUserDubboService userDubboService;
	/**
	 * 产品信息操作service
	 */
	@Resource
	private IProductDubboService productDubboService;

	/**
	 * 查询用户购物车
	 * 
	 * @Method_Name : getUserCart
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月17日 下午2:04:13
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getUserCart")
	public String getUserCart(ModelMap map) {
		UserCart cart = cartService.getUserCart();
		if (null == cart) {
			log.debug("userCart is null !!!");
			return EMPTY_CART;
		}
		log.debug(cart.toString());
		map.put("userCart", cart);
		if (cart.getCartNum() > 0) {
			return USER_CART;
		} else {
			return EMPTY_CART;
		}

	}

	/**
	 * 根据品牌ID删除品牌购物车
	 * 
	 * @Method_Name : deleteBrandCart
	 * @param brandId
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月17日 下午2:37:17
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("deleteBrandCart")
	public String deleteBrandCart(long brandId) {
		cartService.removeCartByBrandId(brandId);
		return "redirect:/cart/getUserCart.htm";
	}

	/**
	 * 根据品牌ID查询品牌体验车和车内的商品列表
	 * 
	 * @Method_Name : getBrandCart
	 * @param brandId
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月17日 下午2:57:17
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getBrandCart")
	public String getBrandCart(Long brandId, ModelMap map) {
		log.debug("brandId=" + brandId);
		BrandCart brandCart = cartService.getBrandCartByBrandId(brandId);
		if (brandCart == null) {
			return "redirect:/cart/getUserCart.htm";
		}
		int remainIngot = 0;
		if (userDubboService != null) {
			SessionData session = SessionUtil.getSessionData();
			long userId = session == null ? 110l : session.getId();
			remainIngot = userDubboService.getUserIngot(userId);
		}
		map.put("brandCart", brandCart);
		map.put("remainIngot", remainIngot);
		return BRAND_CART;
	}

	/**
	 * 从购物车中删除商品 productCode,naked,ingot, brandId不能为空
	 * 
	 * @Method_Name : deleteCommotity
	 * @param commodity
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月17日 下午3:31:06
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("deleteCommotity")
	public String deleteCommotity(Commodity commodity, ModelMap map) {
		log.debug(commodity.toString());
		boolean result = cartService.deleteCommodityFromCart(commodity);
		map.put("result", result);
		return null;
	}

	/**
	 * 判断是否可以前往提交订单页面 result ,1 表示验证通过
	 * 
	 * @Method_Name : checkSubmitOrderState
	 * @param isCosts
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月18日 上午10:31:26
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping(value = "checkSubmitOrderState", method = RequestMethod.POST)
	public String checkSubmitOrderState(String isCost, Long brandId,
			String brandName, ModelMap map) {
		log.debug("checkisCosts=" + isCost);
		if (StringUtils.isNotBlank(isCost)) {
			String[] codeVersions = isCost.replaceAll(" ", "").split(",");
			log.debug("checkcodeVersions=" + Arrays.toString(codeVersions));
			int length = codeVersions.length;
			long[] codes = new long[length];
			int[] versions = new int[length];
			long[] standardIds = new long[length];
			for (int i = 0; i < length; i++) {
				String[] arr = codeVersions[i].split("-");
				codes[i] = Long.valueOf(arr[0]);
				versions[i] = Integer.valueOf(arr[1]);
				standardIds[i]=Long.valueOf(arr[2]);
			}
			log.debug("checkcodes=" + Arrays.toString(codes));
			log.debug("checkversions=" + Arrays.toString(versions));
			map.put("result", 1);
		} else {
			map.put("result", 0);
		}
		return null;
	}

	/**
	 * 添加商品到对应的品牌购物车中
	 * 
	 * @Method_Name : addToCart
	 * @param commodity
	 *            商品信息
	 * @param map
	 * @return int 1,添加成功；2,商品已经存在；3,已经达到购物车数量最大值
	 * @return : String
	 * @Creation Date : 2014年6月19日 上午9:11:36
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("addToCart")
	public String addToCart(Commodity commodity, ModelMap map) {
		int result = cartService.addCommodityToCart(commodity);
		map.put("result", result);// int 1,添加成功；2,商品已经存在；3,已经达到购物车数量最大值
		return USER_CART;
	}
}
