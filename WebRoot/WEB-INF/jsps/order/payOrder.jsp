<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单成功并支付</title>
<link href="${pageContext.request.contextPath}/style/public.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/Naked price.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
<script type="text/javascript">
$(function(){
	
	$(".showbox").click(function(){
		$("#TB_overlayBG").css({
			display:"block",height:$(document).height()
		});
		$(".box").css({
			left:($("body").width()-$(".box").width())/2-20+"px",
			top:($(window).height()-$(".box").height())/2+$(window).scrollTop()+"px",
			display:"block"
		});
	});
	
	$(".close").click(function(){
		$("#TB_overlayBG").css("display","none");
		$(".box ").css("display","none");
	});
	countdown("downTime",$("#endtime").val());
	
	
		
	
});
	function detail(){
	
		location="${pageContext.request.contextPath}/order/detail.htm?id=${order.id}";
	}
</script>
</head>


<body>
<%@include file="/WEB-INF/jsps/includes/top.jsp"%>
<div id="wapper">
  <div class="main top30 fixed">
    <div class="public">
    <input type="hidden" id="endtime" value="${orderCancelTime}"/>
     <p class="yellow n_numbera">请在<span id="downTime">29分钟10秒</span>内支付，逾期订单自动取消并关闭，并将3天内返还您的体验宝</p>
     <p class="n_numberb">您的订单已生成，订单编号:${order.id},并已扣除${order.payIngotNum}个体验宝，请立即支付</p>
     <table width="1000" border="0" cellspacing="0" cellpadding="0" class="bolod">
  <tr class="bolodt fixed">
    <td width="333" align="center" valign="middle">订单号</td>
    <td width="333" align="center" valign="middle">需支付金额</td>
    <td width="333" align="center" valign="middle">配送方式</td>
  </tr>
  <tr class="bolodb fixed">
    <td width="333" align="center" valign="middle">${order.id}</td>
    <td width="333" align="center" valign="middle">￥${order.orderFund}</td>
    <td width="333" align="center" valign="middle">免费</td>
  </tr>
</table>
  <div class="n_numberc top30">
   <p class="n_numberc01">支付方式</p>
   <div class="n_numberc_bot">
    <p>招商银行 <a href="#" class="yellow">【修改】</a></p>
    <p>您可以点击立即支付立刻进行网上支付。支付完毕后，商家将安排您的货品发出；</p>
    <p>请及时填写商品的评价及指数，我们将24小时内赠送您100积分和1个该品牌勋章至您的账户，请到您的账户中心查询充值记录。</p>
    <p class="numberc_center">
    <a href="javascript:void(0);" class="showbox">立即支付</a><input type="button" onclick="detail()" id="orderDetail" value="查看订单" class="input_100" /></p>
    <div id="TB_overlayBG"></div>
	<div class="box" style="display:none">
     
	</div>
    
    
    
    
	
    <p class="numberc_center">您可以在 <a href="#" class="blue">我的美试</a> 中查看或取消之前的订单，如需体验请点击 <a href="#" class="blue">免费试用 >></a> <a href="#" class="blue">裸价体验 >></a></p>
   </div>
  
  </div>

     
     
     
    </div>
    
   <%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
  </div>
</div>
</body>
</html>
