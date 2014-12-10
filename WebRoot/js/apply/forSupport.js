function addSupport(){
	$.ajax({
	      url : basePath+"/support/addSupport.json",
	      type : "post", //请求类型
	      async : false,//默认true异步请求 ，false同步请求 
	      data : {applyId:$("#applyId").val(),nickname:$("#nickname").val(),headImg:$("#headImg").val()},//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
	      success : function(data) { 
	           if (500 == data) {
	              //系统内部异常
	        	   popStatus(4, '系统出错！', 3);
	           } else if (501 == data) {
	              //用户未登录，请求被拦截
	        	   popStatus(2, '请先登录！', 3);
	           } else {
	              //正确返回结果
	              var count = parseFloat($("#supportCount").val());
	              var addCount = count+1;
	        	   if(data.result == 1){
	        		   	$("#supportCountSpan").text(addCount);
						 popStatus(1, '支持成功！', 3);
					}else if(data.result == 3){
						popStatus(2, '已经支持过该申请单！', 3);
					}else{
						popStatus(4, '操作失败！', 3);
					}
	          }
	     }
	});
}
//顶部用户信息div加载
function loadUserTop(){
	$.ajax({
	      url : basePath+"/common/getUserTop.htm",
	      type : "post", //请求类型
	      async : true,//默认true异步请求 ，false同步请求 
	      data : $("#hiddenApplyForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
	      success : function(data) { 
	           if (500 == data) {
	              //系统内部异常
	        	   popStatus(4, '系统出错！', 3);
	           } else if (501 == data) {
	              //用户未登录，请求被拦截
	        	   popStatus(2, '请先登录！', 3);
	           } else {
	              //正确返回结果
	              //alert(data.result);
	              $("#userTopDiv").html(data);
	          }
	     }
	});
}
//产品信息div加载
function loadProductInfo(){
	$.ajax({
	      url : basePath+"/common/getProductInfo.htm",
	      type : "post", //请求类型
	      async : true,//默认true异步请求 ，false同步请求 
	      data : $("#hiddenApplyForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
	      success : function(data) { 
	           if (500 == data) {
	              //系统内部异常
	        	   popStatus(4, '系统出错！', 3);
	           } else if (501 == data) {
	              //用户未登录，请求被拦截
	        	   popStatus(2, '请先登录！', 3);
	           } else {
	              //正确返回结果
	              //alert(data.result);
	              $("#productDiv").html(data);
	          }
	     }
	});
}
function loadDiv(){
	//loadUserTop();
	//loadProductInfo();
	countdown("downTimeFont", $("#hidden_time_start").val());
}
function submitComment(){
	var content = $("#commentContent").val();
	if(content.length == 0){
		popStatus(2, '评论内容不能为空！', 3);
		return;
	}
	if(content.length < 5){
		popStatus(2, '评论内容不能少于5个字！', 3);
		return;
	}
	var checkResult = checkShieldWord(content);
	if(checkResult == true){
		return;
	}
	 $.ajax({
			url : basePath+"/applyComment/addComment.htm",
			type : "post", //请求类型
			async : false,//默认true异步请求 ，false同步请求 
			data : $("#commentForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
			success : function(data) {
				if (500 == data) {
					//系统内部异常
					popStatus(4, '系统出错！', 3);
				} else if (501 == data) {
					//用户未登录，请求被拦截
					popStatus(2, '请先登录！', 3);
				} else {
					$("#applyCommentDiv").html(data);
				}
			}
		});
}
function searchList() {
	var url = basePath+"/applyComment/getCommentList.htm";
	$.ajax({
		url : url,
		type : "post", //请求类型
		async : false,//默认true异步请求 ，false同步请求 
		data : $("#commentForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
		success : function(data) {
			if (500 == data) {
				//系统内部异常
				//alert('系统内部异常');
				popStatus(2, '系统错误！', 3);
			} else if (501 == data) {
				//用户未登录，请求被拦截
				//alert('未登录');
				popStatus(2, '请先登录！', 3);
			} else {
				//正确返回结果
				$("#applyCommentDiv").html(data);
			}
		}
	});
}
function toThisPage(all) {
	var target = $('#currentPage').val();
	$("#hidden_currentPage").val(target);
	if (0 < target && target <= all) {
		searchList();
	} else {
		popStatus(2, '无效字符！', 3);
	}
}
function toShowPage(page) {
	$("#hidden_currentPage").val(page);
	var all = $("#hidden_allPage").val();
	if (0 < page && page <= all) {
		searchList();
	} else {
		popStatus(2, '无效字符！', 3);
	}
}
function replyComment(commentId){
	var url = basePath+"/applyComment/replyComment.json";
	var reply = new Date()+"这就是我的回复内容，哈哈哈哈"+commentId;
	$.ajax({
		url : url,
		type : "post", //请求类型
		async : false,//默认true异步请求 ，false同步请求 
		data : {commentId:commentId,reply:reply},//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
		success : function(data) {
			if (500 == data) {
				//系统内部异常
				//alert('系统内部异常');
				popStatus(2, '系统错误！', 3);
			} else if (501 == data) {
				//用户未登录，请求被拦截
				//alert('未登录');
				popStatus(2, '请先登录！', 3);
			} else {
				//正确返回结果
				if(data.result == true){
					popStatus(1, '回复成功', 3);
					searchList();
				}
			}
		}
	});
}

function reportComment(commentId){
	popStatus(1, '举报评论成功，评论编号为'+commentId, 3);
}