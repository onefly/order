package com.qianqian.apply.service;

import com.qianqian.apply.model.ApplySupportRecord;

/**
 * 申请单的支持记录操作
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.apply.service.IApplySupportRecordService.java
 * @ClassName	: IApplySupportRecordService 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年6月23日 下午2:37:01
 */
public interface IApplySupportRecordService {
	/**
	 * 添加新的申请单支持记录并修改申请单表中的支持人数
	 *  @Method_Name    : addRecord
	 *  @param record
	 *  @return 
	 *  @return         : int 1 操作成功 2操作失败 3已经支持
	 *  @Creation Date  : 2014年6月23日 下午2:38:25
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public int addRecord(ApplySupportRecord record) throws Exception;
	/**
	 * 是否可以对申请单进行点赞支持
	 *  @Method_Name    : canSupport
	 *  @param record
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2014年6月26日 下午3:12:50
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public boolean canSupport(ApplySupportRecord record);

}
