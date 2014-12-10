<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.qianqian.order.utils.OrderConstants,com.qianqian.order.model.Orders,com.qianqian.order.model.OrderChild,com.qianqian.order.dto.*" %>

<%@include file="/WEB-INF/jsps/includes/import.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/style/public.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/trial.css" rel="stylesheet" type="text/css" />
<title>免费试用查看申请单状态</title>

<script type="text/javascript">
	$(function() {
		var state=$("#orderState").val();
		
		if(state==200||state==101||state==102){
			$("#orderStateSubmit").addClass("bold");
			$("#stateLine1").show();
		}
		if(state==300){
			$("#orderStatePay").addClass("bold");
			$("#stateLine2").show();
		}
		if(state==400){
			$("#orderStateDeliver").addClass("bold");
			$("#stateLine3").show();
		}
		if(state==500){
			$("#orderStateReceive").addClass("bold");
			$("#stateLine4").show();
			
		}
		if(state==600){
			$("#orderStateReport").addclass("bold");
			$("#stateLine5").show();
		}
		if(state==800){
			$("#orderStateRefund").addclass("bold");
			$("#stateLine6").show();
		}

	});
</script>
</head>


<body>
<%@include file="/WEB-INF/jsps/includes/free-top.jsp"%>
	<div id="wapper">
		<div class="main top30 fixed">
			<div class="public">
				<p class="bottom_solid">
					您现在位于：首页 >> 免费试用 <em class="luse">- 订单：${detail.orders.id}</em>
				</p>
				<div class="n_order fixed">
				<input id="orderState" type="hidden" value="${detail.orders.sysState }"/>
					<div class="n_trace">
						<p class="luse">
							<span>免费试用 <em>保证金：</em>￥${detail.orders.orderFund}元
							</span>订单详情
						</p>
						<div class="n_traceq">
							<div class="n_traceqt">
								<span id="orderStateSubmit" class="spana01"><em>提交订单</em><br />
									<fmt:formatDate value="${detail.orders.createTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
									value="${detail.orders.createTime}" type="time" /></span>
								 <span  id="orderStatePay" class="spana02"><em>支付保证金</em><br />
									<fmt:formatDate value="${detail.orders.buyerPaymentTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
									value="${detail.orders.buyerPaymentTime}" type="time" /></span> 
								<span id="orderStateDeliver" class="spana03"><em>订单发货</em><br />
									<fmt:formatDate value="${detail.orders.sellerDeliverTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
									value="${detail.orders.sellerDeliverTime}" type="time" /></span>
								 <span id="orderStateReceive" class="spana04"><em>确认收货</em><br />
									<fmt:formatDate value="${detail.orders.buyerSigninTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
									value="${detail.orders.buyerSigninTime}" type="time" /></span> 
								<span id="orderStateReport" class="spana05"><em>提交报告</em><br />
									<fmt:formatDate value="${detail.orders.buyerSubmitReportTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
									value="${detail.orders.buyerSubmitReportTime}" type="time" /></span> 
								<span id="orderStateRefund"class="spana06"><em>退还保证金</em><br />
									<fmt:formatDate value="${detail.orders.returnDepositTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
									value="${detail.orders.returnDepositTime}" type="time" /></span>
								<div  id="stateLine1" class="bja_trace01 fixed" style="display: none;"></div>
								<div  id="stateLine2" class="bja_trace02 fixed" style="display: none;"></div>
								<div  id="stateLine3" class="bja_trace03 fixed" style="display: none;"></div>
								<div  id="stateLine4" class="bja_trace04 fixed" style="display: none;"></div>
								<div  id="stateLine5" class="bja_trace05 fixed" style="display: none;"></div>
								<div  id="stateLine6" class="bja_trace06 fixed" style="display: none;"></div>
							</div>
							<table width="1000" border="0" cellspacing="0" cellpadding="0"
								class="n_teceqb">
								<tr class="fize14">
									<td width="333" height="40" align="center" valign="middle">处理时间</td>
									<td width="334" height="40" align="center" valign="middle">处理信息</td>
									<td width="333" height="40" align="center" valign="middle">操作人</td>
								</tr>
								<c:forEach items="${detail.logs }" var="p" varStatus="pp">
									<tr class="fize12">
										<td id="opTime${pp.index}" width="333" height="35"
											align="center" valign="middle"><fmt:formatDate
												value="${p.operationDate}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
												value="${p.operationDate}" type="time" /></td>
										<td width="334" height="35" align="center" valign="middle">${p.remark}</td>
										<td width="333" height="35" align="center" valign="middle">
									
										<c:if test="${p.operationPlatform eq -1}">系统</c:if>
										<c:if test="${p.operationPlatform eq -2}">商家</c:if>
										<c:if test="${p.operationPlatform eq -3}">自己</c:if>
										<c:if test="${p.operationPlatform eq -4}">美试网</c:if>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<p class="luse">用户信息</p>
					<div class="n_order02 fixed">
						<span>美试ID：${detail.orders.buyerId}</span><span>姓名：${userOrder.name}</span><span>登录号：${userOrder.phone}</span>
					</div>
					<p class="luse">物流信息</p>
					<div class="n_order02 fixed">
						<span>物流公司：${detail.orders.expressCompany}</span><span>快递单编号：${detail.orders.expressNumbers}</span>
					</div>
					<p class="luse">收货人信息</p>
					<div class="n_order02 fixed">
						<span>${detail.orders.addrRecieveName}</span><span>${detail.orders.addrFullAddress}</span><span>${detail.orders.addrZipCode}</span><span>${detail.orders.addrRecieveMobile}</span>
					</div>

					<p class="luse">支付方式</p>
					<div class="n_order02 fixed">
						<span>${detail.orders.payWay}</span>
					</div>
					<p class="luse">体验目的</p>
					<div class="n_order02 fixed">
						<span>${detail.childs[0].actiPurpose}</span>
					</div>
					<p class="luse">参与标准</p>
					<div class="n_order02 n_order_none fixed" style="">
						<em>性别要求：
						<c:if test="${detail.childs[0].actiGender==0}">
							女
						</c:if>
						<c:if test="${detail.childs[0].actiGender==1}">
							男
						</c:if>
						<c:if test="${detail.childs[0].actiGender==2}">
							不限
						</c:if>
						
						</em>
						<em> 年龄要求：${detail.childs[0].actiAgeMin}-${detail.childs[0].actiAgeMax}岁</em>
						<em> 会员类别：<c:if test="${detail.childs[0].actiUserType ==0}">普通会员</c:if>
									<c:if test="${detail.childs[0].actiUserType ==1}">VIP会员</c:if>
									<c:if test="${detail.childs[0].actiUserType ==2}">体验师</c:if>
									<c:if test="${detail.childs[0].actiUserType ==3}">产品经理</c:if></em>
						<em>体验等级：LV${detail.childs[0].actiGradeLow}-LV${detail.childs[0].actiGradeHigh}</em>
						<em> 本品牌勋章：${detail.childs[0].actiBrandNum }个以上</em>
						<em> 地区要求：大陆地区</em>
						<em><c:if
													test="${detail.childs[0].actiAreaType==0 }">
												以下省份参加:
												</c:if> <c:if test="${detail.childs[0].actiAreaType==1}">
												以下省份不参加:
												</c:if> <c:if test="${detail.childs[0].actiAreaType==2}">
												不限
												</c:if> <c:forEach items="${fn:split(detail.childs[0].actiArea,',')}"
													var="actiArea">
													${actiArea}
												</c:forEach>
						
						
						</em>
					</div>
					<p class="luse">买家留言</p>
					<div class="n_order02 fixed">给我发个好点的，外观不限</div>
					<p class="luse">体验信息</p>
					<table class="tab_noe fixed">
						<thead>
							<tr>
								<th width="286"><div>产品名称</div></th>
								<th width="94"><div>规格</div></th>
								<th width="94"><div>颜色</div></th>
								<th width="94"><div>尺码</div></th>
								<th width="94"><div>市场价</div></th>
								<th width="94"><div>保证金</div></th>
								<th width="94"><div>消耗体验宝</div></th>
								<th width="150"><div>订单状态</div></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${detail.childs}" var="p">
								<tr>
									<td align="center" valign="middle" class="mc_span"><div>
											<a href="#" class="fl"><img
												src="<%=imagePath %>/${p.prdPic}" width="80" height="80" /></a><span
												class="fl">${p.prdName} </span>
										</div></td>
									<td align="center" valign="middle"><div>${p.prdStandard}</div></td>
									<td align="center" valign="middle"><div>${p.stanColorName}</div></td>
									<td align="center" valign="middle"><div>${p.stanSizeName}</div></td>
									<td align="center" valign="middle"><div>￥${p.prdMarketPrice}</div></td>
									<td align="center" valign="middle"><div>￥${p.actiPrice}</div></td>
									<td align="center" valign="middle"><div>1</div></td>
									<td align="center" valign="middle"><div>
									
									<%=OrderConstants.orderChildMap.get(((OrderDetailDTO)request.getAttribute("detail")).getChilds().get(0).getState())%>
									</div></td>
								</tr>

								<tr class="h_70">
									<td colspan="8" align="center" valign="middle"><span><em
											class="luse">订单编号：</em>${detail.orders.id}</span><span><em
											class="luse">申请单编号：</em>${detail.childs[0].applyId }</span><span><em
											class="luse">活动编号：</em>${detail.childs[0].activityId }</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
		</div>
	</div>
</body>
</html>
