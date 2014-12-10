<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>提交订单</title>
<link href="${pageContext.request.contextPath}/style/public.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/Naked price.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cart/submitOrder.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/common/area.js"></script>

</head>

<body>
<%@include file="/WEB-INF/jsps/includes/top.jsp"%>

<div id="wapper">
  <div class="main top30 fixed">
    <div class="public">
     <p class="bottom_solid">您现在位于：首页  &gt;&gt; 裸价体验 <em class="luse">- 订单</em></p>
     <div class="n_order fixed">
      <p class="luse">填写并核对订单信息</p>
      <div class="n_order01">
      
       <ul class="n_order01a fixed" style="display:block" id="defaultReceiver">
        <li>
         <div class="luse">收货人信息<a href="javascript:changeReceiver()" class="yellow">[修改]</a></div>
         <div class="fl">
          <p><span class="width140">姓名：<span id="receiveNameSpan">${bo.receiver.recieveName}</span></span><span class="width200">手机：<span id="mobileSpan">${bo.receiver.recieveMobilephone}</span></span>
          <span class="width200">固定电话：<span id="telephoneSpan">${bo.receiver.recieveTelephone}</span></span></p>
          <p>收货人地址：<span id="detailAddrSpan">${bo.receiver.provinceName}${bo.receiver.cityName}${bo.receiver.districtName}${bo.receiver.address}</span></p>
         </div>
        </li>
       </ul>
       <ul class="n_order01b top30 fixed" style="display:none" id="otherReceiver">
        <li>
         <div class="luse">收货人信息</div>
         <div class="fl">
         
         <div id="receiverListDiv">
           <jsp:include page="receiverListDiv.jsp" />
           
           </div>
           
          <p>
           <input type="button" style="margin-left:15px; font-size:14px; padding:0 15px; height:30px; background:url(${pageContext.request.contextPath}/images/img/data02.png) repeat-x; color:#fff; border:none;"  
           onclick="onEnterSaveButton()" value="保存收货人信息" class="input125" />
          </p>
         </div>
        </li>
       </ul>  
      </div>
      
      <input type="hidden" id="isSaveReceiver" value="0"/>
      <input type="hidden" id="operateFlag" value="0"/>
      
      <!-- 提交订单表单开始 -->
      <form action="${pageContext.request.contextPath}/order/addOrder.htm" method="post" id="submitOrderForm">
       <input type="hidden" name="type" id="type" value="${bo.type}"/>
       <input type="hidden" name="brandId" id="brandId" value="${bo.brandId}"/>
       <input type="hidden" name="brandName" id="brandName" value="${bo.brandName}"/>
       <input type="hidden" name="codeVersion" id="codeVersions" value="${bo.codeVersions}"/>
       <input type="hidden" name="addrRecieveName" id="recieveName" value="${bo.receiver.recieveName}"/>
       <input type="hidden" name="addrRecieveMobile" id="recievePhone" value="${bo.receiver.recieveMobilephone}"/>
       <input type="hidden" name="addrRecievePhone" id="recieveTelephone" value="${bo.receiver.recieveTelephone}"/>
       <input type="hidden" name="addrProvinceId" id="province" value="${bo.receiver.province}"/>
       <input type="hidden" name="addrProvinceName" id="provinceName" value="${bo.receiver.provinceName}"/>
       <input type="hidden" name="addrCityId" id="city" value="${bo.receiver.city}"/>
       <input type="hidden" name="addrCityName" id="cityName" value="${bo.receiver.cityName}"/>
       <input type="hidden" name="addrDistrictId" id="district" value="${bo.receiver.district}"/>
       <input type="hidden" name="addrDistrictName" id="districtName" value="${bo.receiver.districtName}"/>
       <input type="hidden" name="addrAddress" id="address" value="${bo.receiver.address}"/>
       <input type="hidden" name="addrFullAddress" id="detailAddress" value="${bo.receiver.provinceName}${bo.receiver.cityName}${bo.receiver.districtName}${bo.receiver.address}"/>
       
       <input type="hidden" name="hasInvoice" id="hasInvoice" value="1"/><!-- 是否需要发票，1：需要，2：不需要 -->
       <input type="hidden" name="invoiceTitle" id="invoiceTitle" value="北京千千方式文化传播公司"/>
       <input type="hidden" name="invoiceType" id="invoiceType" value="1"/><!-- 发票类型: 1:普通发票;2:增值税发票 -->
       <input type="hidden" name="invoiceContent" id="invoiceContent" value="商品明细"/>
	       
      <p class="luse">买家留言</p>
      <textarea name="remark" cols="" rows="" onkeydown="if(value.length>140) value=value.substr(0,140)" class="n_order01"></textarea>
      <p class="luse">发票信息</p>
      <div class="n_order02 fixed">
      <p>发票类型：普通发票 <a href="#" class="yellow">[修改]</a></p>
      <p>发票内容：明细<a href="#" class="yellow">[修改]</a></p>
      <p>发票抬头：个人<a href="#" class="yellow">[修改]</a></p>
      </div>
     
       <!-- 提交订单表单结束 -->
      <p class="luse">体验信息</p>
      <div class="n_order03 fixed">
       <ul class="n_order03_top fixed">
        <li class="n_order03a01">产品名称</li>
        <li class="n_order03a02">规格</li>
        <li class="n_order03a03">尺码</li>
        <li class="n_order03a04">颜色</li>
        <li class="n_order03a05">市场价</li>
        <li class="n_order03a06">体验价</li>
        <li class="n_order03a07">消耗体验宝</li>
       </ul>
       <ul class="n_order03_cent fixed">
       
       <c:forEach items="${bo.productBoList}" var="productBo" varStatus="s">
       <input type="hidden" name="orderChilds[${s.index}].prdCode"  value="${productBo.product.productCode}"/>
       <input type="hidden" name="orderChilds[${s.index}].prdVersion"  value="${productBo.product.version}"/>
       <input type="hidden" name="orderChilds[${s.index}].prdStandardId"  value="${productBo.standard.id}"/>
       <input type="hidden" name="orderChilds[${s.index}].activityId"  value="${productBo.activity.id}"/>
        <li class=" fixed">
         <a href="#"><img src="<%=imagePath%>/${productBo.picture.orderPic}" width="80" height="80" /></a>
         <span class="n_order03b01"><a href="#">${productBo.product.brandName}<br />${productBo.product.productName}</a></span>
         <span class="n_order03b02">${productBo.product.standard}</span>
         <span class="n_order03b03">${productBo.standard.sizeName}</span>
         <span class="n_order03b04">${productBo.standard.colorName}</span>
         <span class="n_order03b05">￥<fmt:formatNumber value="${productBo.product.marketPrice}" pattern="##.##" minFractionDigits="2" /></span>
         <span class="n_order03b06">￥<fmt:formatNumber value="${productBo.activity.price}" pattern="##.##" minFractionDigits="2" /> </span>
         <span class="n_order03b07">1个</span>
         <dl class="n_order03b08 fixed top15">
          <dt>
           <p>体验目的</p>${productBo.activity.purpose}
          </dt>
          <dd>
          <p>参与标准</p>
          <span class="n_participation01">年龄要求：${productBo.activity.ageMin}-${productBo.activity.ageMax}岁</span>
          <span class="n_participation02">性别要求：
           <c:if test="${productBo.activity.gender == 0}">
          	女
          </c:if>
          <c:if test="${productBo.activity.gender == 1}">
          	男
          </c:if>
           <c:if test="${productBo.activity.gender == 2}">
          	不限
          </c:if>
          </span>
          <span class="n_participation03">体验等级：LV${productBo.activity.gradeLow}-LV${productBo.activity.gradeHigh}</span>
          <span class="n_participation04">会员类别：
          <c:if test="${productBo.activity.userType == 0}">
          	普通会员
          </c:if>
          <c:if test="${productBo.activity.userType == 1}">
          	VIP会员
          </c:if>
          <c:if test="${productBo.activity.userType == 2}">
          	体验师
          </c:if>
          <c:if test="${productBo.activity.userType == 3}">
          	产品经理
          </c:if>
          </span>
          <span class="n_participation05">本品牌勋章：${productBo.activity.brandNum}个以上</span>
          <span class="n_participation06">地区要求:大陆地区</span>
         <span class="n_participation07"><c:if
													test="${productBo.activity.areaType==0 }">
												以下省份参加:
												</c:if> <c:if test="${productBo.activity.areaType==1}">
												以下省份不参加:
												</c:if> <c:if test="${productBo.activity.areaType==2}">
												不限
												</c:if> <c:forEach items="${fn:split(productBo.activity.area,',')}"
													var="actiArea">
													${actiArea}
												</c:forEach></span>
          </dd>
         </dl>
        </li>
        </c:forEach>
        
       
       </ul>
      </div>
      </form>
      <p class="n_order04 fixed"><span>合计支付金额：<em class="yellow">￥<fmt:formatNumber value="${bo.amount}" pattern="##.##" minFractionDigits="2" /></em></span><span>合计消耗体验宝数量：<em class="yellow">${bo.ingot}个</em></span></p>
        <input type="button"  id="submitOrderButton" onclick="submitOrder()" value="提交订单" class="input_180" />
     </div>
      
     
     <form id="toPayOrderForm" action="${pageContext.request.contextPath}/order/toPayOrder.htm" method="get">
     <input type="hidden" name="id" id="topayId" />
     <input type="hidden" name="payIngotNum" id="topayingot" />
     <input type="hidden" name="orderFund" id="topayamonut" />
     <input type="hidden" name="orderCancelTime" id="topayorderCancelTime" />
     </form>
     
    </div>
    
   <%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
  </div>
</div>
</body>
</html>
