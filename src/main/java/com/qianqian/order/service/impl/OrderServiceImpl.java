package com.qianqian.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.framelib.common.RedisConstants;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.DateUtil;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.qianqian.apply.mapper.ApplyFormMapper;
import com.qianqian.apply.mapper.ApplyHandleLogMapper;
import com.qianqian.apply.model.ApplyForm;
import com.qianqian.apply.model.ApplyHandleLog;
import com.qianqian.apply.util.ApplyConstants;
import com.qianqian.ba.service.IBusinessActivityLogService;
import com.qianqian.cart.model.Commodity;
import com.qianqian.cart.service.ICartService;
import com.qianqian.member.model.User;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.order.dto.CheckOrderResult;
import com.qianqian.order.dto.JudgeResult;
import com.qianqian.order.dto.OrderDTO;
import com.qianqian.order.dto.ProductDTO;
import com.qianqian.order.mapper.OrderChildMapper;
import com.qianqian.order.mapper.OrderLogMapper;
import com.qianqian.order.mapper.OrdersMapper;
import com.qianqian.order.model.OrderChild;
import com.qianqian.order.model.OrderLog;
import com.qianqian.order.model.Orders;
import com.qianqian.order.service.IOrderService;
import com.qianqian.order.utils.ProductConstants;
import com.qianqian.order.utils.TimerConstants;
import com.qianqian.order.utils.UserConstants;
import com.qianqian.order.utils.OrderConstants;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductStandard;
import com.qianqian.product.service.IProductDubboService;

/**
 * 本地订单接口的实现
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.order.service.impl.OrderServiceImpl.java
 * @ClassName : OrderServiceImpl
 * @Author : shenzhenxing
 * @CreateDate : 2014年6月19日 下午2:33:09
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	private Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Resource
	private ApplyFormMapper applyFormMapper;
	@Resource
	private IUserDubboService userDubboService;
	@Resource
	private OrdersMapper ordersMapper;
	@Resource
	private OrderChildMapper orderChildMapper;
	@Resource
	private OrderLogMapper orderLogMapper;
	@Resource
	private IProductDubboService productDubboService;
	@Resource
	private IRedisUtil redisUtil;
	@Resource
	private ApplyHandleLogMapper applyHandleLogMapper;
	@Resource
	private IBusinessActivityLogService businessActivityLogService;
	@Resource
	private ICartService cartService;

	/**
	 * 生成订单
	 * 
	 * @Method_Name : addOrder
	 * @param orderDto
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return : Orders
	 * @Creation Date : 2014年6月24日 下午2:01:18
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public Orders addOrder(OrderDTO orderDto, Long userId) throws Exception {
		// 获得用户信息
		User user = userDubboService.getUser(userId);
		// 封装子订单
		OrderChild orderChild = formOrderChild(orderDto, user);

		// 封装大订单
		Orders order = formOrder(orderChild, orderDto, user);
		ordersMapper.insert(order);
		// 订单id
		Long orderId = order.getId();

		// 保存主订单日志
		OrderLog record = buildOrderLog(OrderConstants.OPERATOR_TYPE_BUYER,
				orderId, null, "用户提交订单", OrderConstants.STATE_WAIT_PAY,
				OrderConstants.TYPE_MAIN_ORDER, OrderConstants.TYPE_MAIN_ORDER,
				order.getCreateTime());

		orderLogMapper.insert(record);

		// 继续封装子订单的属性
		// 预计付款时间
		if (orderDto.getType() == OrderConstants.FREE_TYPE) {
			orderChild.setCrontabTime(DateUtil.addDay(
					order.getCreateTime(), TimerConstants.FREE_BUYER_PAY_TIME));
		}
		if (orderDto.getType() == OrderConstants.NAKED_TYPE) {
			orderChild
					.setCrontabTime(DateUtil.addMinutes(
							order.getCreateTime(),
							TimerConstants.NAKED_BUYER_PAY_TIME));
		}
		orderChild.setOrderId(orderId);
		orderChild.setOrderCreateTime(order.getCreateTime());
		// 保存子订单
		orderChildMapper.insert(orderChild);
		// 加锁标记，
		redisUtil.set(RedisConstants.REDIS_SUBMIT_ORDER_FLAG + userId + ":"
				+ orderChild.getPrdCode(),
				String.valueOf(System.currentTimeMillis()));

		// 如果是免费试用，需要更新申请单的状态
		if (orderChild.getType() == OrderConstants.FREE_TYPE) {
			ApplyForm apply = new ApplyForm();
			apply.setId(orderDto.getApplyId());
			apply.setSubmitState(ApplyConstants.ALREADY_SUBMIT);
			apply.setSubmitOrderTime(new Date());
			applyFormMapper.updateByPrimaryKeySelective(apply);
			// 记录申请单处理日志
			ApplyHandleLog handleLog = new ApplyHandleLog();
			handleLog.setApplyId(orderDto.getApplyId());
			handleLog.setHandleBy(ApplyConstants.HANDLE_BY_ME);
			handleLog.setHandleNote(ApplyConstants.HANDLE_STEP_4);
			handleLog.setHandleById(userId);
			handleLog.setHandleTime(new Date());
			int handleResult = applyHandleLogMapper.insert(handleLog);

		}

		// 保存日志
		OrderLog log = buildOrderLog(OrderConstants.OPERATOR_TYPE_BUYER,
				orderId, orderChild.getId(), "用户下单",
				OrderConstants.STATE_WAIT_PAY,
				OrderConstants.OPERATION_TYPE_ADD_ORDER,
				OrderConstants.TYPE_MAIN_ORDER, order.getCreateTime());
		orderLogMapper.insert(log);

		// 扣除库存
		Boolean a = productDubboService.modifyGoodsStore(
				orderChild.getPrdCode(), orderChild.getPrdVersion(),
				orderChild.getPrdStandardId(), 1, orderChild.getType());
		// 扣除体验宝
		userDubboService.deductIngot(userId, 1);
		// 增加品牌累计体验人数
		redisUtil.hincrBy(RedisConstants.BRAND_COUNT_EXPERIENCE,
				String.valueOf(orderDto.getBrandId()), (long) 1);

		return order;
	}

	/**
	 * 封装日志对象
	 * 
	 * @Method_Name : buildOrderLog
	 * @param orderId
	 * @param orderChildId
	 * @param remark
	 * @param currentState
	 * @param operationType
	 * @param orderType
	 * @param operationDate
	 * @return
	 * @return : OrderLog
	 * @Creation Date : 2014年10月20日 下午5:08:06
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private OrderLog buildOrderLog(int operationPlatfrorm, Long orderId,
			Long orderChildId, String remark, int currentState,
			int operationType, int orderType, Date operationDate) {
		OrderLog record = new OrderLog();
		record.setOrderType(orderType);
		record.setOperationDate(operationDate);
		record.setOperationPlatform(operationPlatfrorm);
		record.setOperationType(operationType);
		record.setRemark(remark);
		record.setOrderId(orderId);
		record.setOrderCurrentState(currentState);
		record.setOrderChildId(orderChildId);
		return record;
	}

	/**
	 * 封装主订单属性
	 * 
	 * @Method_Name : formOrder
	 * @param orderChild
	 * @param orderDto
	 * @param user
	 * @return
	 * @return : Orders
	 * @Creation Date : 2014年10月20日 下午5:01:30
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private Orders formOrder(OrderChild orderChild, OrderDTO orderDto, User user) {
		Orders order = new Orders();
		// 单产品
		order.setParentId(null);
		order.setIsMoreProduct(OrderConstants.IS_SINGLE_PRODUCT);
		order.setOrderFund(orderChild.getActiPrice());
		order.setAddrFullAddress(orderDto.getAddrFullAddress());

		order.setAddrRecieveMobile(orderDto.getAddrRecieveMobile());
		order.setAddrRecieveName(orderDto.getAddrRecieveName());
		order.setAddrRecievePhone(orderDto.getAddrRecievePhone());
		order.setAddrZipCode(orderDto.getAddrZipCode());
		order.setType(orderDto.getType());
		order.setRemark(orderDto.getRemark());
		// 订单编号

		order.setCreateTime(new Date());
		order.setBuyerId(user.getUserId());
		order.setBuyerNickname(user.getNickname());
		// 子订单的数量
		order.setChildOrderCount(1);

		order.setInvoiceContent(orderDto.getInvoiceContent());
		order.setInvoiceTitle(orderDto.getInvoiceTitle());
		order.setInvoiceType(orderDto.getInvoiceType());
		// 体验宝数量
		order.setPayIngotNum(1);
		// 支付方式支付完成才有

		order.setType(orderDto.getType());

		return order;
	}

	/**
	 * 封装子订单
	 * 
	 * @Method_Name : formOrderChild
	 * @param orderDto
	 * @param user
	 * @return
	 * @return : OrderChild
	 * @Creation Date : 2014年10月20日 下午4:51:26
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private OrderChild formOrderChild(OrderDTO orderDto, User user) {

		OrderChild orderChild = orderDto.getOrderChild();
		// 封装子订单
		Long productCode = orderChild.getPrdCode();
		int version = orderChild.getPrdVersion();
		Long standardID = orderChild.getPrdStandardId();
		Long activityId = orderChild.getActivityId();
		Product p = productDubboService.getProduct(productCode, version);
		ProductActivity activity = productDubboService
				.getPrdActivity(activityId);
		String productPicture = productDubboService.getOrderPic(productCode,
				version);
		ProductStandard standard = productDubboService.getGoods(standardID);

		orderChild.setActiAgeMax(activity.getAgeMax());
		orderChild.setActiAgeMin(activity.getAgeMin());
		orderChild.setActiAreaType(activity.getAreaType());
		orderChild.setActiArea(activity.getArea());
		orderChild.setActiAreaId(activity.getAreaId());

		orderChild.setActiBrandNum(activity.getBrandNum());
		orderChild.setActiGender(activity.getGender());
		orderChild.setActiGradeHigh(activity.getGradeHigh());
		orderChild.setActiGradeLow(activity.getGradeLow());
		orderChild.setActiPrice(activity.getPrice());
		orderChild.setActiPurpose(activity.getPurpose());
		orderChild.setActiUserType(activity.getUserType());
		orderChild.setActivityId(activity.getId());
		orderChild.setApplyId(orderDto.getApplyId());
		// 提交报告的天数
		orderChild.setActiReportDay(activity.getReportDay());
		orderChild.setBuyerId(user.getUserId());
		orderChild.setBuyerNickname(user.getNickname());

		// 体验宝
		orderChild.setPayIngotNum(1);
		orderChild.setOricount(1);
		orderChild.setPrdBrandId(orderDto.getBrandId());
		orderChild.setPrdBrandName(orderDto.getBrandName());
		// 冗余的类目id和name，目前是三级类目
		orderChild.setPrdCategoryId(p.getCategoryId2());
		orderChild.setPrdCategoryName(p.getCategoryName2());
		orderChild.setPrdId(p.getId());
		orderChild.setPrdMarketPrice(p.getMarketPrice());
		orderChild.setPrdName(p.getProductName());
		orderChild.setPrdPic(productPicture);
		orderChild.setPrdSeriesId(p.getSeriesId());
		orderChild.setPrdSeriesName(p.getSeriesName());
		orderChild.setPrdStandard(p.getStandard());
		orderChild.setPrdStandardId(standard.getId());
		orderChild.setPrdVersion(version);
		orderChild.setStanColorCode(standard.getColorCode());
		orderChild.setStanColorName(standard.getColorName());
		orderChild.setStanSizeCode(standard.getSizeCode());
		orderChild.setStanSizeName(standard.getSizeName());
		// 待付款状态
		orderChild.setState(OrderConstants.STATE_WAIT_PAY);
		orderChild.setType(orderDto.getType());

		return orderChild;

	}

	@Override
	public JudgeResult isCanExpOrTry(Long prdCode, int version, Long userId,
			Long brandId, Long activityId, int type) {
		JudgeResult result = new JudgeResult();
		Boolean first = isFirstExperience(userId, prdCode);
		// 如果初次体验，继续判断是否符合活动标准
		if (first) {
			result = isSuitActivityStandard(prdCode, version, userId, brandId,
					activityId);
			result.setFirst(true);
		}
		// 如果不是初次体验，直接返回，不进行活动标准的判断
		if (!first) {
			result.setResult(false);
			result.setFirst(false);
		}

		log.info("用户id" + userId + "---产品code" + prdCode + "---版本" + version
				+ "活动标准判断结果：" + result);
		return result;
	}

	private JudgeResult isSuitActivityStandard(Long prdCode, int version,
			Long userId, Long brandId, Long activityId) {
		JudgeResult result = new JudgeResult();
		ProductActivity act = productDubboService.getPrdActivity(activityId);
		User user = userDubboService.getUser(userId);
		// 如果当前用户角色
		result.setRole(isRole(act, user));
		// 判断品牌勋章
		result.setMedal(isMedal(userId, brandId, act));
		// 判断参与地区
		result.setArea(isArea(user, act));
		// 判断年龄
		result.setAge(isAge(user, act));
		// 判断性别
		result.setGender(isGender(user, act));
		// 体验等级
		result.setLevel(islevel(user, act));
		// 如果有一项false，则不符合活动标准
		if (result.toString().contains("false")) {
			result.setResult(false);
		} else {
			result.setResult(true);
		}

		return result;
	}

	/**
	 * 判断裸价体验订单是否可以提交
	 * 
	 * @Method_Name : isCanSubmitOrderForNaked
	 * @param orderDto
	 * @param userId
	 * @return
	 * @return : CheckOrderResult
	 * @Creation Date : 2014年10月15日 上午9:22:37
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	public CheckOrderResult isCanSubmitOrderForNaked(OrderDTO orderDto,
			Long userId) {
		CheckOrderResult result = new CheckOrderResult();
		OrderChild orderChild = orderDto.getOrderChild();

		// 单商品

		// TODO
		ProductDTO dto = new ProductDTO();
		Long prdCode = orderChild.getPrdCode();
		int version = orderChild.getPrdVersion();
		// Long standardID = orderChild.getPrdStandardId();
		Long activityId = orderChild.getActivityId();
		Long brandId = orderDto.getBrandId();

		// Product p = productDubboService.getProduct(prdCode, version);
		// ProductStandard stan = productDubboService.getGoods(standardID);
		// ProductActivity activity = productDubboService
		// .getPrdActivity(activityId);
		// 判断是否已经下过订单
		result.setSubmitOrder(isSubmitOrder(prdCode, userId));

		// 判断是否符合活动标准
		result.setJudgeResult(isSuitActivityStandard(prdCode, version, userId,
				brandId, activityId));

		// 判断库存是否足够
		result.setRepertory(isRepertory(dto));

		// 判断活动是否已经结束
		result.setActivityOver(isActivityOver(dto));

		// 判断用户体验宝数量是否足够
		result.setIngotCount(isIngotCount(1, userId));

		// 整体判断，是否能下单
		if (result.getSubmitOrder() && result.getJudgeResult().getResult()
				&& result.getRepertory() && result.getActivityOver()
				&& result.getIngotCount()) {
			result.setResult(true);
		} else {
			result.setResult(false);
		}

		log.info("用户id" + userId + "产品code：" + orderChild.getPrdCode()
				+ "判断结果：" + result);
		return result;
	}

	/**
	 * 判断免费试用订单是否可以提交
	 * 
	 * @Method_Name : isCanSubmitOrderForFree
	 * @param orderDto
	 * @param userId
	 * @return
	 * @return : CheckOrderResult
	 * @Creation Date : 2014年10月15日 上午9:23:17
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	public CheckOrderResult isCanSubmitOrderForFree(OrderDTO orderDto,
			Long userId) {
		CheckOrderResult result = new CheckOrderResult();

		OrderChild orderChild = orderDto.getOrderChild();

		Long activityId = orderChild.getActivityId();

		ProductActivity activity = productDubboService
				.getPrdActivity(activityId);
		// 判断是否已经下过单
		result.setSubmitOrder(isSubmitOrder(orderChild.getPrdCode(), userId));
		// 判断是否处于订单提交期
		result.setInSubmitTime(isInSubmitTime(orderChild.getApplyId(), activity));
		// 判断用户体验宝数量是否足够
		result.setIngotCount(isIngotCount(1, userId));

		log.info("用户id" + userId + "产品code：" + orderChild.getPrdCode()
				+ "判断结果：" + result);
		return result;
	}

	/**
	 * 判断用户角色是否符合
	 * 
	 * @Method_Name : isRole
	 * @param act
	 * @param user
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年8月22日 上午11:25:42
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isRole(ProductActivity act, User user) {
		boolean result = false;
		int userType = act.getUserType();
		int role = user.getRole();
		if (UserConstants.USER_TYPE_PRDMAN == role
				&& UserConstants.USER_TYPE_EXT == role) {
			result = true;
			return result;
			// 如果不是，判断用户类别
		} else if (role >= userType) {
			result = true;
		}

		return result;
	}

	/**
	 * 判断地区是否符合
	 * 
	 * @Method_Name : isArea
	 * @param user
	 * @param act
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年8月22日 上午11:25:31
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isArea(User user, ProductActivity act) {
		boolean result = true;
		int AreaType = act.getAreaType();
		String area = act.getArea();
		String userArea = user.getProvinceName();

		if (AreaType == ProductConstants.AREA_TYPE_NOT_LIMIT) {
			result = true;

		} else if (AreaType == ProductConstants.AREA_TYPE_UNINCLUDE) {
			String[] actAreas = area.split(",");
			for (int i = 0; i < actAreas.length; i++) {
				if (actAreas[i].equals(userArea)) {
					result = false;
					break;
				}
			}
		} else if (AreaType == ProductConstants.AREA_TYPE_INCLUDE) {
			String[] actAreas = area.split(",");
			for (int i = 0; i < actAreas.length; i++) {
				if (actAreas[i].equals(userArea)) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		}
		return result;

	}

	/**
	 * 判断勋章数是否足够
	 * 
	 * @Method_Name : isMedal
	 * @param userId
	 * @param brandId
	 * @param act
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年8月22日 上午11:25:02
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isMedal(Long userId, Long brandId, ProductActivity act) {
		boolean result = false;
		int medalCount = userDubboService.getUserBrandMedalCount(userId,
				brandId);
		if (medalCount >= act.getBrandNum()) {
			result = true;
		}

		return result;
	}

	/**
	 * 判断用户年龄
	 * 
	 * @Method_Name : isAge
	 * @param user
	 * @param act
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年8月22日 上午11:24:48
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isAge(User user, ProductActivity act) {
		boolean result = false;

		int age = DateUtil.getAgeByIdCard(user.getIdentification());
		if (age >= act.getAgeMin() || age <= act.getAgeMax()) {
			result = true;
		}
		return result;
	}

	/**
	 * 判断用户性别
	 * 
	 * @Method_Name : isGender
	 * @param user
	 * @param act
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年8月22日 上午11:24:39
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isGender(User user, ProductActivity act) {
		boolean result = false;
		int gender = act.getGender();
		if (gender == UserConstants.USER_SEX_NOT_LIMIT) {
			result = true;

		} else {
			if (user.getGender() == gender) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * 判断用户等级
	 * 
	 * @Method_Name : islevel
	 * @param user
	 * @param act
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年8月22日 上午11:24:23
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean islevel(User user, ProductActivity act) {
		boolean result = false;
		if (user.getLevel() >= act.getGradeLow()
				|| user.getLevel() <= act.getGradeHigh()) {
			result = true;
		}
		return result;
	}

	/**
	 * 判断是否重复下单
	 * 
	 * @Method_Name : isSubmitOrder
	 * @param dtos
	 * @param userId
	 * @param orderDto
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年8月22日 上午11:24:01
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isSubmitOrder(Long prdCode, Long userId) {

		boolean result = true;

		StringBuilder sb = null;
		sb = new StringBuilder(RedisConstants.REDIS_SUBMIT_ORDER_FLAG);
		sb.append(userId).append(":").append(prdCode);
		result = redisUtil.getFlag(sb.toString());

		return result;
	}

	/**
	 * 判断库存是否足够
	 * 
	 * @Method_Name : isRepertory
	 * @param dtos
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年10月14日 下午4:12:53
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isRepertory(ProductDTO prdDto) {
		boolean result = true;
		int productCount = prdDto.getProductStandard().getStore();
		if (productCount <= 1) {
			result = false;
		}
		return result;
	}

	/**
	 * 判断裸价体验活动是否结束
	 * 
	 * @Method_Name : isActivityOver
	 * @param prdDto
	 * @param type
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年10月14日 下午4:12:20
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isActivityOver(ProductDTO prdDto) {
		boolean result = true;
		int status = prdDto.getProductActivity().getStatus();
		if (ProductConstants.ACTIVITY_IS_PROCESS == status) {

			result = false;
		}

		return result;
	}

	/**
	 * 判断是否是初次体验
	 * 
	 * @Method_Name : isFirstExperience
	 * @param userId
	 * @param prdCode
	 * @return
	 * @return : Boolean
	 * @Creation Date : 2014年8月22日 上午11:21:58
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private Boolean isFirstExperience(Long userId, Long prdCode) {
		Boolean result = true;
		StringBuilder sb = null;

		sb = new StringBuilder(RedisConstants.REDIS_FIRST_FLAG);
		sb.append(userId).append(":").append(prdCode);
		log.debug("key------------------>" + sb);
		result = redisUtil.getFlag(sb.toString());
		log.debug("是否初次体验---------->:" + result);
		return result;
	}

	/**
	 * 判断体验宝数量是否足够
	 * 
	 * @Method_Name : isIngotCount
	 * @param ingotCount
	 * @param userId
	 * @return
	 * @return : CheckOrderResult
	 * @Creation Date : 2014年8月22日 上午11:21:36
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isIngotCount(int ingotCount, Long userId) {
		boolean result = false;
		int userOwnIngot = userDubboService.getUserIngot(userId);
		if (ingotCount <= userOwnIngot) {
			result = true;
		}

		return result;
	}

	/**
	 * 判断是否处于订单提交期
	 * 
	 * @Method_Name : isInSubmitTime
	 * @param applyId
	 * @param activity
	 * @return
	 * @return : Boolean
	 * @Creation Date : 2014年10月14日 下午4:03:05
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	private Boolean isInSubmitTime(Long applyId, ProductActivity activity) {
		boolean result = false;
		ApplyForm form = applyFormMapper.selectByPrimaryKey(applyId);
		// 未超出订单提交期并且处于订单提交期
		if (form.getSubmitEndTime().after(new Date())
				&& (activity.getStatus() == ProductConstants.FREE_ACTIVITY_SUBMIT_ORDER)) {
			result = true;
		}
		return result;
	}

}
