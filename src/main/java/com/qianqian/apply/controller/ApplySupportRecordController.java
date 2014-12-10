package com.qianqian.apply.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.framelib.common.RedisConstants;
import com.framelib.common.SessionData;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.SessionUtil;
import com.qianqian.apply.model.ApplySupportRecord;
import com.qianqian.apply.service.IApplySupportRecordService;

/**
 * 申请单点赞支持操作控制器
 * 
 * @Project : order.maxtp
 * @Program Name:
 *          com.qianqian.apply.controller.ApplySupportRecordController.java
 * @ClassName : ApplySupportRecordController
 * @Author : caozhifei
 * @CreateDate : 2014年6月25日 下午5:42:47
 */
@RequestMapping("support")
@Controller
public class ApplySupportRecordController {
	private static Logger log = LoggerFactory
			.getLogger(ApplyFormController.class);
	/**
	 * 申请单支持操作service
	 */
	@Resource
	private IApplySupportRecordService applySupportRecordService;
	/**
	 * redis操作对象
	 */
	@Resource
	private IRedisUtil redisUtil;

	/**
	 * 添加点赞支持记录
	 * 
	 * @Method_Name : addSupport
	 * @param record
	 * @return 1 操作成功 ，2 操作失败,3已经存在
	 * @return : String
	 * @Creation Date : 2014年6月25日 下午5:43:09
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("addSupport")
	public String addSupport(ApplySupportRecord record, ModelMap map) {
		log.debug("addSupport:" + record);
		int result = 0;
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 110 : session.getId();
		record.setUserId(userId);
		if (applySupportRecordService.canSupport(record)) {
			try {
				result = applySupportRecordService.addRecord(record);
			} catch (Exception e) {
				result = 2;
				String redisKey = RedisConstants.USER_SUPPORT_PREFIX
						+ record.getUserId() + ":" + record.getApplyId();
				redisUtil.freeLock(redisKey);
				log.error(e.toString(), e);
			}
		} else {
			result = 3;
		}
		map.put("result", result);
		return null;
	}

}
