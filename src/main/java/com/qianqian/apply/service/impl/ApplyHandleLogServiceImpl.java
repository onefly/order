package com.qianqian.apply.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qianqian.apply.mapper.ApplyHandleLogMapper;
import com.qianqian.apply.model.ApplyHandleLog;
import com.qianqian.apply.model.ApplyHandleLogExample;
import com.qianqian.apply.service.IApplyHandleLogService;
/**
 * 申请单处理日志表操作service
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.apply.service.impl.ApplyHandleLogServiceImpl.java
 * @ClassName	: ApplyHandleLogServiceImpl 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年7月6日 下午5:25:20
 */
@Service("applyHandleLogService")
public class ApplyHandleLogServiceImpl implements IApplyHandleLogService {
	/**
	 * 申请单处理记录操作mapper
	 */
	@Resource
	private ApplyHandleLogMapper applyHandleLogMapper;
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
	@Override
	public List<ApplyHandleLog> getAllHandleLog(long applyId) {
		ApplyHandleLogExample example = new ApplyHandleLogExample();
		example.setOrderByClause(" handle_time asc ");//按照处理时间进行排序
		example.createCriteria().andApplyIdEqualTo(applyId);
		return applyHandleLogMapper.selectByExample(example);
	}

}
