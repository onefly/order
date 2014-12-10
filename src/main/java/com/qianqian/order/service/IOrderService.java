package com.qianqian.order.service;



import com.qianqian.order.dto.CheckOrderResult;
import com.qianqian.order.dto.JudgeResult;
import com.qianqian.order.dto.OrderBO;
import com.qianqian.order.dto.OrderDTO;
import com.qianqian.order.dto.Query;
import com.qianqian.order.dto.Result;
import com.qianqian.order.dto.UpdateStateDTO;
import com.qianqian.order.model.Orders;

/**
 * 本地订单接口
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.order.service.OrderService.java
 * @ClassName : OrderService
 * @Author : shenzhenxing
 * @CreateDate : 2014年6月19日 下午2:11:24
 */
public interface IOrderService {
	/**
	 * 生成订单
	 *  @Method_Name    : addOrder
	 *  @param order
	 *  @param useId
	 *  @return
	 *  @throws Exception 
	 *  @return       : Orders
	 *  @Creation Date  : 2014年10月20日 下午4:26:15
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	Orders addOrder(OrderDTO order, Long useId) throws Exception;
	

	/**
	 * 是否能放入体验车或者是否能申请单
	 * 
	 * @Method_Name : isCanExpOrTry
	 * @param prdCode
	 *            :产品编号
	 * @param version
	 *            :产品版本
	 * @param userId
	 *            :用户id
	 * @param brandId
	 *            :品牌id
	 * @param activityId
	 *            :活动id
	 * @param type
	 *            :产品类型,裸价或者免费
	 * @return
	 * @return : Map<String,Boolean>
	 * @Creation Date : 2014年6月25日 下午1:48:04
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	JudgeResult isCanExpOrTry(Long prdCode, int version, Long userId,
			Long brandId, Long activityId, int type);
	/**
	 * 提交裸价体验订单时的判断
	 *  @Method_Name    : isCanSubmitOrderForNaked
	 *  @param orderDto
	 *  @param userId
	 *  @return 
	 *  @return       : CheckOrderResult
	 *  @Creation Date  : 2014年10月15日 上午9:57:03
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	CheckOrderResult isCanSubmitOrderForNaked(OrderDTO orderDto, Long userId) ;
	/**
	 * 提交免费试用订单时的判断
	 *  @Method_Name    : isCanSubmitOrderForFree
	 *  @param orderDto
	 *  @param userId
	 *  @return 
	 *  @return       : CheckOrderResult
	 *  @Creation Date  : 2014年10月15日 上午9:57:36
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	CheckOrderResult isCanSubmitOrderForFree(OrderDTO orderDto, Long userId) ;
}
