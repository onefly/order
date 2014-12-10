<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/style/public.css"
	rel="stylesheet" type="text/css" />
<title>免费试用-填写申请单</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/apply/addApply.js"></script>
</head>

<body>
	<div id="wapper">
		<%@include file="/WEB-INF/jsps/includes/free-top.jsp"%>
		<div class="main fixed">

			<div class="public">
				<div class="blog_top fixed" id="userTopDiv" >
					<!-- 用户空间公共头部div页面 -->
					<c:import url="/common/getUserTop.htm?userId=${apply.userId}"/>
				</div>
				<div class="blog_cent top30 fixed" id="productDiv" >
					<!-- 产品与 品牌信息公共div页面-->
					<c:import url="/common/getProductInfo.htm?activityId=${apply.activeId}"/>
				</div>

				<div class="blog_blc top30 fixed">
					<form id="addApplyForm">
					<input type="hidden" name="activeId" value="${apply.activeId}" />
					<input type="hidden" name="brandCode" value="${apply.brandCode}" />
					<input type="hidden" name="productCode" value="${apply.productCode}" />
					<input type="hidden" name="standardId" value="${apply.standardId}" />
						<input type="hidden" name="version" value="${apply.version}" /> 
						<input type="hidden" name="userId" value="${apply.userId}" /> 
						<h2>
							<span>输入申请理由</span>
						</h2>
						<div class="blog_blcc fixed">
							<div class="center_top">
								<label for="textfield">申请口号：</label> <input type="text"
									name="slogan" id="slogan_id" maxlength="20"/> <span>0/20</span>
							</div>
							<div class="center_top top10">
								<label for="textfield">申请理由：</label>
								<textarea name="reason" onkeydown="if(value.length>140) value=value.substr(0,140)" id="reason_id" cols="45" rows="5"
									class="texta"></textarea>
							</div>
						</div>
					</form>
				</div>

				<div class="blog_blcc top30 fixed">
					<div class="fl">
						本次申请将<em class="yellow">扣除${costScore}积分</em>，不再返还
					</div>
					<div class="fr">
						<input type="button" name="button" id="button" value="提交申请" onclick="addApply()"
							class="w_input" /> <span>试用保证金 : ￥<font id="showMoney">00.00</font></span>
					</div>
				</div>

			</div>

		<%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
		</div>

	</div>
</body>
</html>