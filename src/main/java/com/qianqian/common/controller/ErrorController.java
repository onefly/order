package com.qianqian.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 程序异常后跳转错误页面控制器
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.common.controller.ErrorController.java
 * @ClassName	: ErrorController 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年7月9日 下午1:52:32
 */
@Controller
public class ErrorController {
	private final static String ERROR="common/errors/error";
	/**
	 * 返回错误页面
	 *  @Method_Name    : toError
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月9日 下午2:07:17
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("showError")
	public String toError(){
		return ERROR;
	}
}
