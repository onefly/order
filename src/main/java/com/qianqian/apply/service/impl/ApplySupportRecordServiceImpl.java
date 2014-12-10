package com.qianqian.apply.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framelib.common.RedisConstants;
import com.framelib.redis.IRedisUtil;
import com.qianqian.apply.mapper.ApplyFormMapper;
import com.qianqian.apply.mapper.ApplySupportRecordMapper;
import com.qianqian.apply.model.ApplySupportRecord;
import com.qianqian.apply.model.ApplySupportRecordExample;
import com.qianqian.apply.service.IApplySupportRecordService;
import com.qianqian.apply.util.ApplyConstants;

@Service("applySupportRecordService")
public class ApplySupportRecordServiceImpl implements
		IApplySupportRecordService {
	/**
	 * 申请单操作mapper
	 */
	@Resource
	private ApplyFormMapper applyFormMapper;
	/**
	 * 申请单支持记录表操作mapper
	 */
	@Resource
	private ApplySupportRecordMapper applySupportRecordMapper;
	/**
	 * redis操作对象
	 */
	@Resource
	private IRedisUtil redisUtil;
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
	@Override
	public int addRecord(ApplySupportRecord record) throws Exception{
		String redisKey = RedisConstants.USER_SUPPORT_PREFIX
				+ record.getUserId() +":"+ record.getApplyId();
		boolean lockFlag = redisUtil.getFlagAndLock(redisKey);
		// 未抢到锁，直接返回操作失败
		if (!lockFlag) {
			return 3;
		}
		int applyResult = applyFormMapper.updateSupportNum(record.getApplyId());
		record.setSupportTime(new Date());
		int supportResule = applySupportRecordMapper.insert(record);
		int expireTime = ApplyConstants.APPLY_TIME * 60 * 60 ;
		//设置申请单申请期结束后，点赞占用锁自动失效
		redisUtil.expire(redisKey, expireTime);
		if (applyResult == 1 && supportResule == 1) {
			return 1;
		} else {
			return 0;
		}
	}
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
	@Override
	public boolean canSupport(ApplySupportRecord record) {
		String redisKey = RedisConstants.USER_SUPPORT_PREFIX
				+ record.getUserId() +":"+ record.getApplyId();
		boolean lockFlag = redisUtil.getFlag(redisKey);
		if (!lockFlag) {
			return false;
		}
		ApplySupportRecordExample example = new ApplySupportRecordExample();
		example.createCriteria().andApplyIdEqualTo(record.getApplyId()).andUserIdEqualTo(record.getUserId());
		int result = applySupportRecordMapper.countByExample(example);
		if (result > 0) {
			return false;
		} else {
			return true;
		}
	}

}
