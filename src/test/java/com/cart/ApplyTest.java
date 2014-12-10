package com.cart;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.util.HtmlUtils;

import com.framelib.common.CommonConstants;
import com.framelib.common.RedisConstants;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.DateUtil;
import com.qianqian.apply.model.ApplyForm;
import com.qianqian.apply.model.ApplySupportRecord;
import com.qianqian.apply.service.IApplyFormService;
import com.qianqian.apply.service.IApplySupportRecordService;

public class ApplyTest {
	private IApplyFormService applyFormService;
	private IApplySupportRecordService applySupportRecordService;
	private IRedisUtil redisUtil;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Before
	public void before(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/applicationContext.xml");
		applyFormService = (IApplyFormService) ctx.getBean("applyFormService");
		applySupportRecordService = (IApplySupportRecordService) ctx.getBean("applySupportRecordService");
		redisUtil = (IRedisUtil) ctx.getBean("redisUtil");
	}
	@Test
	public void testAddShieldWord(){
		String key = RedisConstants.SHIELD_WORD;
		String word = "共产党";
		String input = "<img src='http://192.168.6.110:8090/group1/M00/00/2E/wKgGblPI0p2yAoWKACV54FUq5NM676.gif'/>";
		input = HtmlUtils.htmlEscape(input);
		System.out.println(input);
		Long result = redisUtil.sadd(key, word);
		System.out.println("sadd result ==>"+result);
	}
	/**
	 * 提交申请单测试
	 *  @Method_Name    : testAdd1 
	 *  @return         : void
	 *  @Creation Date  : 2014年6月25日 下午1:40:59
	 *  @version        : v1.00
	 * @throws Exception 
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@Test
	public void testAdd1() throws Exception{
		ApplyForm apply = new ApplyForm();
		apply.setActiveId(11l);
		apply.setApplyState(0);
		apply.setApplyTime(new Date(0));
		apply.setAuditEndTime(DateUtil.addDay(new Date(), 10));
		apply.setAuditStartTime(DateUtil.addDay(new Date(), 7));
		apply.setBrandCode(100l);
		apply.setProductCode(119361l);
		apply.setReason("71000我不知道");
		apply.setSlogan("71999你家那里借来的么，我000");
		apply.setSubmitState(0);
		apply.setSupportCount(0);
		apply.setUserId(110l);
		apply.setVersion(20);
		int result = applyFormService.addApplyForm(apply);
		System.out.println("提交申请单结果="+result);
	}
	/**
	 * 拉赞支持测试
	 *  @Method_Name    : testSupport1 
	 *  @return         : void
	 *  @Creation Date  : 2014年6月25日 下午1:41:34
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@Test
	public void testSupport1(){
		ApplySupportRecord support = new ApplySupportRecord();
		support.setApplyId(95553500359951752l);
		support.setHeadImg("/group1/M00/00/28/wKgGblORX57cvNnmAAA-KveQaas469.jpg");
		support.setNickname("别跑");
		support.setSupportTime(new Date());
		support.setUserId(113l);
		int result=0;
		try {
			result = applySupportRecordService.addRecord(support);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("支持申请单结果 = "+result);
	}
}
