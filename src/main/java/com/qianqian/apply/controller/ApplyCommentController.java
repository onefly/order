package com.qianqian.apply.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qianqian.apply.model.ApplyForm;
import com.qianqian.apply.service.IApplyFormService;
import com.qianqian.comment.constant.CommentConstant;
import com.qianqian.comment.model.ApplyComment;
import com.framelib.common.SessionData;
import com.framelib.utils.Page;
import com.framelib.utils.SessionUtil;
import com.qianqian.comment.service.IApplyCommentDubboService;
import com.qianqian.member.service.IUserDubboService;

/**
 * 申请单评论控制器
 * 
 * @Project : order.maxtp
 * @Program Name: com.qianqian.apply.controller.ApplyCommentController.java
 * @ClassName : ApplyCommentController
 * @Author : caozhifei
 * @CreateDate : 2014年7月8日 上午10:21:36
 */
@RequestMapping("applyComment")
@Controller
public class ApplyCommentController {
	/**
	 * 日志记录对象
	 */
	private final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 申请单评论div页面
	 */
	private static final String COMMENT_DIV = "apply/commentDiv";
	/**
	 * 用户信息操作service
	 */
	@Resource
	private IUserDubboService userDubboService;
	/**
	 * 申请单操作service
	 */
	@Resource
	private IApplyFormService applyFormService;
	/**
	 * 申请单评论操作service
	 */
	@Resource
	private IApplyCommentDubboService applyCommentDubboService;

	/**
	 * 根据分页对象和申请单编号查询相关评论并进行分页操作
	 * 
	 * @Method_Name : getCommentList
	 * @param applyId
	 * @param page
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月8日 上午10:28:25
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getCommentList")
	public String getCommentList(HttpServletRequest request,Long applyId, Page page, ModelMap map) {
		log.debug("applyId=" + applyId);
		SessionData session=null;
		try {
			session = SessionUtil.getSessionData(request);
		} catch (TimeoutException e) {
			log.debug(e.getMessage(),e);
		} catch (InterruptedException e) {
			log.debug(e.getMessage(),e);
		} catch (MemcachedException e) {
			log.debug(e.getMessage(),e);
		}
		long userId = session == null ? 110 : session.getId();
		int loginFlag = session == null ? 0 : 1;//登录标识
		// TODO 调用dubbo接口查询申请单评论
		String orderField = "commentTime";
		page.setNumPerPage(10);//每页展示记录数
		List<ApplyComment> commentList = applyCommentDubboService.getByApply(
				applyId, page.getPageNum(), page.getNumPerPage(),
				Sort.Direction.ASC, orderField);
		int totalCount = (int) applyCommentDubboService.countByApply(applyId);
		ApplyForm apply = applyFormService.getApplyFormByPrimaryKey(applyId);
		int canReply = 0;//0代表没有回复按钮，1表示有回复按钮
		if(apply.getUserId() == userId){
			canReply = 1;
		}
		page.setTotalCount(totalCount);
		map.put("commentList", commentList);
		map.put("page", page);
		map.put("applyId", applyId);
		map.put("canReply", canReply);
		map.put("loginFlag", loginFlag);
		return COMMENT_DIV;
	}

	/**
	 * 申请单新增评论内容
	 * 
	 * @Method_Name : addComment
	 * @param comment
	 *            评论对象
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月8日 上午10:35:34
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("addComment")
	public String addComment(HttpServletRequest request,ApplyComment comment, ModelMap map) {
		SessionData session=null;
		try {
			session = SessionUtil.getSessionData(request);
		} catch (TimeoutException e) {
			log.debug(e.getMessage(),e);
		} catch (InterruptedException e) {
			log.debug(e.getMessage(),e);
		} catch (MemcachedException e) {
			log.debug(e.getMessage(),e);
		}
		long userId = session == null ? 110 : session.getId();
		comment.setUserId(userId);
		comment.setCommentTime(new Date());
		comment.setState(CommentConstant.NORMAL);
		log.debug(" comment ==>" + comment.getApplyId()+",content==>"+comment.getContent());
		// TODO 调用dubbo接口新增申请单评论
		String result = applyCommentDubboService.insertApplyComment(comment);
		log.debug("addComment result==>"+result);
		Page page = new Page();
		String orderField = "commentTime";
		page.setNumPerPage(10);//每页展示记录数
		List<ApplyComment> commentList = applyCommentDubboService.getByApply(
				comment.getApplyId(), page.getPageNum(), page.getNumPerPage(),
				Sort.Direction.ASC, orderField);
		int totalCount = (int) applyCommentDubboService.countByApply(comment.getApplyId());
		page.setTotalCount(totalCount);
		log.debug(" addComment totalCount==>"+totalCount);
		ApplyForm apply = applyFormService.getApplyFormByPrimaryKey(comment.getApplyId());
		int canReply = 0;//0代表没有回复按钮，1表示有回复按钮
		if(apply.getUserId() == userId){
			canReply = 1;
		}
		int loginFlag = session == null ? 0 : 1;//登录标识
		map.put("loginFlag", loginFlag);
		map.put("commentList", commentList);
		map.put("page", page);
		map.put("applyId", comment.getApplyId());
		map.put("canReply", canReply);
		return COMMENT_DIV;
	}
	/**
	 * 对评论内容进行回复
	 * 
	 * @Method_Name : replyComment
	 * @param reply
	 *            回复内容
	 * @param commentId
	 *            评论ID
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月8日 上午10:35:56
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("replyComment")
	public String replyComment(String reply, String commentId, ModelMap map) {
		log.debug(" commentId--" + commentId + " ,reply ==" + reply + " ");
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 110 : session.getId();
		// TODO 调用dubbo接口回复申请单评论
		boolean result = applyCommentDubboService.reply(userId, commentId, reply);
		map.put("result", result);
		return COMMENT_DIV;
	}


}
