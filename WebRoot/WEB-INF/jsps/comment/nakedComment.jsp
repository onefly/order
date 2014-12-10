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
	<title>裸价体验待评价</title>
	<link href="<%=basePath %>/style/public.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>/style/trial.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>/style/public.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>/style/Naked price.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/kindeditor-4.1.10/themes/default/default.css"/>
	<link rel="stylesheet" href="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.css" />
	
	<script src="<%=basePath %>/js/jquery.min.js"></script>
	<script src="<%=basePath %>/js/230banner.js"></script><!--230轮播焦点图-->
	<script src="<%=basePath %>/js/open_div.js" type="text/javascript" ></script>
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/kindeditor-min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.js"></script>
</head>
<body class="background_gray">
<div id="wapper">
  <div class="main fixed">
    <div class="public">
    
      <!-- 引入用户空间公共头 -->
      <div class="blog_top fixed">
        <c:import url="/common/getUserTop.htm?userId=5"/>
      </div>
      <!-- 引入用户空间公共头结束 -->
      
      
      <!-- 引入产品品牌活动信息公共页面 -->
      <div class="blog_cent top30 fixed">
        <c:import url="/common/getProductInfo.htm?activityId=199"/>
      </div>
      <!-- 引入产品品牌活动信息公共页面结束 -->
      
      
      <div class="blog_bott top30 fixed">
        <div class="blog_bl fl fixed">
          <div class="blog_blt">
            <h2>体验目的</h2>
            <div class="blog_bltc">世界上最畅销的润肤露，享受肌肤水润弹滑的乐趣世界上最畅销的润。</div>
          </div>
          <div class="blog_blc top20">
            <h2><span>美试指数和评价</span>填写完整，将<em class="yellow">赠送您100积分</em>，请及时评价。</h2>
            <div class="blog_blcc fixed">
              <div class="blog_blcc01">
                <h3><span class="ty01"></span>美试指数</h3>
                <div class="blog_blccq fixed">
                  <form action="" id="" method="post">
					<span>
	                  <p class="fl">我对本产品喜好度：</p>
	                  <input type="radio" name="prdRate" id="GOOD" />
	                  <label for="radio">好</label>
	                  <input type="radio" name="prdRate" id="ORDINARY" />
	                  <label for="radio">一般</label>
	                  <input type="radio" name="prdRate" id="BAD" />
	                  <label for="radio">不好</label>
                  	</span>
                  	
					<span>
	                  <p class="fl">我对本品牌偏好度：</p>
	                  <input type="radio" name="brdRef" id="LIKE" />
	                  <label for="radio">喜欢</label>
	                  <input type="radio" name="brdRef" id="ORDINARY" />
	                  <label for="radio">没感觉</label>
	                  <input type="radio" name="brdRef" id="DISLIKE" />
	                  <label for="radio">不喜欢</label>
                  	</span>
                  </form>
                </div>
              </div>
              <div class="blog_blcc01 top15 fixed">
                <h3><span class="ty02"></span>商品评价</h3>
                <textarea name="" cols="" rows="" class="wbpin"></textarea>
                <p>
                  <input type="button" name="comment_btn" class="pinti"
								id="comment_btn" onclick="" value="提交评价"/>
                  12/140</p>
              </div>
            </div>
          </div>
          <div class="top20"><img src="<%=basePath %>/images/classify18.jpg" width="720" height="80" /></div>
          <div class="blog_blc top20 fixed">
            <h2><span>体验报告评级</span></h2>
            <div class="blog_blcc blog_blcd fixed">
              <p>报告质量评分：<span class="yellow">暂未评分</span></p>
              <p>报告点赞数量：<span class="yellow">0</span></p>
            </div>
          </div>
          <div class="blog_blc top20 fixed">
            <h2><span>提交体验报告</span></h2>
            <div class="blog_blcc fixed">
              <div class="center"><img src="<%=basePath %>/images/classify16.jpg" width="600" height="55" /></div>
              <div class="center_top top20">
                <label for="textfield">体验报告标题：</label>
                <input type="text" name="textfield" id="textfield" />
              </div>
              <div class="center_bottom fixed">
                <label for="textfield" class="fixed">
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
                  <input type="button" name="report_btn" id="report_btn" value="提交报告" class="wbtijiao" />
                  <input type="button" name="showView_btn" id="showView_btn" value="预览" class="yul" />
                  <span class="fl yellow fize14">*商家评分后将无法修改</span>
                </p>
              </div>
              
              
              <!-- <p class="praise"><a href="#" class="praise01"><span>1232222</span></a><a href="#" class="praise02"><span>0</span></a></p>
              
              
              <div class="center_bottom border_none fixed">
              <form id="form1" name="form1" method="post" action="">
                <label for="textfield" class="fixed">输入评论：</label>
                  <textarea name="textarea" id="textarea" cols="45" rows="5" class="texta"></textarea>
                </form>
				<p class="top15">
                  <input type="submit" name="button" id="button" value="发送" class="wbtijiao" />
                </p>
              </div> -->
            </div>
          </div>
        </div>
        
        
        <!-- 引入右侧广告div -->
        <div class="classify_right fr">
          <c:import url="/common/getRightAd.htm"/>
        </div>
        <!-- 引入右侧广告div结束 -->
        
        
      </div>
    </div>
    <div class="n_img fixed">
      <img src="<%=basePath %>/images/classify06.jpg" width="1000" height="120" />
    </div>
  </div>
</div>
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