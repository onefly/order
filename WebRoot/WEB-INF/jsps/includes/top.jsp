<%@ page language="java"   pageEncoding="UTF-8" import="java.util.*,com.framelib.common.CommonConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>前台top通用</title>
<link href="${pageContext.request.contextPath}/style/base.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/header_footer.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script> 
$(function(){
	 //划过关注美试
  	 $("#addpos").mouseover(function(){
	    $(this).children().last().show()
		$(this).children().first().children().first().attr('src',"./images/lucency_icon/top_png02_1.png")
	 	$(this).addClass('addpos'); 
     })
	 $("#addpos").mouseout(function(){
	    $(this).children().last().hide();
		$(this).children().first().children().first().attr('src',"./images/lucency_icon/top_png02.png")
		$(this).removeClass('addpos');	 	 
     })
	 
	 //点击选择搜索类别
	 $('.searchBrand').click(function(event){
		  event.stopPropagation();
		 var _this = $(this)
		 if($(this).parent().next().is(":hidden")){
	      	 $(this).parent().next().slideDown()
		 }else{
		     $(this).parent().next().slideUp()	 
	     }
		$(this).parent().next().children().click(function(){
			_this.html($(this).children().html())
		})
	 })
	 document.onclick = function(){
	     	$('.search_menu').hide()
	 }
	 //划过正指真互
	 $(".pledge ul li").mouseover(function(){
	    $(this).children().last().show()
	 })
	 $(".pledge ul li").mouseout(function(){
	    $(this).children().last().hide()
	 })
	 	$.ajax({
		url : "<%=CommonConstants.COMMON_PATH.get("member.maxtp")%>/user/getTopData.jsonp",
		type : "get",
		async : false,
		dataType:"jsonp",
		success : function(data) {
			if (data.nickname != "") {
					$("#show_nickname").html(data.nickname);
					$("#login_link").attr("style", "display:none");
					$("#regist_link").attr("style", "display:none");
			}
		}
	});
})
</script>


<div class="header"> 
  <!--1000 begin-->
  <div class="header_top"> 
    <!--site begin-->
    <div id="site">
      <div class="site_nav_left">
        <ul>
          <li><a href="#"><img src="${pageContext.request.contextPath}/images/lucency_icon/top_png01.png" width="18" height="18" />移动美试</a></li>
          <li id="addpos"><a href="#"><img src="${pageContext.request.contextPath}/images/lucency_icon/top_png02.png" width="18" height="18" />关注美试</a>
            <div class="focus_ms" style="display:none;">
              <dl>
                <dd><a href="#"><img src="${pageContext.request.contextPath}/images/icon/friend01.jpg" width="28" height="28" /></a></dd>
                <dd><a href="#"><img src="${pageContext.request.contextPath}/images/icon/friend02.jpg" width="28" height="28" /></a></dd>
                <dd><a href="#"><img src="${pageContext.request.contextPath}/images/icon/friend03.jpg" width="28" height="28" /></a></dd>
              </dl>
              <ul>
                <li><img src="${pageContext.request.contextPath}/images/bannk/ewm_2.jpg" width="81" height="81" /></li>
                <li>关注美试</li>
              </ul>
            </div>
          </li>
          <li><a href="#"><img src="${pageContext.request.contextPath}/images/lucency_icon/top_png03.png" width="18" height="18" />收藏美试</a></li>
        </ul>
      </div>
      <div class="site_nav_right"><span>欢迎来美试！</span> <a href="${pageContext.request.contextPath}/user/toLogin.htm" id="login_link"">登录</a> | <a href="${pageContext.request.contextPath}/register/forward.htm" id="regist_link">免费注册</a> | <a href="#">我的美试</a> | <a href="#">积分商城</a> | <a href="#">公益基金</a> | <a href="#">美试VIP</a> | <a href="#">签到</a> </div>
    </div>
    <!--site end--> 
    <!--logo区域-->
    <div class="loge_area_left"> <a href="#" class="logo"></a>
      <div class="seek">
        <p>想试就试 体验品质</p>
        <div class="search_index">
          <p><span class="searchBrand">品牌</span>
            <input class="searchBox" type="text" value="">
            <input class="searchBtn" type="button" value="搜索">
          </p>
          <ul class="search_menu" style="display:none">
            <li><a href="#">网页</a></li>
            <li><a href="#">视频</a></li>
            <li><a href="#">图片</a></li>
            <li><a href="#">地图</a></li>
            <li><a href="#">购物</a></li>
            <li><a href="#">文库</a></li>
            <li><a href="#">新闻</a></li>
            <li><a href="#">百科</a></li>
          </ul>
        </div>
      </div>
      <div class="pledge">
        <ul>
          <li class="bg1"><a href="#">大牌体验</a>
            <div class="pledge_content"> <span></span>
              <div class="cont_line">大牌正品体验，全场商品均为正品假一赔十</div>
            </div>
          </li>
          <li class="bg2"><a href="#">美试指数</a>
            <div class="pledge_content"> <span></span>
              <div class="cont_line">大牌正品体验，全场商品均为正品假一赔十</div>
            </div>
          </li>
          <li class="bg3"><a href="#">消费真相</a>
            <div class="pledge_content"> <span></span>
              <div class="cont_line">大牌正品体验，全场商品均为正品假一赔十</div>
            </div>
          </li>
          <li class="bg4"><a href="#">产品互动</a>
            <div class="pledge_content"> <span></span>
              <div class="cont_line">大牌正品体验，全场商品均为正品假一赔十</div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <!--nav-->
    <div class="nav">
      <div class="nav_left">
        <h3>体验品牌分类<span></span></h3>
        <ul style="display:none;">
          <li><a href="#">品牌分类</a></li>
          <li><a href="#">品牌分类</a></li>
          <li><a href="#">品牌分类</a></li>
        </ul>
      </div>
     <div class="nav_right">
				<ul>
					<li><a href="http://192.168.6.6/index.html" >首页</a></li>
					<li><a href="http://192.168.6.6/free.html">免费试用</a></li>
					<li><a href="http://192.168.6.6/naked.html" class="hover">裸价体验</a></li>
					<li><a href="#">美试指数</a></li>
					<li><a href="#">消费真相</a></li>
					<li><a href="#">产品经理</a></li>
					<li><a href="#">大牌活动</a></li>
					<li><a href="#">私人定制</a></li>
					<li><a href="#">拼手气</a></li>
				</ul>
		
    </div>
    <!--nav end--> 
  </div>
  <!--1000 end--> 
</div>

