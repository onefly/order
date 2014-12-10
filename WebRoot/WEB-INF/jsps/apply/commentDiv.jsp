<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/checkShieldWord.js">
</script>
<h2>
	<span>最热评论</span>
</h2>
<div class="blog_blcc blog_blcf fixed">
	<div class="center_bottom margin25 fixed">
		<form id="commentForm" name="form1" method="post" action="">
			<label for="textfield" class="fixed">
			<c:if test="${loginFlag eq 0}">
			请<em class="luse">登录</em></c:if>发表评论：
			</label> <input name="pageNum" type="hidden" id="hidden_currentPage"
				value="${page.pageNum}"> <input type="hidden" name="applyId"
				value="${applyId}" />
			<textarea name="content"
				onkeydown="if(value.length>140) value=value.substr(0,140)"
				id="commentContent" cols="45" rows="5" class="texta"></textarea>
		</form>
		<p class="top15">
			<span class="fl"><img src="images/icon/biaoq.jpg" width="15"
				height="15" /></span> <input type="button" onclick="submitComment()"
				id="button" value="提交" class="wbtijiao" />
		</p>
	</div>
	<div class="baby_cs_bb top20 fixed">
		<ul class="bb_b">
			<c:forEach items="${commentList}" var="comment">
				<li>
					<p class="bjt">
						<img src="<%=imagePath%>/group1/M00/00/28/wKgGblORJhmQY-8YAABGfHv1x_Y113.jpg" width="50" height="50"><span><em
							class="luse">杨志张红杨志张红${comment.userId}</em> 普通会员 V1</span> <a
							href="javascript:reportComment('${comment.id}')" class="red">举报</a>
						<c:if test="${comment.replyState eq 0 and canReply eq 1}">
							<a href="javascript:replyComment('${comment.id}')">回复</a>
						</c:if>
					<p class="border_bottom">
						<em class="yellow">评论：</em>${comment.content}<em class="gray">[<fmt:formatDate
								value="${comment.commentTime}" pattern="yyyy/MM/dd HH:mm:ss" />]
						</em>
					</p> <c:if test="${comment.replyState eq 1}">
						<p>
							<em class="luse">回复：</em>${comment.reply.replyComment}<em class="gray">[<fmt:formatDate
									value="${comment.reply.replyTime}"
									pattern="yyyy/MM/dd HH:mm:ss" />]
							</em>
						</p>
					</c:if>
				</li>
			</c:forEach>
			<c:if test="${fn:length(commentList) gt 0}">
				<!-- 分页组件 -->
				<%@include file="/WEB-INF/jsps/includes/page.jsp"%>
			</c:if>
		</ul>
	</div>
</div>