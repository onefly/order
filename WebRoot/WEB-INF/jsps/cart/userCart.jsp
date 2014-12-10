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
</head>
<body>
<%@include file="/WEB-INF/jsps/includes/top.jsp"%>

<div id="wapper">

  <div class="main top30 fixed">
    <p class="n_fzie fixed">品牌体验车</p>
    <div class="price top30 fixed">
      <div class="n_brandtyc fixed">
      
        <c:forEach items="${userCart.brandCarts}" var="brandCart" >
        <div class="tyc_list fixed">
        <form action="${pageContext.request.contextPath}/cart/getBrandCart.htm" method="get">
          <div class="tyc_list01 fixed"><a href="#"><img src="<%=imagePath%>${brandCart.brandImgSmall}" width="110" height="110" /></a><span>${brandCart.commdityNum}个裸价产品<br />
            合计：￥${brandCart.amount}
            <input type="hidden" name="brandId" value="${brandCart.brandId}"/>
            <input type="submit" id="button" value="去结算" class="tyc_button" />
 			         
            </span> </div></form>
          <div class="tyc_list02 fixed"> <span class="fl">${brandCart.brandName}品牌体验</span> <a href="${pageContext.request.contextPath}/cart/deleteBrandCart.htm?brandId=${brandCart.brandId}" onclick="return confirm('确定要删除此体验车？');" class="luse fr">删除 &gt;</a> </div>
        </div>
        </c:forEach>
        
      </div>
      <p class="n_brandtyc_order">体验车共有<em class="yellow">${userCart.cartNum}</em>个品牌订单，请及时确认体验</p>
    </div>
  <%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
  </div>
</div>
</body>
</html>
