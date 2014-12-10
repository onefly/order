<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/style/public.css"
	rel="stylesheet" type="text/css" />

<title>免费试用-申请单拉赞</title>
<script language="javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/apply/forSupport.js"></script>
</head>
<body onload="loadDiv()">
<div id="wapper">
<form id="hiddenApplyForm">
<input type="hidden" value="${apply.userId}" name="userId"/>
<input type="hidden" value="${apply.activeId}" name="activityId"/>
<input type="hidden" value="${apply.id}" id="applyId"/>
<input type="hidden" value="${apply.supportCount}" id="supportCount"/>
</form>
<%@include file="/WEB-INF/jsps/includes/free-top.jsp"%>
  <div class="main fixed">
    <div class="public">
      <div class="blog_top fixed" id="userTopDiv">
     		  <!-- 用户空间公共头部div页面 -->
					<c:import url="/common/getUserTop.htm?userId=${apply.userId}"/>
      </div>
    <div class="blog_cent top30 fixed" id="productDiv">
					<!-- 产品与 品牌信息公共div页面-->
					<c:import url="/common/getProductInfo.htm?activityId=${apply.activeId}"/>
	</div>
      <div class="blog_bott top30 fixed">
        <div class="blog_bl fl fixed">
          <div class="blog_blc">
          		<jsp:include page="../common/applyDiv.jsp" />
          </div>
          <div class="blog_blc top20 fixed">
            <h5><span>
            	<c:if test="${apply.auditStartTime > currentDate}">
            	
            	距离支持申请结束 剩余 <font id="downTimeFont">72小时18分09秒</font>
            	</c:if>
            	<input type="hidden" id="hidden_time_start" value="${apply.auditStartTime}"/>
            	<c:if test="${apply.auditStartTime <= currentDate}">支持申请已经结束</c:if>
            
            	
            
            </span></h5>
            <div class="blog_blcc blog_blce fixed"> <span class="blog_text">${apply.applyNote}</span>
              <p class="praise">
              <c:if test="${buttonState == 0}">
              	<a href="javascript:;" class="praise01">支持ta</a>
              </c:if>
              <c:if test="${buttonState == 1}">
              	<a href="javascript:addSupport();" class="praise01">支持ta</a>
              </c:if>
              
              
              <a href="#" class="praise02">帮转发</a></p>
            </div>
          </div>
          <div class="top20"><img src="${pageContext.request.contextPath}/images/classify18.jpg" width="720" height="80" /></div>
          <div class="blog_blc top20" id="applyCommentDiv">
          		<!--评论div页面  -->
        		<c:import url="/applyComment/getCommentList.htm?applyId=${apply.id}"/>
          </div>
        </div>
        <div class="classify_right fr">
        	<!--右侧广告div页面  -->
         	<c:import url="/common/getRightAd.htm"/>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>