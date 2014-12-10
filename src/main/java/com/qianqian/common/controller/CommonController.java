package com.qianqian.common.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.framelib.common.RedisConstants;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.DateUtil;
import com.qianqian.apply.bo.ProductBO;
import com.qianqian.apply.bo.UserBO;
import com.qianqian.apply.model.ApplyForm;
import com.qianqian.apply.service.IApplyFormService;
import com.qianqian.apply.util.ApplyConstants;
import com.qianqian.member.model.User;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.order.utils.OrderConstants;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductStat;
import com.qianqian.product.service.IProductDubboService;

/**
 * 查询共共用div页面控制器
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.common.controller.CommonController.java
 * @ClassName : CommonController
 * @Author : caozhifei
 * @CreateDate : 2014年7月8日 上午9:21:00
 */
@RequestMapping("common")
@Controller
public class CommonController {
	private static Logger log = LoggerFactory.getLogger(CommonController.class);
	/**
	 * 顶部用户信息div页面
	 */
	private static final String USER_TOP = "common/userTopDiv";
	/**
	 * 中部免费试用产品信息div页面
	 */
	private static final String FREE_PRODUCT_INFO = "common/freeProductDiv";
	/**
	 * 中部裸价体验产品信息div页面
	 */
	private static final String NAKED_PRODUCT_INFO = "common/freeProductDiv";
	/**
	 * 右侧轮播广告和标准广告div页面
	 */
	private static final String RIGHT_AD = "common/rightAdDiv";
	/**
	 * 中部申请单口号理由信息div页面
	 */
	private static final String APPLY_DIV = "common/applyDiv";
	/**
	 * 美试网日期格式
	 */
	private static final String MAXTP_FORMAT = "yyyy/MM/dd HH:mm:ss";
	/**
	 * 申请单操作service
	 */
	@Resource
	private IApplyFormService applyFormService;
	/**
	 * 用户信息才操作service
	 */
	@Resource
	private IUserDubboService userDubboService;
	/**
	 * 产品信息操作service
	 */
	@Resource
	private IProductDubboService productDubboService;
	@Resource
	private IRedisUtil redisUtil;

	/**
	 * 查询顶部用户信息并返回div页面
	 * 
	 * @Method_Name : getUserTop
	 * @param userId
	 *            用户ID
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月7日 下午8:43:57
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getUserTop")
	public String getUserTop(Long userId, ModelMap map) {
		log.debug("getUserTop userId=" + userId);
		User user = userDubboService.getUser(userId);
		UserBO userBO = applyFormService.getUserBO(userId);
		userBO.setUser(user);
		log.debug("userBO=" + userBO);
		map.put("userBO", userBO);
		return USER_TOP;
	}

	/**
	 * 查询中部产品和品牌信息并返回div页面
	 * 
	 * @Method_Name : getProductInfo
	 * @param activityId
	 *            活动编号
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月7日 下午8:41:04
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getProductInfo")
	public String getProductInfo(Long activityId, ModelMap map) {
		log.debug("getProductTInfo productCode activityId=" + activityId);
		ProductActivity activity = productDubboService
				.getPrdActivity(activityId);
		Product product = productDubboService.getProduct(
				activity.getProductCode(), activity.getVersion());
		ProductBO productBO = applyFormService.getProductBO(product
				.getBrandId());
		Date applyEndTime = DateUtil.addHours(activity.getOnTime(),
				ApplyConstants.APPLY_TIME);// 申请截止时间
		productBO.setApplyEndTime(DateUtil.format(applyEndTime, MAXTP_FORMAT));
		Date applyAuditTime = DateUtil.addHours(applyEndTime,
				ApplyConstants.APPLY_AUDIT_TIME);// 审核截止时间
		productBO.setApplyAuditTime(DateUtil.format(applyAuditTime,
				MAXTP_FORMAT));
		productBO.setCurrentDate(DateUtil.format(new Date(), MAXTP_FORMAT));
		productBO.setApplyStartTime(DateUtil.format(activity.getOnTime(),
				MAXTP_FORMAT));
		productBO.setProduct(product);
		productBO.setActivity(activity);
		ProductStat stat = new ProductStat();
		// TODO 调用dubbo服务接口查询产品喜好度
		/* 模拟产品喜好度测试数据start */
		stat.setTotalExperience(563);
		stat.setGoodEvaluate(BigDecimal.valueOf(72.3));
		stat.setBadEvaluate(BigDecimal.valueOf(13.1));
		stat.setMiddleEvaluate(BigDecimal.valueOf(14.6));
		/* 模拟产品喜好度测试数据end */

		productBO.setStat(stat);
		log.debug("productBO=" + productBO);
		map.put("productBO", productBO);
		map.put("costScore", ApplyConstants.APPLY_DEDUCT_SCORE);
		int type = product.getType();
		if (OrderConstants.FREE_TYPE == type) {
			return FREE_PRODUCT_INFO;
		} else {
			return NAKED_PRODUCT_INFO;
		}
	}

	/**
	 * 查询右侧标准广告位和轮播管广告div页面
	 * 
	 * @Method_Name : getRightAd
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月8日 上午10:00:55
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getRightAd")
	public String getRightAd() {
		// TODO
		log.debug("查询右侧广告****************");
		return RIGHT_AD;
	}

	/**
	 * 查询申请单信息div页面
	 * 
	 * @Method_Name : getApply
	 * @param aid
	 *            申请单编号
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月9日 下午3:37:57
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getApply")
	public String getApply(Long aid, ModelMap map) {
		log.debug("getApply div , aid ****************" + aid);
		ApplyForm apply = applyFormService.getApplyFormByPrimaryKey(aid);
		map.put("apply", apply);
		return APPLY_DIV;
	}

	/**
	 * 检查参数内容是否包含网站设置的屏蔽词
	 * 
	 * @Method_Name : checkKeywords
	 * @param content
	 *            待检测内容
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月18日 上午10:39:54
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("checkShieldWord")
	public String checkShieldWord(HttpServletRequest request, ModelMap map) {
		String content = null;
		try {
			// 解决get请求时的中文乱码问题
			content = new String(request.getParameter("content").getBytes(
					"ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.toString(), e);
		}
		content = content.replaceAll(" ", "");
		String key = RedisConstants.SHIELD_WORD;
		Set<String> set = (Set<String>) redisUtil.smembers(key);
		boolean result = false;
		if (StringUtils.isNotBlank(content)) {
			for (String shieldWord : set) {
				if (StringUtils.isNotBlank(shieldWord)) {
					if (content.contains(shieldWord)) {
						result = true;
						map.put("shieldWord", shieldWord);
						break;
					}
				}
			}
		}
		map.put("result", result);
		return null;
	}

	/**
	 * 查询屏蔽词列表
	 * 
	 * @Method_Name : getShieldWordList
	 * @param shieldWord
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月18日 下午2:21:04
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getShieldWordList")
	public String getShieldWordList(String shieldWord, ModelMap map) {
		String key = RedisConstants.SHIELD_WORD;
		Set<String> set = (Set<String>) redisUtil.smembers(key);
		List<String> list = new ArrayList<String>();
		if (StringUtils.isNotBlank(shieldWord)) {
			for (String s : set) {
				if (s.contains(shieldWord)) {
					list.add(s);
				}
			}
			map.put("shieldWordSet", list);
		} else {
			map.put("shieldWordSet", set);
		}
		return "common/shieldWord";
	}

	/**
	 * 添加新的屏蔽词
	 * 
	 * @Method_Name : addShieldWord
	 * @param shieldWord
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月18日 下午2:23:05
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("addShieldWord")
	public String addShieldWord(String shieldWord, ModelMap map) {
		String key = RedisConstants.SHIELD_WORD;
		redisUtil.sadd(key, shieldWord);
		return "redirect:/common/getShieldWordList.htm";
	}

	/**
	 * 删除屏蔽词
	 * 
	 * @Method_Name : addShieldWord
	 * @param shieldWord
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月18日 下午2:23:05
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("deleteShieldWord")
	public String deleteShieldWord(String shieldWord, ModelMap map) {
		String key = RedisConstants.SHIELD_WORD;
		redisUtil.srem(key, shieldWord);
		return "redirect:/common/getShieldWordList.htm";
	}
}
