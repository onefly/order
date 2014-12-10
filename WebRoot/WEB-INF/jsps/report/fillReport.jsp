<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String detail = (String)request.getAttribute("detail");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>免费试用填写报告页</title>
	<link href="<%=basePath %>/style/public.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>/style/trial.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath %>/js/jquery.min.js"></script><!--230轮播焦点图-->
	<script src="<%=basePath %>/js/230banner.js"></script><!--230轮播焦点图-->
	<script src="<%=basePath %>/js/open_div.js" type="text/javascript" ></script> 

	<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/kindeditor-4.1.10/themes/default/default.css"/>
	<link rel="stylesheet" href="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.css" />
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/kindeditor-min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.js"></script>
	
	<script type="text/javascript">
	
		//提交按钮功能
 		function submitRep(){
			
			var ser = $("#report_form").serialize();
			var prdFlag = ser.search('prdRate');
			var brdFlag = +ser.search('brdRef');
			
			if(prdFlag>-1 && brdFlag>-1){
				oTk(id('hinta1'),id('abk'), id('close1'));
			}else{
				oTk(id('hinta'),id('abk'), id('close'));
			}
		}
		
		//确认提交按钮
		function confirmation(){
			//手动提交表单时先同步，否则获取不到文本内容
			editor.sync();
			$("#report_form").submit();
		}
		
	</script>
</head>
<body class="background_gray">
<div id="wapper">
  <div class="main fixed">
    <div class="public">
      
      <!-- 引入用户空间公共头部div页面 -->
      <div class="blog_top fixed">
        <c:import url="/common/getUserTop.htm?userId=${userId}"/>
      </div>
      <!-- 用户空间公共头部div页面结束 -->
      
      <p class="bottom_nav">首页 >> 免费试用 -<em class="luse"> 填写试用报告 - 订单：${orderId}</em></p>
      
      <!-- 引入产品与 品牌活动信息公共div页面-->
      <div class="blog_cent fixed">
		<c:import url="/common/getProductInfo.htm?activityId=${activityId}"/>
      </div>
      <!-- 产品与 品牌活动信息公共div页面结束-->
      
      <div class="blog_bott top30 fixed">
        <div class="blog_bl fl fixed">
          <div class="blog_blt">
            <h2>体验目的</h2>
            <div class="blog_bltc">世界上最畅销的润肤露，享受肌肤水润弹滑的乐趣世界上最畅销的润。</div>
          </div>
            
          <!-- 引入申请单信息div -->
          <div class="blog_blc top20">
            <c:import url="/common/getApply.htm?aid=${applyId }"/>
          </div>
          <!-- 申请单信息div结束 -->
          
          <div class="blog_blc top20 fixed">
            <h2><span>美试指数</span></h2>
            <form action="<%=basePath %>/report/submitReport.htm" name="report_form" id="report_form" method="post">
              <input type="hidden" name="activityId" value="${activityId }" />
              <input type="hidden" name="orderChildId" value="${orderChildId }" />
              <input type="hidden" name="lastState" value="${lastState }" />
              <input type="hidden" name="userId" value="${userId }" />
              <input type="hidden" name="applyId" value="${applyId }" />
              <div class="blog_blcc blog_blcg fixed">
                <p>产品喜好度评价：
                  <input type="radio" name="prdRate" id="prdGood" value="GOOD" />
                  <span>好<em class="icon01"></em></span>
                  <input type="radio" name="prdRate" id="prdOrdinary" value="ORDINARY" />
                  <span>一般<em class="icon02"></em></span>
                  <input type="radio" name="prdRate" id="prdBad" value="BAD" />
                  <span>不好<em class="icon03"></em></span>
				</p>
                <p>品牌偏好度评价：
                  <input type="radio" name="brdRef" id="brdLike" value="LIKE" />
                  <span>喜欢<em class="icon04"></em></span>
                  <input type="radio" name="brdRef" id="brdOrdinary" value="ORDINARY" />
                  <span>没感觉<em class="icon05"></em></span>
                  <input type="radio" name="brdRef" id="brdDislike" value="DISLIKE" />
                  <span>不喜欢<em class="icon06"></em></span>
				</p>
              </div>
            </div>
            <div class="top20"><img src="<%=basePath %>/images/classify18.jpg" width="720" height="80" /></div>
            <div class="blog_blc top20 fixed">
              <h2><span>体验报告评分</span></h2>
              <div class="blog_blcc blog_blcd fixed">
                <p>报告质量评分：<span class="yellow">暂未评分</span></p>
                <p>点赞数量：<span class="yellow">1111111</span></p>
                <p>一般数量：<span class="yellow">1111111</span></p>
              </div>
            </div>
            <div class="blog_blc top20 fixed">
              <h2><span>提交体验报告</span></h2>
              <div class="blog_blcc blog_blch fixed">
                <div class="center">
              	  <img src="<%=basePath %>/images/classify16.jpg" width="600" height="55" />
                </div>
              
                <div class="center_top fixed top20">
                  <label for="textfield">体验报告标题：</label>
                  <input type="text" name="reportTitle" id="reportTitle" />
                </div>
                <div class="center_bottom fixed">
               
                <label for="textfield" class="fixed">
                  <input type="button" name="but_showTemp" id="but_showTemp" value="点击查看报告样本及要求" class="baog" />
                  <span>*体验报告需满300字,并不少于5张照片,否则视为无效。</span>
                  	体验报告内容：
                </label>
                
          <!-- 文本编辑模块 -->
				  <textarea name="reportContent" id="reportContent" class="textarea"
					style="width:660px;height:800px;visibility:hidden;">
					<%=detail%>
				  </textarea>

				  	<script type="text/javascript">
					  	var editor;
						KindEditor.ready(function(K) {
							editor = K.create('textarea.textarea', {
								allowFileManager : false,	//不允许选择已经上传的图片
								allowImageRemote : false,	//不允许上传网络图片
								themeType : 'simple',
								resizeType:0,	//不可改变编辑器大小
								cssPath : basePath+'/js/kindeditor-4.1.10/plugins/code/prettify.css',
								uploadJson : basePath+'/common/uploadServlet.htm',
								afterCreate : function() {
									var self = this;
									K.ctrl(document, 13, function() {
										self.sync();
									});
									K.ctrl(self.edit.doc, 13, function() {
										self.sync();
									});
								}
							});
						});
					</script>
		<!-- 文本编辑模块结束 -->
                
                <p class="top15">
                  <input type="button" name="btn_submit" id="btn_submit" value="提交报告" class="wbtijiao" onclick="submitRep()"/>
                  <input type="button" name="btn_preview" id="btn_preview" value="预览" class="yul" />
                </p>
              </div>
              
              <!-- <p class="praise">
                <a href="#" class="praise02">
                  <span>0</span>
                </a>
                <a href="#" class="praise01">
                  <span>0</span>
                </a>
              </p> -->
              
              <%-- <div class="center_bottom border_none fixed">
                <form id="form1" name="form1" method="post" action="">
                  <label for="textfield" class="fixed">输入评论：</label>
                  <textarea name="textarea" id="textarea" cols="45" rows="5" class="texta"></textarea>
                </form>
                <p class="top15"> <span class="fl"><img src="<%=basePath %>/images/icon/biaoq.jpg" width="15" height="15" /></span>
                  <input type="submit" name="button" id="button" value="发送" class="wbtijiao" />
                </p>
              </div> --%>
            </div>
          </div>
        </div>
        
        <!-- 引入右侧广告div页面 -->
        <div class="classify_right fr">
		  <c:import url="/common/getRightAd.htm"/>
        </div>
        <!--右侧广告div页面结束 -->
        
      </div>
    </div>
  </div>
  
  
  <div id="hinta" class="hinta">
   <h2>提示<a href="#" id="close" class="close"></a></h2>
   <p>未填写<a href="#" class="luse">[美试指数]</a>，需要填写后，<br />才能提交体验报告。</p>
  </div>
  
  <div id="hinta1" class="hinta">
   <h2>提示</h2>
   <dl>
    <dt class="luse">报告提交后，将不能修改.</dt>
    <span>为了促进品牌提供更多的免费试用商品，请认真填写<br />
		       如果报告不符合要求，将不予退还保证金
	</span>
    <dd>
      <input type="submit" name="button2" id="button2" value="确认提交" class="l_bj" onclick="confirmation()" />
      <input type="submit" name="button2" id="close1" class="h_bj" value="取消" />
    </dd>
   </dl>
  </div>
  
</div>
<div id="abk"></div>

<script>

//	oTk(id('hinta'),id('abk'), id('close'),$('.wbtijiao'))
//	oTk(id('hinta1'),id('abk'), id('close1'),$('.wbtijiao')) 

</script>
</body>
</html>

<%!
	private String htmlspecialchars(String str) {
		if(str == null) return "";
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
%>