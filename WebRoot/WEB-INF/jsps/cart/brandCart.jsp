<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品牌体验车</title>
<link href="${pageContext.request.contextPath}/style/public.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/Naked price.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cart/brandCart.js"></script>
</head>
<body>
<%@include file="/WEB-INF/jsps/includes/top.jsp"%>

<div id="wapper">
  <div class="main top30 fixed">
    <div class="price fixed">
     <div class="n_state_fl">
      <h2 class="yellow">${brandCart.brandName}品牌体验车</h2> <input type="hidden" id="hid_commodity_num" value="${brandCart.commdityNum}"/>
      <input type="hidden" id="hid_brand" value="${brandCart.brandId}"/>
      <img src="<%=imagePath%>${brandCart.brandImgBig}" width="300" height="535" />
      </div>
      
      <form id="toOrderForm" action="${pageContext.request.contextPath}/order/toSubmitOrder.htm" method="get">
      <input type="hidden" name="brandId" value="${brandCart.brandId}" />
      <input type="hidden" name="brandName" value="${brandCart.brandName}" />
     <div class="n_state_fr">
     <h2 class="yellow"><span>裸价体验</span><span>合计：￥<font class="show_amount">${brandCart.amount}</font></span></h2>
     <div class="state_ft_cent">
      <ul id="commodity_ul">
      <c:forEach items="${brandCart.commoditys}" var="commodity" varStatus="s">
       <li class="fixed" id="li_${commodity.productCode}">
        <div class="img_fl">
         <a href="#"><img src="<%=imagePath%>${commodity.image}" width="150" height="150" /></a>
         <p>
          <input type="checkbox" name="isCost" id="checkbox_${commodity.productCode}" value="${commodity.productCode}-${commodity.version}-${commodity.standardId}-${commodity.activityId}" onclick="checkIsCost()" checked="checked"/>
          <input type="hidden" id="hid_price_${commodity.productCode}" value="${commodity.naked}"/>
           <input type="hidden" id="hid_ingot_${commodity.productCode}" value="${commodity.ingot}"/>
          <label for="checkbox">商品${s.count}</label>
         </p>
        </div>
        <div class="img_fr">
         <h3>${commodity.name}</h3>
         <div class="img_fr01 fixed"><p>规格：${commodity.standard}</p><p>市场价：￥${commodity.market}</p><p style="position: relative; left:20px;">消耗体验宝数：${commodity.ingot}</p></div>
         <div class="img_fr01 fixed"><span>裸价：<em class="yellow">￥${commodity.naked}</em></span></div>
           <input type="button" name="button" id="button" value="删除" onclick="deleteCommodity(${commodity.productCode},${commodity.ingot},${commodity.naked})" class="luse_button" />
        </div>
       </li>
      </c:forEach>
      </ul>
      <div class="state_ft_bott fixed">
      <p><input type="checkbox"  id="checkAllbox" checked="checked" onclick="checkAllBox()"/>
          <label for="checkbox">合并付款</label></p>
      <span>剩余体验宝数量：${remainIngot}个</span>
      <input type="button" name="button" id="button" onclick="toBuyIngot()" value="购买体验宝" class="yellow_button" />
      </div>
     </div>
     <div class="state_ft_footer fixed">
      <p>合计消耗体验宝数：<font class="show_ingot">${brandCart.ingots}</font>个<br />合计小计：￥<font class="show_amount">${brandCart.amount}</font></p>
      <input type="button" onclick="goToSubmitOrder()" value="去结算" class="yellow_button" />
     </div>
     </div>
     
    </form>
    </div>
    
    <%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
  </div>
</div>
</body>
</html>
