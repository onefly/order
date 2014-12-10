<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<link href="${pageContext.request.contextPath}/style/trial.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		function timeDown(id, date) {
			var ts = (new Date(date)) - (new Date());//����ʣ��ĺ�����
			var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);//����ʣ�������
			var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10);//����ʣ���Сʱ��
			var mm = parseInt(ts / 1000 / 60 % 60, 10);//����ʣ��ķ�����
			var ss = parseInt(ts / 1000 % 60, 10);//����ʣ�������
			dd = checkTime(dd);
			hh = checkTime(hh);
			mm = checkTime(mm);
			ss = checkTime(ss);
			document.getElementById(id).innerHTML = dd + "<em>天</em>" + hh
					+ "<em>时</em>" + mm + "<em>分</em>" + ss + "<em>秒</em>";
		}
		function checkTime(i) {
			if (i < 10) {
				i = "0" + i;
			}
			return i;
		}
		function countdown(id, date) {
			timeDown(id, date);
			window.setInterval(function() {
				timeDown(id, date);
			}, 1000);

		}
		countdown("applyTimeSpan", $("#hidden_time").val());
		$("#showMoney").text($("#ensureCash").val());
	});
</script>
<div class="blog_cl fl">
	<img src="http://192.168.6.110:8090/group1/M00/00/29/wKgGblOWmgTcJB-nAABNN3cuyUQ905.jpg"
		width="300" height="535" />
</div>
<div class="blog_cr fr fixed">
	<div class="blog_crt">
		<h2>裸价体验</h2>
		<div class="blog_crtc">
			<a href="#" class="fl"><img
				src="http://192.168.6.110:8090/group1/M00/00/29/wKgGblOWl9WW0NTXAABI7Hs4_9E287.jpg"
				width="200" height="200" /></a>
			<div class="fr">
				<ul>
					<li class="fr01"><a href="#">${productBO.product.productName}</a></li>
					<li class="fr02"><c:if
							test="${productBO.currentDate <  productBO.applyStartTime}">
							<input type="hidden" id="hidden_time"
								value="${productBO.applyStartTime}" />
                   		距离申请开始 <span id="applyTimeSpan">6 天 30 时 54
								分 10 秒</span>
						</c:if> <c:if
							test="${productBO.currentDate >=  productBO.applyStartTime && productBO.currentDate < productBO.applyEndTime}">

							<input type="hidden" id="hidden_time"
								value="${productBO.applyEndTime}" />
                   		距离申请结束 <span id="applyTimeSpan">6 天 30 时 54
								分 10 秒</span>
						</c:if> <c:if test="${productBO.currentDate >= productBO.applyEndTime}">
                   		申请已经结束
                  </c:if></li>
					<li class="fr03"><span class="gui01">规格：${productBO.product.standard}</span></li>
					<li class="fr03"><span class="gui01">市场价：￥${productBO.product.marketPrice}</span></li>
					<li class="fr04">体验价：￥<em>${productBO.activity.price}</em></li>
					
				</ul>
				<input type="hidden" id="ensureCash" value="${productBO.activity.price}"/>
				<p>
					累计裸价体验：<em class="luse">${productBO.stat.totalExperience}人</em>
				</p>
			</div>
		</div>
	</div>
	<div class="blog_crb top20">
		<h2>美试体验指数</h2>
		<div class="tiyan">
			
			 <div class="cpxhd">
                <h3>产品喜好度</h3>
                <div class="cpxhd_del"> <span class="fl">好</span>
                  <div class="cpxhd_du"><span class="color_1" style="width:${(productBO.stat.goodEvaluate/100)*220}px;"></span></div>
                  <p>${productBO.stat.goodEvaluate}%</p>
                </div>
                <div class="cpxhd_del"> <span class="fl">一般</span>
                  <div class="cpxhd_du"><span class="color_2" style="width:${(productBO.stat.middleEvaluate/100)*220}px;"></span></div>
                  <p >${productBO.stat.middleEvaluate}%</p>
                </div>
                <div class="cpxhd_del"> <span class="fl">不好</span>
                  <div class="cpxhd_du"><span class="color_3" style="width:${(productBO.stat.badEvaluate/100)*220}px;"></span></div>
                  <p>${productBO.stat.badEvaluate}%</p>
                </div>
                <p class="time1 fl">产品上线时间：<fmt:formatDate value="${productBO.product.createTime}"
						pattern="yyyy/MM/dd" /></p>
                <p class="time2 fr">免费试用体验：<span class="yellow">${productBO.stat.totalExperience}人</span></p>
              </div>
			
			 <div class="ppphd">
                <h3>品牌偏好度</h3>
                <div class="ppphd_del"> <span class="fl">喜欢</span>
                  <div class="ppphd_du"><span class="color_4" style="width:${(productBO.like/(productBO.like+productBO.general+productBO.dislike))*220}px;"></span></div>
                  <p><fmt:formatNumber
							value="${(productBO.like/(productBO.like+productBO.general+productBO.dislike))*100}"
							pattern="##.#" minFractionDigits="1" />%</p>
                </div>
                <div class="ppphd_del"> <span class="fl">没感觉</span>
                  <div class="ppphd_du"><span class="color_5" style="width:${(productBO.general/(productBO.like+productBO.general+productBO.dislike))*220}px;"></span></div>
                  <p ><fmt:formatNumber
							value="${(productBO.general/(productBO.like+productBO.general+productBO.dislike))*100}"
							pattern="##.#" minFractionDigits="1" />%</p>
                </div>
                <div class="ppphd_del"> <span class="fl">不喜欢</span>
                  <div class="ppphd_du"><span class="color_6" style="width:${(productBO.dislike/(productBO.like+productBO.general+productBO.dislike))*220}px;"></span></div>
                  <p><fmt:formatNumber
							value="${(productBO.dislike/(productBO.like+productBO.general+productBO.dislike))*100}"
							pattern="##.#" minFractionDigits="1" />%</p>
                </div>
                <p class="time1 fl">品牌入驻时间：<fmt:formatDate value="${productBO.product.createTime}"
						pattern="yyyy/MM/dd" /></p>
                <p class="time2 fr">累计体验：<span class="yellow">${productBO.total}人</span></p>
              </div>
		</div>
	</div>
</div>