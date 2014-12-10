package com.qianqian.apply.service;

import com.qianqian.apply.bo.ProductBO;
import com.qianqian.apply.bo.UserBO;
import com.qianqian.apply.model.ApplyForm;

/**
 * 免费试用申请单操作service
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.apply.service.ApplyFormService.java
 * @ClassName	: ApplyFormService 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年6月23日 上午11:43:19
 */
public interface IApplyFormService {
	/**
	 * 添加申请单 ，返回 1 操作成功 ，2 操作失败,3已经存在
	 *  @Method_Name    : addApplyForm
	 *  @param applyForm
	 *  @return 
	 *  @return         : int 1 操作成功 ，2 操作失败,3已经存在
	 *  @Creation Date  : 2014年6月23日 下午2:12:16
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public int addApplyForm(ApplyForm applyForm)  throws Exception;
	/**
	 * 是否可以提交申请单
	 *  @Method_Name    : canAddApply
	 *  @param applyForm
	 *  @return 
	 *  @return         : boolean true可以提交，false不可以提交
	 *  @Creation Date  : 2014年6月25日 下午3:08:13
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public boolean canAddApply(ApplyForm applyForm);
	/**
	 * 通过主键查询申请单信息
	 *  @Method_Name    : getApplyFormByPrimaryKey
	 *  @param id
	 *  @return 
	 *  @return         : ApplyForm
	 *  @Creation Date  : 2014年6月27日 下午1:46:29
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public ApplyForm getApplyFormByPrimaryKey(long id);
	/**
	 * 根据主键修改申请单提交订单状态为已提交订单操作
	 *  @Method_Name    : updateSubmitOrderState
	 *  @param id 申请单ID
	 *  @return 
	 *  @return         : boolean true，操作成功；false，操作失败
	 *  @Creation Date  : 2014年7月3日 下午1:49:39
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public boolean updateSubmitOrderState(long id);
	/**
	 * 查询用户的统计数据并返回UserBO封装对象
	 *  @Method_Name    : getUserBO
	 *  @param userId
	 *  @return 
	 *  @return         : UserBO
	 *  @Creation Date  : 2014年7月4日 上午11:45:23
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public UserBO getUserBO(long userId);
	/**
	 * 根据品牌编码查询品牌的统计数据并返回业务封装对象
	 *  @Method_Name    : getProductBO
	 *  @param brandId
	 *  @return 
	 *  @return         : ProductBO
	 *  @Creation Date  : 2014年7月4日 下午12:01:40
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public ProductBO getProductBO(long brandId);
	

}
