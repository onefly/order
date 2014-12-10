package com.qianqian.common.utils;

import java.util.Properties;

import com.framelib.utils.ConfigUtils;

/**
 * 系统常量类 Title:Constants Description:
 * 
 * @Create_by:Zhangy Yan
 * @Create_date:2014-04-04
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 * 
 */
public class Constants {

	// redis-key属性文件
	private final static Properties REDIS_KEY_PROPS = ConfigUtils
			.getPropertiesFile("conf/redis-key.properties");

	// redis list test key name
	public static final String REIDS_LIST_TEST_KEY = (String) REDIS_KEY_PROPS
			.get("reids.list.test.key");

	/**
	 * 下单时消耗的体验宝数量
	 */
	public static final int COST_INGOT_NUM = 1;
	/**
	 * 单个用户的最大品牌体验车数量
	 */
	public static final int USER_MAX_CART_NUM = 8;
	/**
	 * 用户中单个品牌体验车中的最大商品数量
	 */
	public static final int CART_MAX_COMMODITY_NUM = 10;

}
