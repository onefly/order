package com.qianqian.apply.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.framelib.common.RedisConstants;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.DateUtil;
import com.qianqian.apply.bo.ProductBO;
import com.qianqian.apply.bo.UserBO;
import com.qianqian.apply.mapper.ApplyCountMapper;
import com.qianqian.apply.mapper.ApplyFormMapper;
import com.qianqian.apply.mapper.ApplyHandleLogMapper;
import com.qianqian.apply.model.ApplyCount;
import com.qianqian.apply.model.ApplyCountExample;
import com.qianqian.apply.model.ApplyForm;
import com.qianqian.apply.model.ApplyFormExample;
import com.qianqian.apply.model.ApplyHandleLog;
import com.qianqian.apply.service.IApplyFormService;
import com.qianqian.apply.util.ApplyConstants;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.service.IProductDubboService;

/**
 * 免费试用申请单操作service
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.apply.service.impl.ApplyFormServiceImpl.java
 * @ClassName : ApplyFormServiceImpl
 * @Author : caozhifei
 * @CreateDate : 2014年7月3日 下午1:56:33
 */
@Service("applyFormService")
public class ApplyFormServiceImpl implements IApplyFormService {
	private static Logger log = LoggerFactory
			.getLogger(ApplyFormServiceImpl.class);

	/**
	 * 申请单操作mapper
	 */
	@Resource
	private ApplyFormMapper applyFormMapper;
	/**
	 * 申请单统计操作mapper
	 */
	@Resource
	private ApplyCountMapper applyCountMapper;
	/**
	 * 申请单处理记录操作mapper
	 */
	@Resource
	private ApplyHandleLogMapper applyHandleLogMapper;
	/**
	 * redis操作对象
	 */
	@Resource
	private IRedisUtil redisUtil;
	/**
	 * 产品信息操作service
	 */
	@Resource
	private IProductDubboService productDubboService;

	/**
	 * return 1 操作成功 ，2 操作失败,3 已经存在
	 * 
	 * @throws Exception
	 */
	@Override
	public int addApplyForm(ApplyForm applyForm) throws Exception {
		applyForm.setApplyTime(new Date());
		StringBuilder redisKey = new StringBuilder(
				RedisConstants.USER_APPLY_PREFIX);
		redisKey.append(applyForm.getUserId()).append(":")
				.append(applyForm.getProductCode()).append(":")
				.append(applyForm.getVersion());
		boolean lockFlag = redisUtil.getFlagAndLock(redisKey.toString());
		// 未抢到锁，直接返回操作失败
		if (!lockFlag) {
			return 3;
		}
		ProductActivity activity = productDubboService.getPrdActivity(applyForm
				.getActiveId());
		Date auditStartTime = DateUtil.addHours(activity.getOnTime(),
				ApplyConstants.APPLY_TIME);// 审核开始时间 ，即活动开始时间加上申请期
		Date auditEndTime = DateUtil.addHours(auditStartTime,
				ApplyConstants.APPLY_AUDIT_TIME);// 审核结束时间，即订单提交开始时间
		Date submitOrderEndTime = DateUtil.addHours(auditEndTime,
				ApplyConstants.SUBMIT_ORDER_TIME);// 订单提交结束时间
		// 申请单表操作
		applyForm.setAuditEndTime(auditEndTime);
		applyForm.setAuditStartTime(auditStartTime);
		applyForm.setSubmitEndTime(submitOrderEndTime);
		applyForm.setApplyState(ApplyConstants.WAIT_AUDIT);
		applyForm.setSubmitState(ApplyConstants.NOT_SUBMIT);
		int applyResult = applyFormMapper.insert(applyForm);
		long applyId = applyForm.getId();
		log.debug("applyFormId=" + applyId);

		// 申请单处理记录操作
		final ApplyHandleLog handleLog = new ApplyHandleLog();
		handleLog.setApplyId(applyId);
		handleLog.setHandleBy(ApplyConstants.HANDLE_BY_ME);
		handleLog.setHandleNote(ApplyConstants.HANDLE_STEP_1);
		handleLog.setHandleById(applyForm.getUserId());
		handleLog.setHandleTime(new Date());
		int handleResult = applyHandleLogMapper.insert(handleLog);

		// 申请单统计操作
		ApplyCountExample countExample = new ApplyCountExample();
		countExample.createCriteria().andUserIdEqualTo(applyForm.getUserId())
				.andBrandIdEqualTo(applyForm.getBrandCode());
		int count = applyCountMapper.countByExample(countExample);
		ApplyCount applyCount = new ApplyCount();
		applyCount.setBrandId(applyForm.getBrandCode());
		applyCount.setUserId(applyForm.getUserId());
		int countResult = 0;
		if (count == 0) {
			// 第一次申请该品牌，需要先插入一条数据
			applyCount.setSuccessNum(0);
			applyCount.setApplyNum(0);
			countResult = applyCountMapper.insert(applyCount);
		} else {
			// 该记录已经存在，直接修改值
			countResult = applyCountMapper.updateApplyNum(applyCount);
		}
		//TODO 需要修改
		if (countResult == 1 && handleResult == 1 && applyResult == 1) {
			Thread thread = new Thread() {
				public void run() {
					handleLog.setHandleNote(ApplyConstants.HANDLE_STEP_2);
					handleLog.setHandleTime(new Date());
					handleLog.setHandleBy(ApplyConstants.HANDLE_BY_SYSTEM);
					applyHandleLogMapper.insert(handleLog);
				}
			};
			thread.start();
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * 是否可以提交申请单
	 * 
	 * @Method_Name : canAddApply
	 * @param applyForm
	 * @return
	 * @return : boolean true可以提交，false不可以提交
	 * @Creation Date : 2014年6月25日 下午3:08:13
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean canAddApply(ApplyForm applyForm) {
		StringBuilder redisKey = new StringBuilder(
				RedisConstants.USER_APPLY_PREFIX);
		redisKey.append(applyForm.getUserId()).append(":")
				.append(applyForm.getProductCode()).append(":")
				.append(applyForm.getVersion());
		boolean lock = redisUtil.getFlag(redisKey.toString());
		if (!lock) {
			return false;
		}
		ApplyFormExample example = new ApplyFormExample();
		example.createCriteria()
				.andProductCodeEqualTo(applyForm.getProductCode())
				.andApplyStateEqualTo(ApplyConstants.AUDIT_PASS);// 表示审核通过
		int result = applyFormMapper.countByExample(example);
		if (result > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 通过主键查询申请单信息
	 * 
	 * @Method_Name : getApplyFormByPrimaryKey
	 * @param id
	 * @return
	 * @return : ApplyForm
	 * @Creation Date : 2014年6月27日 下午1:46:29
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public ApplyForm getApplyFormByPrimaryKey(long id) {
		return applyFormMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据主键修改申请单提交订单状态为已提交订单操作
	 * 
	 * @Method_Name : updateSubmitOrderState
	 * @param id
	 *            申请单ID
	 * @return
	 * @return : boolean true，操作成功；false，操作失败
	 * @Creation Date : 2014年7月3日 下午1:49:39
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean updateSubmitOrderState(long id) {
		ApplyForm apply = new ApplyForm();
		apply.setId(id);
		apply.setSubmitState(ApplyConstants.ALREADY_SUBMIT);// 设置订单提交状态为已提交订单
		int result = applyFormMapper.updateByPrimaryKeySelective(apply);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查询用户的统计数据并返回UserBO封装对象
	 * 
	 * @Method_Name : getUserBO
	 * @param userId
	 * @return
	 * @return : UserBO
	 * @Creation Date : 2014年7月4日 上午11:45:23
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public UserBO getUserBO(long userId) {
		UserBO bo = new UserBO();
		Integer focus = (Integer) redisUtil.hget(
				ApplyConstants.USER_FOCUS_COUNT, String.valueOf(userId));
		if (focus != null) {
			bo.setFocusCount(focus);
		}
		Integer fans = (Integer) redisUtil.hget(ApplyConstants.USER_FANS_COUNT,
				String.valueOf(userId));
		if (fans != null) {
			bo.setFansCount(fans);
		}
		Integer support = (Integer) redisUtil.hget(
				ApplyConstants.USER_SUPPORT_COUNT, String.valueOf(userId));
		if (support != null) {
			bo.setSupportCount(support);
		}
		Integer report = (Integer) redisUtil.hget(
				ApplyConstants.USER_REPORT_COUNT, String.valueOf(userId));
		if (report != null) {
			bo.setReportCount(report);
		}
		Integer average = (Integer) redisUtil.hget(
				ApplyConstants.USER_AVERAGE_COUNT, String.valueOf(userId));
		if (average != null) {
			bo.setAveScore(average);
		}
		return bo;
	}

	/**
	 * 根据品牌编码查询品牌的统计数据并返回业务封装对象
	 * 
	 * @Method_Name : getProductBO
	 * @param brandId
	 * @return
	 * @return : ProductBO
	 * @Creation Date : 2014年7月4日 下午12:01:40
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public ProductBO getProductBO(long brandId) {
		ProductBO bo = new ProductBO();
		Integer total = (Integer) redisUtil.hget(
				ApplyConstants.BRAND_TOTAL_EXPERIENCE, String.valueOf(brandId));
		if (total != null) {
			bo.setTotal(total);
		}
		Integer like = (Integer) redisUtil.hget(
				ApplyConstants.BRAND_LIKE_COUNT, String.valueOf(brandId));
		if (like != null) {
			bo.setLike(like);
		}
		Integer general = (Integer) redisUtil.hget(
				ApplyConstants.BRAND_GENERAL_COUNT, String.valueOf(brandId));
		if (general != null) {
			bo.setGeneral(general);
		}
		Integer dislike = (Integer) redisUtil.hget(
				ApplyConstants.BRAND_DISLIKE_COUNT, String.valueOf(brandId));
		if (dislike != null) {
			bo.setDislike(dislike);
		}
		return bo;
	}

}
