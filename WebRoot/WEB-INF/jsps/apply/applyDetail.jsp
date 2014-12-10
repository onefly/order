<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/style/public.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/trial.css"
	rel="stylesheet" type="text/css" />
<title>申请单状态详情</title>
<script language="javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
</head>
<body>
<input type="hidden" id="applyState" value="${apply.applyState}"/>
<input type="hidden" id="submitState" value="${apply.submitState}"/>
	<div id="wapper">
		<%@include file="/WEB-INF/jsps/includes/free-top.jsp"%>
		<div class="main top30 fixed">
			<div class="public">
				<p class="bottom_solid">
					您现在位于：首页 &gt;&gt; 免费试用 <em class="luse">- 申请单编号：${apply.id}</em>
				</p>
				<div class="n_order fixed">
					<div class="n_trace">
						<p class="luse">
							<span>免费试用 <em>保证金：</em>￥${activity.price}元
							</span>
							
							<c:if test="${apply.auditEndTime lt currentDate && apply.submitEndTime gt currentDate}">
								<c:if test="${apply.applyState eq 1 && apply.submitState eq 0}">
								<script type="text/javascript">
									$(function(){
										countdown("submitOrderTip",$("#submitendtime").val());
									})
								</script>
								<input type="hidden" id="submitendtime" value="${apply.submitEndTime}"/>
									<span class="fize12" >
										您的申请单已审核通过，请及时提交订单，距离提交结束，还剩 <font   id="submitOrderTip">72小时00分钟00秒</font>。
									</span>
								</c:if>
							</c:if>
							
							申请单详情
						</p>
						<div class="n_traceq">
							<div class="n_traceqt">
								<span class="span01  " id="applyStateSpan1"><em>提交申请单</em><br /> <fmt:formatDate
										value="${apply.applyTime}" pattern="yyyy/MM/dd HH:mm:ss" /> </span>
								<span class="span02 ${apply.applyState eq 2 or (apply.applyState eq 0  and apply.submitState eq 0) ? 'bold' : ''}" id="applyStateSpan2"><em>审核中</em><br /> <fmt:formatDate
										value="${apply.applyTime}" pattern="yyyy/MM/dd HH:mm:ss" /> </span>
								<span class="span03 ${apply.applyState eq 1 and apply.submitState eq 0 ? 'bold' : ''}" id="applyStateSpan3"><em>审核通过</em><br /> <fmt:formatDate
										value="${apply.passTime}" pattern="yyyy/MM/dd HH:mm:ss" /> </span> <span
									class="span04 ${apply.applyState eq 1 and apply.submitState eq 1 ? 'bold' : ''} " id="applyStateSpan4"><em>提交订单</em><br /> <fmt:formatDate
										value="${apply.submitOrderTime}" pattern="yyyy/MM/dd HH:mm:ss" /> </span>
								<div class="bj_trace01 fixed" style="display: none;" id="applyStateDiv1" ></div>
								<div class="bj_trace02 fixed" ${apply.applyState eq 2 or (apply.applyState eq 0 && apply.submitState eq 0) ? '' : 'style="display: none;"'} id="applyStateDiv2" ></div>
								<div class="bj_trace03 fixed" ${apply.applyState eq 1 and apply.submitState eq 0 ? '' : 'style="display: none;"'} id="applyStateDiv3" ></div>
								<div class="bj_trace04 fixed" ${apply.applyState eq 1 and apply.submitState eq 1 ? '' : 'style="display: none;"'} id="applyStateDiv4" ></div>
							</div>
							<table width="1000" border="0" cellspacing="0" cellpadding="0"
								class="n_teceqb">
								<tr class="fize14">
									<td width="333" height="40" align="center" valign="middle">处理时间</td>
									<td width="334" height="40" align="center" valign="middle">处理信息</td>
									<td width="333" height="40" align="center" valign="middle">操作人</td>
								</tr>
								<c:forEach items="${handleLogs}" var="handleLog" varStatus="s">
									<tr class="fize12">
										<td width="333" height="35" align="center" valign="middle">
											<fmt:formatDate value="${handleLog.handleTime}"
												pattern="yyyy/MM/dd HH:mm:ss" />
										</td>
										<td width="334" height="35" align="center" valign="middle">${handleLog.handleNote}</td>
										<td width="333" height="35" align="center" valign="middle">${handleLog.handleBy}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<p class="luse">您的美试ID</p>
					<div class="n_order02 fixed">
						<span>美试ID：${user.userId}</span><span> 姓名：${user.name}</span><span>登录号：${user.phone}</span>
					</div>
					<p class="luse">体验目的</p>
					<div class="n_order02 fixed">${activity.purpose}</div>
					<p class="luse">参与标准</p>
					<div class="n_order02 n_order_none fixed" style="">
						<em>性别要求： <c:if test="${activity.gender eq 0 }">女</c:if>
						<c:if test="${activity.gender eq 1 }">男</c:if><c:if test="${activity.gender eq 2 }">不限</c:if>
						  </em><em>年龄要求：${activity.ageMin}-${activity.ageMax}岁</em><em>会员类别：
						   <c:if test="${activity.userType eq 0 }">普通会员</c:if>
						    <c:if test="${activity.userType eq 1 }">VIP会员</c:if>
						     <c:if test="${activity.userType eq 2 }">体验师</c:if>
						      <c:if test="${activity.userType eq 3 }">产品经理</c:if>
						  
						  </em><em>体验等级：LV${activity.gradeLow}-LV${activity.gradeHigh}</em><em>本品牌勋章：
						  <c:if test="${activity.brandNum eq -1 }">不限</c:if>
						   <c:if test="${activity.brandNum gt -1 }">${activity.brandNum}个及${activity.brandNum}个以上</c:if>
						  
						  </em><em>地区要求：大陆地区</em><em>
							 <c:if test="${activity.areaType eq 0 }">参加省份：${activity.area}</c:if>
							 <c:if test="${activity.areaType eq 1 }">不参加省份：${activity.area}</c:if>
							 <c:if test="${activity.areaType eq 2 }">参加省份：不限</c:if>
							</em>
					</div>
					<p class="luse">体验信息</p>
				
					<table class="tab_noe fixed">
        	<thead>
            	<tr>
                 <th width="286"><div>产品名称</div></th>
                 <th width="119"><div>规格</div></th>
                 <th width="119"><div>颜色</div></th>
                 <th width="119"><div>尺码</div></th>
                 <th width="119"><div>市场价</div></th>
                 <th width="119"><div>保证金</div></th>
                 <th width="119"><div>已消耗积分数</div></th>
                </tr>
             
            </thead>
            
            <tbody>
            	<tr>
                 <td align="center" valign="middle" class="mc_span"><div><a href="#" class="fl"><img src="<%=imagePath%>/${picture}" width="80" height="80" /></a><span class="fl">${product.brandName}
${product.productName}</span></div></td>
                 <td align="center" valign="middle"><div>${product.standard}</div></td>
                 <td align="center" valign="middle"><div>${standard.colorName}</div></td>
                 <td align="center" valign="middle"><div>${standard.sizeName}</div></td>
                 <td align="center" valign="middle"><div>￥${product.marketPrice}</div></td>
                 <td align="center" valign="middle"><div>￥${activity.price}</div></td>
                 <td align="center" valign="middle"><div>${costSocre}</div></td>
                </tr>
            </tbody>
            
        
        </table>
				</div>
			</div>
			<%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
		</div>
	</div>
</body>
</html>
