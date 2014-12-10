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
     <p class="yellow n_numbera">请在<span id="downTime">29分钟10秒</span>内支付，逾期订单自动取消并关闭，体验宝不予退还</p>
     <p class="n_numberb">您的订单已生成，请立即支付保证金</p>
     <table width="1000" border="0" cellspacing="0" cellpadding="0" class="bolod">
  <tr class="bolodt fixed">
    <td width="333" align="center" valign="middle">订单号</td>
    <td width="333" align="center" valign="middle">需支付保证金</td>
    <td width="333" align="center" valign="middle">消耗体验宝数量</td>
  </tr>
  <tr class="bolodb fixed">
    <td width="333" align="center" valign="middle">${order.id}</td>
    <td width="333" align="center" valign="middle">￥${order.orderFund}</td>
    <td width="333" align="center" valign="middle">1</td>
  </tr>
</table>
  <div class="n_numberc_bot">
          <p>您可以点击<a href="#" class="luse">【立即支付】</a>选择支付方式进行支付。 </p>
          <p>确认收货后，请及时填写商品的评价，美试网将在24小时内赠送您100积分、1个此品牌勋章、1个体验值至您的账户中心。</p>
          <p>保证金返还时间：提交体验报告，品牌将在3日内审核通过，美试网7到15个工作日内返还到支付账户。</p>
          <p class="numberc_center">
            <input type="button"  id="button2" value="立即支付" class="input_100" />
            <input type="button" id="button2" onclick="detail();"value="查看订单详情" class="input_100" />
          </p>
          <div id="TB_overlayBG"></div>
          <div class="box" style="display:none"> </div>
        </div>
      </div>


     
     
     
    </div>
    
    
   <%@include file="/WEB-INF/jsps/includes/foot.jsp"%>
  </div>
</div>
</body>
</html>
