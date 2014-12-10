<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.qianqian.order.utils.OrderConstants,com.qianqian.order.model.Orders,com.qianqian.order.model.OrderChild,com.qianqian.order.dto.*" %>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

	<link href="${pageContext.request.contextPath}/style/base.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/Naked_price_information.css" rel="stylesheet" type="text/css" />
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
		if(state==602){
			$("#orderStateAnwser").addclass("bold");
			$("#stateLine5").attr("style"," ")
		}

	});
</script>
</head>

<body>
	<%@include file="/WEB-INF/jsps/includes/top.jsp"%>
	<div id="wapper">
		<div class="main top30 fixed">
		
      <p class="bottom_solid">您现在位于：首页 >> 裸价体验 <em class="green">- 订单：${detail.orders.id }</em></p>
      <div class="n_order fixed">
        <div class="n_trace">
          <p class="green"><span class="bj_lj">裸价体验　<em>小计：</em>￥${detail.orders.orderFund}</span>订单追踪</p>
          <div class="n_traceq boreder">
							<div class="n_traceqt">
							<input id="orderState" type="hidden" value="${detail.orders.sysState }"/>
							
								<span id="orderStateSubmit"><em>提交订单</em><br /><fmt:formatDate
												value="${detail.orders.createTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
												value="${detail.orders.createTime}" type="time" />
									</span> <span id="orderStatePay"><em>支付订单</em><br /><fmt:formatDate
												value="${detail.orders.buyerPaymentTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
												value="${detail.orders.buyerPaymentTime}" type="time" /></span> <span id="orderStateDeliver"><em>订单发货</em><br /><fmt:formatDate
												value="${detail.orders.sellerDeliverTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
												value="${detail.orders.sellerDeliverTime}" type="time" /></span> <span id="orderStateReceive"><em>确认收货</em><br /><fmt:formatDate
												value="${detail.orders.buyerSigninTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
												value="${detail.orders.buyerSigninTime}" type="time" /></span> <span id="orderStateAnwser"><em>评价体验</em><br /><fmt:formatDate
												value="${detail.orders.buyerSubmitEvaluateTime}" pattern="yyyy/MM/dd" />&nbsp;<fmt:formatDate
												value="${detail.orders.buyerSubmitEvaluateTime}" type="time" /></span>
								<div id="stateLine1" class="bj_trace01  fixed"  style="display: none;"></div>
								<div id="stateLine2" class="bj_trace02 fixed" style="display: none;"></div>
								<div id="stateLine3" class="bj_trace03 fixed" style="display: none;"></div>
								<div id="stateLine4" class="bj_trace04 fixed" style="display: none;"></div>
								<div id="stateLine5" class="bj_trace05 fixed" style="display: none;"></div>
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
					<p class="luse">收货人信息</p>
					<div class="n_order02 fixed">
						<span>${detail.orders.addrRecieveName}</span><span>${detail.orders.addrRecieveMobile}</span><span>${detail.orders.addrZipCode}</span><span>${detail.orders.addrFullAddress}</span>
					</div>
					<p class="luse">支付方式</p>
					<div class="n_order02 fixed">${detail.orders.payWay}</div>
					<p class="luse">发票信息</p>
					<div class="n_order02 fixed">
						<p>发票类型：普通发票</p>
						<p>发票内容：${detail.orders.invoiceContent}</p>
						<p>发票抬头：${detail.orders.invoiceTitle}</p>
					</div>
					<p class="luse">买家留言</p>
					<div class="n_order02 fixed">${detail.orders.remark}</div>



					<p class="luse">体验信息</p>
					<table class="tab_noe fixed">
          <thead>
            <tr>
              <th width="292" align="center" valign="middle"><div>产品名称</div></th>
              <th width="94" align="center" valign="middle"><div>规格</div></th>
              <th width="94" align="center" valign="middle"><div>颜色</div></th>
              <th width="94" align="center" valign="middle"><div>尺码</div></th>
              <th width="94" align="center" valign="middle"><div>市场价</div></th>
              <th width="94" align="center" valign="middle"><div>体验价</div></th>
              <th width="94" align="center" valign="middle"><div>消耗体验宝</div></th>
              <th width="144" align="center" valign="middle"><div>订单状态</div></th>
            </tr>
          </thead>
		  <c:forEach items="${detail.childs}" var="p">
          <tbody>
            <tr class="h110">
              <td width="292" valign="middle"><div class="border_img"><a href="#" class="fl f_l"><img src="<%=imagePath %>/${p.prdPic}" width="80" height="80" /></a>
                  <p class="fl w180"><a href="#">${p.prdName}</a></p>
                </div></td>
              <td width="94" align="center" valign="middle"><div>${p.prdStandard}</div></td>
              <td width="94" align="center" valign="middle"><div>${p.stanColorName}</div></td>
              <td width="94" align="center" valign="middle"><div>${p.stanSizeName}</div></td>
              <td width="94" align="center" valign="middle"><div>￥${p.prdMarketPrice}</div></td>
              <td width="94" align="center" valign="middle"><div>￥${p.actiPrice}</div></td>
              <td width="94" align="center" valign="middle"><div>1个</div></td>
              <td width="144" align="center" valign="middle"><div><%=OrderConstants.orderChildMap.get(((OrderDetailDTO)request.getAttribute("detail")).getChilds().get(0).getState())%></div></td>
            </tr>
            <tr>
              <td colspan="8"><div class="b_gray">
                  <dl>
                    <dt class="fixed"> <span class="fl"><em class="green">体验目的</em>${p.actiPurpose}</span> <span class="fr"><em class="green">活动编号</em>1234567890123456</span> </dt>
                    <dd class="fixed"> <span class="fl green">参与标准</span> <span class="fl fl_green"><em>性别要求： <c:choose>
													<c:when test="${p.actiGender==0}">
														女
													</c:when>
													<c:when test="${p.actiGender==1}">
														男
													</c:when>

													<c:otherwise>
														不限
													</c:otherwise>
												</c:choose></em><em>年龄要求：${p.actiAgeMin}-${p.actiAgeMax}岁</em><em>会员类别：<c:if test="${p.actiUserType ==0}">普通会员</c:if>
												<c:if test="${p.actiUserType ==1}">VIP会员</c:if>
												<c:if test="${p.actiUserType ==2}">体验师</c:if>
												<c:if test="${p.actiUserType ==3}">产品经理</c:if></em><em>体验等级： <c:choose>
													<c:when test="${p.actiGradeLow==-1}">
														不限
												</c:when>
													<c:otherwise>
													LV${p.actiGradeLow}-LV${p.actiGradeHigh}
												</c:otherwise>
												</c:choose></em><em>本品牌勋章：${p.actiBrandNum}个以上</em><em>地区要求：大陆地区</em><em class="w200"><c:if
													test="${p.actiAreaType==0}">
												以下省份参加:
												</c:if> <c:if test="${p.actiAreaType==1}">
												以下省份不参加:
												</c:if> <c:if test="${p.actiAreaType==2}">
												不限
												</c:if> <c:forEach items="${fn:split(p.actiArea,',')}"
													var="actiArea">
													${actiArea}
												</c:forEach>
									</em></span> </dd>
                	  </dl>
                </div></td>
            </tr>
          </tbody>
         </c:forEach>
        </table>
					<p class="n_order04 n_order05 fixed">
						<span class="fl">填写体验评价，将赠送100积分，请及时评价。</span><span>合计支付金额：￥${detail.orders.orderFund}<em
							class="yellow"></em></span><span>合计消耗体验宝数量： ${ fn:length(detail.childs)}<em class="yellow">个</em></span>
					</p>

				</div>




			</div>

			<div class="n_img fixed">
				<img src="${pageContext.request.contextPath}/images/classify06.jpg"
					width="1000" height="120" />
			</div>
		</div>
	</div>
</body>
</html>
