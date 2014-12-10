//检查内容中是否包含网站屏蔽词
function checkShieldWord(content){
	var url = basePath+"/common/checkShieldWord.jsonp";
	var checkResult = false;
	$.ajax({
		url : url,
		type : "get", //请求类型
		async : false,//默认true异步请求 ，false同步请求 
		data : {content:content},
		dataType:"jsonp",
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
					popStatus(2, '内容中包含屏蔽词"'+data.shieldWord+'",请重新填写！', 4);
					checkResult =  true;
				}
			}
		}
	});
	return checkResult;
}