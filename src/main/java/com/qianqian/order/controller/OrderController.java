package com.qianqian.order.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.RedisConstants;
import com.framelib.common.SessionData;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.DateUtil;
import com.framelib.utils.SessionUtil;
import com.qianqian.apply.model.ApplyForm;
import com.qianqian.cart.bo.CartBO;
import com.qianqian.cart.bo.ProductBO;
import com.qianqian.member.model.RecieveAddress;
import com.qianqian.member.model.User;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.order.dto.CheckOrderResult;
import com.qianqian.order.dto.OrderDTO;
import com.qianqian.order.dto.OrderDetailDTO;
import com.qianqian.order.model.OrderChild;
import com.qianqian.order.model.Orders;
import com.qianqian.order.service.IOrderDubboService;
import com.qianqian.order.service.IOrderService;
import com.qianqian.order.utils.OrderConstants;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductPicture;
import com.qianqian.product.model.ProductStandard;
import com.qianqian.product.service.IProductDubboService;

/**
 * 订单的控制器
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.order.controller.OrderController.java
 * @ClassName : OrderController
 * @Author : shenzhenxing
 * @CreateDate : 2014年6月18日 上午11:30:38
 */
@RequestMapping("/order")
@Controller
public class OrderController {
	private Logger log = LoggerFactory.getLogger(OrderController.class);
	private static final String SUBMIT_ORDER = "order/submitOrder";// 提交订单页面
	private static final String SUBMIT_FREE_ORDER = "order/submitFreeOrder";// 提交免费订单页面
	private static final String NAKED_ORDER_DETAIL = "order/nakedOrderDetail";// 裸价体验订单详情页
	private static final String FREE_ORDER_DETAIL = "order/freeOrderDetail";// 裸价体验订单详情页
	@Resource
	private IRedisUtil redisUtil;
	/**
	 * 用户表操作service
	 */
	@Resource
	private IUserDubboService userDubboService;
	/**
	 * 订单操作service
	 */
	@Resource
	private IOrderService orderService;
	@Resource
	private IOrderDubboService orderDubboService;
	/**
	 * 产品信息操作service
	 */
	@Resource
	private IProductDubboService productDubboService;

	/**
	 * 前往提交订单页面
	 * 
	 * @Method_Name : toSubmitOrder
	 * @param codeVersions
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月18日 上午10:05:37
	 * @version : v1.00
	 * @Author : 
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("toSubmitOrder")
	public String toSubmitOrder(String isCost, long brandId, String brandName,
			ModelMap map) {
		log.debug("toSubmitOrder=>" + isCost);
		CartBO bo = createCartBO();
		if (StringUtils.isNotBlank(isCost)) {
			String[] codeVersions = isCost.replaceAll(" ", "").split(",");
			log.debug("codeVersions=" + Arrays.toString(codeVersions));
			int length = codeVersions.length;
			List<ProductBO> bos = new ArrayList<ProductBO>();
			for (int i = 0; i < length; i++) {
				ProductBO productBO = new ProductBO();
				String[] arr = codeVersions[i].split("-");
				long productCode = Long.valueOf(arr[0]);// 产品编码
				int version = Integer.valueOf(arr[1]);// 产品版本
				long standardId = Long.valueOf(arr[2]);// 商品规格编号
				long activityId = Long.valueOf(arr[3]);// 活动编号
				productBO.setProduct(productDubboService.getProduct(
						productCode, version));
				productBO.setActivity(productDubboService
						.getPrdActivity(activityId));
				ProductPicture picture = new ProductPicture();
				picture.setOrderPic(productDubboService.getOrderPic(
						productCode, version));
				productBO.setPicture(picture);
				productBO.setStandard(productDubboService.getGoods(standardId));
				bos.add(productBO);
			}
			if (bos != null) {
				bo.setProductBoList(bos);
			}
		}
		bo.setCodeVersions(isCost);
		bo.setBrandId(brandId);
		bo.setBrandName(brandName);
		bo.setType(OrderConstants.NAKED_TYPE);// 订单类型 0 裸价体验，1 免费试用
		if (userDubboService != null) {
			SessionData session = SessionUtil.getSessionData();
			long userId = session == null ? 110l : session.getId();
			log.debug("userId=" + userId);
			bo.setReceiver(userDubboService
					.getUserDefaultRecieveAddress(userId));
			bo.setReceiverList(userDubboService.getUserRecieveAddress(userId));
		}

		map.put("bo", bo);// 默认收货人信息
		return SUBMIT_ORDER;
	}

	// 生成测试数据
	private CartBO createCartBO() {
		CartBO bo = new CartBO();

		RecieveAddress address = new RecieveAddress();
		address.setRecieveAddressId(100l);
		address.setAddress("青年路盐城伊利19号楼503");
		address.setCityName("佛山市");
		address.setCity((short) 80);
		address.setDistrictName("高明区");
		address.setDistrict(750);
		address.setProvinceName("广东省");
		address.setProvince((byte) 6);
		address.setRecieveMobilephone("15001003696");
		address.setRecieveName("奥巴马");
		address.setRecieveTelephone("010-84875552");
		bo.setReceiver(address);

		List<ProductBO> list = new ArrayList<ProductBO>();
		for (int i = 0; i < 1; i++) {
			ProductBO productBo = new ProductBO();

			Product product = new Product();
			product.setBrandName("美似天仙");
			product.setProductName("美似胶原蛋白-" + i);
			product.setStandard("标准");
			product.setMarketPrice(new BigDecimal(180.6 + i));
			productBo.setProduct(product);

			ProductPicture picture = new ProductPicture();
			picture.setOrderPic("/group1/M00/00/29/wKgGblOWl9WW0NTXAABI7Hs4_9E287.jpg");
			productBo.setPicture(picture);

			ProductActivity activity = new ProductActivity();
			activity.setAgeMax( (12 + i));
			activity.setAgeMin( (2 + i));
			activity.setArea("大陆地区");
			// 不限
			activity.setAreaType(2);
			activity.setBrandNum( (2 + i));
			activity.setGender((1));
			activity.setUserType( (0 + i));
			activity.setGradeHigh( (26 + i));
			activity.setGradeLow((2 + i));
			activity.setPurpose("世界上最畅销的胶原蛋白，期待您的试用");
			activity.setPrice(new BigDecimal(68.8 + i));
			productBo.setActivity(activity);

			ProductStandard stand = new ProductStandard();
			stand.setColorName("红色");
			stand.setSizeName("42码");
			productBo.setStandard(stand);

			list.add(productBo);
		}
		bo.setProductBoList(list);

		List<RecieveAddress> addrs = new ArrayList<RecieveAddress>();
		for (int i = 0; i < 3; i++) {
			RecieveAddress addr = new RecieveAddress();
			addr.setRecieveAddressId((long) (12323 + i));
			addr.setAddress("五一路东方大厦31" + i);
			addr.setCityName("佛山市");
			addr.setCity((short) (80));
			addr.setDistrictName("高明区");
			addr.setDistrict(750);
			addr.setProvinceName("广东省");
			addr.setProvince((byte) (6));
			addr.setRecieveMobilephone("1500100369" + i);
			addr.setRecieveName("王重阳-" + i);
			addr.setRecieveTelephone("0758-6982154" + i);
			addrs.add(addr);
		}
		bo.setReceiverList(addrs);

		return bo;
	}

	/**
	 * 前往提交免费试用订单页面
	 * 
	 * @Method_Name : toSubmitFreeOrder
	 * @param codeVersions
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月6日 上午10:05:37
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("toSubmitFreeOrder")
	public String toSubmitFreeOrder(ApplyForm apply, ModelMap map) {
		log.debug("toSubmitOrder=>" + apply.toString());
		CartBO bo = createCartBO();
		List<ProductBO> bos = new ArrayList<ProductBO>();
		ProductBO productBO = new ProductBO();
		productBO.setProduct(productDubboService.getProduct(
				apply.getProductCode(), apply.getVersion()));
		productBO.setActivity(productDubboService.getPrdActivity(apply
				.getActiveId()));
		ProductPicture picture = new ProductPicture();
		picture.setOrderPic(productDubboService.getOrderPic(
				apply.getProductCode(), apply.getVersion()));
		productBO.setPicture(picture);
		productBO.setStandard(productDubboService.getGoods(apply
				.getStandardId()));
		bos.add(productBO);
		if (bos != null) {
			bo.setProductBoList(bos);
		}
		bo.setType(OrderConstants.FREE_TYPE);// 订单类型 0 裸价体验，1 免费试用
		bo.setBrandId(apply.getBrandCode());
		bo.setBrandName(apply.getBrandName());
		if (userDubboService != null) {
			SessionData session = SessionUtil.getSessionData();
			long userId = session == null ? 110l : session.getId();
			log.debug("userId=" + userId);
			bo.setReceiver(userDubboService
					.getUserDefaultRecieveAddress(userId));
			bo.setReceiverList(userDubboService.getUserRecieveAddress(userId));
		}
		bo.setApplyId(apply.getId());
		map.put("bo", bo);// 默认收货人信息
		return SUBMIT_FREE_ORDER;
	}

	/**
	 * 提交订单操作
	 * 
	 * 
	 * @Method_Name : addOrder
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月18日 上午11:33:37
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("addOrder")
	public String addOrder(OrderDTO orderDto, Model model,
			HttpServletRequest request) {
		log.debug("add order:" + orderDto);

		SessionData session = null;
		Orders order = null;
		CheckOrderResult result = new CheckOrderResult();
		Long userId = null;
		try {
			session = SessionUtil.getSessionData(request);
			if (session == null) {
				userId = 5l;
			} else {
				userId = session.getId();
			}

			// 判断是否可以可以提交订单
			if(orderDto.getType()==OrderConstants.NAKED_TYPE){
				result = orderService.isCanSubmitOrderForNaked(orderDto, userId);
			}
			if(orderDto.getType()==OrderConstants.FREE_TYPE){
				result = orderService.isCanSubmitOrderForFree(orderDto, userId);
			}
			// 不能提交,返回不能提交的原因
			if (!result.getResult()) {

				model.addAttribute("result", result);
				return null;
			}
			order = orderService.addOrder(orderDto, userId);
			
			
		} catch (Exception e) {
			//释放锁标记
			log.error(e.toString(),e);
		}

		model.addAttribute("result", result);// 订单提交成功返回1，失败0
		if (order != null) {
			String orderId = String.valueOf(order.getId());
			model.addAttribute("orderId", orderId);
			model.addAttribute("order", order);// 包含订单编号，订单金额，消耗体验宝数量
			if (order.getType() == OrderConstants.NAKED_TYPE) {
				model.addAttribute("orderCancelTime",
						DateUtil.format(
								DateUtil.addMinutes(order.getCreateTime(), 30), "yyyy/MM/dd HH:mm:ss"));// 订单自动取消时间
			}
			if (order.getType() == OrderConstants.FREE_TYPE) {
				
				model.addAttribute("orderCancelTime",
						DateUtil.format(
								DateUtil.addDay(order.getCreateTime(), 3), "yyyy/MM/dd HH:mm:ss"));// 订单自动取消时间
			}
		}
		return null;
	}

	/**
	 * 订单提交成功后跳转到去支付订单页面
	 * 
	 * @Method_Name : getOrderInfo
	 * @param model
	 * @param Orders
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月20日 上午11:00:29
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("toPayOrder")
	public String toPayOrder(Orders order, Date orderCancelTime, Model model) {
		log.debug("orderId----->" + order.getId());
		model.addAttribute("order", order);

		model.addAttribute("orderCancelTime", DateUtil.format(
				orderCancelTime, "yyyy/MM/dd HH:mm:ss"));
		return "order/payOrder";
	}

	/**
	 * 查看订单详情
	 * 
	 * @Method_Name : getOrderDetail
	 * @param code
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月4日 上午9:13:10
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("detail")
	public String getOrderDetail(long id, Model model,
			HttpServletRequest request) {
		SessionData session = null;
		try {
			session = SessionUtil.getSessionData(request);
		} catch (Exception e) {

		}
		Long userId = null;
		if (session == null) {
			userId = 5l;
		} else {
			userId = session.getId();
		}

		OrderDetailDTO detail = orderDubboService.getOrderDetail(id);

		User user = userDubboService.getUser(userId);
		model.addAttribute("userOrder", user);
		model.addAttribute("detail", detail);

		if (detail.getOrders().getType() == OrderConstants.FREE_TYPE) {
			log.debug("applyId---------------"
					+ detail.getChilds().get(0).getApplyId());
			return FREE_ORDER_DETAIL;
		}
		return NAKED_ORDER_DETAIL;
	}

}
