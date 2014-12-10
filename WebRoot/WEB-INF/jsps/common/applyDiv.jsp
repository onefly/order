<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<h2>
	<span>ta的申请理由</span>
</h2>
<div class="blog_blcc blog_blce fixed">
	<ul>
		<li><em>申请试用时间：</em><span><fmt:formatDate
					value="${apply.applyTime}" pattern="yyyy/MM/dd HH:mm:ss" /></span></li>
		<li><em>申请试用口号：</em><span>${apply.slogan}</span></li>
		<li><em>申请试用理由：</em><span>${apply.reason}</span></li>
		<li><em>试用活动状态：</em><span class="luse"> <c:if
					test="${apply.auditStartTime > currentDate}">
                	  申请中
                </c:if> <c:if
					test="${apply.auditEndTime > currentDate && apply.auditStartTime <= currentDate}">
                	  审核中
                </c:if> <c:if test="${apply.auditEndTime <= currentDate}">
                	  活动结束
                </c:if>

		</span></li>
		<li><em>申请支持人数：</em><span class="fize16" id="supportCountSpan">${apply.supportCount}
				<%--  <fmt:formatNumber value="${apply.supportCount}" pattern="###,###" minFractionDigits="0" /> --%>
		</span></li>
	</ul>
</div>