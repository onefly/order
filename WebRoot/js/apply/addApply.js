function addApply() {
		if($("#slogan_id").val().length==0){
			popStatus(2, '申请口号不能为空！', 3);
			return;
		}
		if($("#reason_id").val().length==0){
			popStatus(2, '申请理由不能为空！', 3);
			return;
		}
		if($("#reason_id").val().length>140){
			popStatus(2, '申请理由超出140字数限制！', 3);
			return;
		}
		$.ajax({
			url : basePath+"/apply/addApplyForm.json",
			type : "post", //请求类型
			async : false,//默认true异步请求 ，false同步请求 
			data : $("#addApplyForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
			success : function(data) {
				if (500 == data) {
					//系统内部异常
					popStatus(4, '系统出错！', 3);
				} else if (501 == data) {
					//用户未登录，请求被拦截
					popStatus(2, '请先登录！', 3);
				} else {
					//正确返回结果
					if(data.result == 1){
						 //popStatus(1, '保存成功！', 3);
						 var url = basePath+"/apply/forSupport/"+data.applyId+".htm";
						 popStatus(1, '申请单提交成功，3秒后自动跳转到拉赞详情页！', 3, url, true);
					}else if(data.result == 3){
						popStatus(2, '已经提交过申请单！', 3);
					}else if(data.result == 4){
						popStatus(2, '积分不够！', 3);
					}else{
						 popStatus(4, '保存失败！', 3);
					}
				}
			}
		});
	}
	//顶部用户信息div加载
	function loadUserTop() {
		$.ajax({
			url : basePath+"/common/getUserTop.htm",
			type : "post", //请求类型
			async : true,//默认true异步请求 ，false同步请求 
			data : $("#addApplyForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
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
	function loadProductInfo() {
		$.ajax({
					url : basePath+"/common/getProductInfo.htm",
					type : "post", //请求类型
					async : true,//默认true异步请求 ，false同步请求 
					data : $("#addApplyForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
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
							$("#showMoney").text($("#ensureCash").val());
						}
					}
				});
	}
	function loadDiv(){
		loadUserTop();
		loadProductInfo();
	}