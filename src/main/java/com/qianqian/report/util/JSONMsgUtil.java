package com.qianqian.report.util;

import net.sf.json.JSONObject;

/**
 * Title:JSONMsgUtil
 * @Description:返回JSON消息提示
 * @Create_by:yinsy
 * @Create_date:2014-6-6
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class JSONMsgUtil {

	/**
	 * 打印错误信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-6
	 * @param message
	 * @return null
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	public static String getError(Object message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}
	
	/**
	 * 打印消息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-6
	 * @param message
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	public static String getMsg(Object message){
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("message", message);
		return obj.toString();
	}
	
}
