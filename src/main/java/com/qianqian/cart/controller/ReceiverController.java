package com.qianqian.cart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.qianqian.cart.bo.CartBO;
import com.qianqian.member.model.RecieveAddress;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.member.service.support.Result;

/**
 * 用户体验车提交订单时的收货人信息控制器
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.cart.controller.ReceiverController.java
 * @ClassName : ReceiverController
 * @Author : caozhifei
 * @CreateDate : 2014年6月20日 上午10:41:42
 */
@Controller
@RequestMapping("addr")
public class ReceiverController {
	private static Logger log = LoggerFactory
			.getLogger(ReceiverController.class);
	@Resource
	private IUserDubboService userDubboService;
	private static final String RECEIVER_DIV = "order/receiverList";// 没有任何商品的购物车页面

	/**
	 * 查询用户的收货地址列表
	 * 
	 * @Method_Name : getReceiverList
	 * @param receiverId
	 *            当前订单选择的收货人信息ID
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月20日 上午9:12:46
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getReceiverList")
	public String getReceiverList(long receiverId, ModelMap map) {
		CartBO bo = createCartBO();
		if (userDubboService != null) {
			SessionData session = SessionUtil.getSessionData();
			long userId = session == null ? 110l : session.getId();
			List<RecieveAddress> receiverList = userDubboService
					.getUserRecieveAddress(userId);
			bo.setReceiverList(receiverList);
		}
		RecieveAddress receiver = bo.getReceiver();
		receiver.setRecieveAddressId(receiverId);
		bo.setReceiver(receiver);
		log.debug("getReceiverList receiverId=" + receiverId);
		map.put("bo", bo);
		return RECEIVER_DIV;
	}

	/**
	 * 新增收货地址
	 * 
	 * @Method_Name : addAddress
	 * @param address
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月19日 下午1:02:19
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("addReceiver")
	public String addReceiver(RecieveAddress receiver, ModelMap map) {
		log.debug("addReceiver=" + receiver.getRecieveMobilephone());
		Result result = new Result(false, "已经超出限制");
		String receiverId = "12325";
		if (userDubboService != null) {
			SessionData session = SessionUtil.getSessionData();
			long userId = session == null ? 110l : session.getId();
			receiver.setCreateTime(new Date());
			receiver.setModifyTime(new Date());
			receiver.setDeleteFlag((byte) 0);// 是否删除 1 是，0否
			receiver.setIsDefaultAddress((byte) 0);// 是否默认地址
			receiver.setUserId(userId);
			result = userDubboService.canAddNewAddress(userId);
			if (result.getStatus()) {
				receiver = userDubboService.addUserRecieveAddress(userId,
						receiver);
				receiverId = String.valueOf(receiver.getRecieveAddressId());
			}
		}
		log.debug("addReceiver return receiverId=" + receiverId);
		map.put("result", result);
		map.put("receiverId", receiverId);
		return null;
	}

	/**
	 * 修改收货地址
	 * 
	 * @Method_Name : updateAddress
	 * @param address
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月19日 下午1:06:56
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("updateReceiver")
	public String updateReceiver(RecieveAddress receiver, ModelMap map) {
		log.debug("updateReceiver=" + receiver.getRecieveAddressId());
		Result result = new Result(true, "修改成功");
		String receiverId = "12324";
		if (userDubboService != null) {
			SessionData session = SessionUtil.getSessionData();
			long userId = session == null ? 110l : session.getId();
			receiver.setUserId(userId);
			receiver.setModifyTime(new Date());
			result = userDubboService.updateUserRecieveAddress(receiver);
			receiverId = String.valueOf(receiver.getRecieveAddressId());
		}
		log.debug("updateReceiver receiverId=" + receiverId);
		map.put("result", result);
		map.put("receiverId", receiverId);
		return null;
	}

	// 生成测试数据
	private CartBO createCartBO() {
		CartBO bo = new CartBO();

		RecieveAddress address = new RecieveAddress();
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
		List<RecieveAddress> addrs = new ArrayList<RecieveAddress>();
		for (int i = 0; i < 3; i++) {
			RecieveAddress addr = new RecieveAddress();
			addr.setRecieveAddressId((long) (12323 + i));
			addr.setAddress("青年路世丰国际大厦60" + i);
			addr.setCityName("佛山市");
			addr.setCity((short) (80));
			addr.setDistrictName("高明区");
			addr.setDistrict(750);
			addr.setProvinceName("广东省");
			addr.setProvince((byte) (6));
			addr.setRecieveMobilephone("1860100369" + i);
			addr.setRecieveName("郭靖-" + i);
			addr.setRecieveTelephone("0368-8682154" + i);
			addrs.add(addr);
		}
		bo.setReceiverList(addrs);

		return bo;
	}
}
