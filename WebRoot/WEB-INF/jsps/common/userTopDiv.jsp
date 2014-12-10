<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<input type="hidden" value="nickname" id="nickname"/>
<input type="hidden" value="headImg" id="headImg"/>
<div class="blog_topa">
	<img src="http://192.168.6.110:8090/group1/M00/00/27/wKgGblORJTfPqrN6AAztNIFrKII227.png" width="1000" height="180" /><a
		href="#" class="medal">品牌勋章</a>
</div>
<div class="blog_bottom">
	<div class="blog_bottom_left">
		<div class="blog_bl_img">
			<img src="http://192.168.6.110:8090/group1/M00/00/29/wKgGblOWmhjvCPw4AAA9SxXTqtI607.jpg" width="190" height="190" /> <a
				href="#" class="ren"><img src="${pageContext.request.contextPath}/images/icon/yzm18-1.png"
				width="32" height="32" /></a>
		</div>
		<div class="blog_bl_tp">
			<span class="xux">${userBO.focusCount}<br /> <em>关注</em></span> <span>${userBO.fansCount}<br />
				<em>粉丝</em></span>
		</div>
	</div>
	<div class="blog_bottom_cent">
		<ul>
			<li class="blog_tp01"><span class="nic01">${userBO.user.nickname}<em><img
						src="${pageContext.request.contextPath}/images/icon/yzm23.png" width="20" height="16" /></em></span><span
				class="nic02">真实姓名：${userBO.user.name}</span><span class="nic02">美试ID：
					${userBO.user.userId}</span></li>
			<li class="blog_tp02">时间总是在不经意间溜走 让我们来不及准备时间总是在不经意间溜走 让我们来不及准备</li>
			<li class="blog_tp03"><span>${userBO.user.role}</span>|<span>LV${userBO.user.level}</span>|<span>${userBO.user.gender}</span>|<span>28岁</span>|<span>射手座</span>|<span>${userBO.user.provinceName}</span>|<span>${userBO.user.cityName}</span>|<span>${userBO.user.districtName}</span></li>
			<li class="blog_tp04"><a href="#" class="attention">关注</a> <a
				href="#" class="praisea">点赞 | 已获得${userBO.supportCount}赞</a><a href="#"
				class="gift">送礼</a><a href="#" class="share">分享</a><span>体验报告数：<em
					class="luse">${userBO.reportCount}</em> 报告品均分：<em class="luse">${userBO.aveScore}分</em></span></li>
		</ul>
	</div>
	<div class="blog_bottom_right">
		<a href="#"><img src="http://192.168.6.110:8090/group1/M00/00/29/wKgGblOWnK_en5PyAABGLqMeGg0796.jpg" width="140"
			height="140" /></a> <a href="#" class="fens"><img
			src="${pageContext.request.contextPath}/images/icon/yzm22.png" width="32" height="38" /></a>
	</div>
</div>