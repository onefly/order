package com.qianqian.apply.service;

import java.util.List;

import com.qianqian.apply.model.ApplyHandleLog;

/**
 * 申请单处理日志表操作service
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.apply.service.IApplyHandleLogService.java
 * @ClassName	: IApplyHandleLogService 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年7月6日 下午5:21:40
 */
public interface IApplyHandleLogService {
	/**
	 * 根据申请单编号查询该申请单的处理日志
	 *  @Method_Name    : getAllHandleLog
	 *  @param applyId
	 *  @return 
	 *  @return         : List<ApplyHandleLog>
	 *  @Creation Date  : 2014年7月6日 下午5:23:49
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public List<ApplyHandleLog> getAllHandleLog(long applyId);
}
