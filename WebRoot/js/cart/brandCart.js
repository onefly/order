function checkAllBox(){
	if($('#checkAllbox').attr("checked")=="checked"){
			var amount =0;
			var ingot = 0;
		  $("input[name=isCost]").each(function(){
		      $(this).attr("checked","checked");
		      var code = $(this).val().split("-")[0];
		      amount += parseFloat($("#hid_price_"+code).val());
		      ingot += parseFloat($("#hid_ingot_"+code).val());
		    });
		  $(".show_amount").text(amount.toFixed(2));
		  $(".show_ingot").text(ingot);
	}else{
		$("input[name=isCost]").each(function(){
		      $(this).attr("checked",false);
		 });
		$(".show_amount").text("0.00");
		$(".show_ingot").text("0");
	}
}
function checkIsCost(){
		var flag=0;
		var amount =0;
		var ingot = 0;
		$("input[name=isCost]").each(function(){
		      if($(this).attr("checked")=="checked"){
		      	var code = $(this).val().split("-")[0];
		      	amount += parseFloat($("#hid_price_"+code).val());
		      	ingot += parseFloat($("#hid_ingot_"+code).val());
		      	flag++;
		      }
		    });
		  $(".show_amount").text(amount.toFixed(2));
		  $(".show_ingot").text(ingot);
		  if(flag == $("#hid_commodity_num").val()){
			  $('#checkAllbox').attr("checked","checked");
		  }else{
			  $('#checkAllbox').attr("checked",false);
		  }
		
	
}
function deleteCommodity(code,ingot,naked){
	if(window.confirm("确定从体验车中删除该商品？")){
		$.ajax({
		      url : basePath+"/cart/deleteCommotity.json",
		      type : "post", //请求类型
		      async : false,//默认true异步请求 ，false同步请求 
		      data : {productCode:code,ingot:ingot,brandId:$("#hid_brand").val(),naked:naked}, //待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
		      success : function(data) { 
		           if (500 == data) {
		              //系统内部异常
		              popStatus(4, '系统异常！', 3);
		           } else if (501 == data) {
		              //用户未登录，请求被拦截
		        	   popStatus(2, '未登录！', 3);
		           } else {
		              //正确返回结果
		              if(data.result == true){
		            	  $("#hid_commodity_num").val($("#hid_commodity_num").val()-1);
		            	  $("#li_"+code).empty();
		            	  $("#li_"+code).hide();
		            	  checkIsCost();
		            	  popStatus(1, '删除成功！', 3);
		              }else{
		            	  popStatus(4, '删除失败！', 3);
		              }
		          }
		     }
		});  
	}
	
}

function goToSubmitOrder(){
	$.ajax({
	      url : basePath+"/cart/checkSubmitOrderState.json",
	      type : "post", //请求类型
	      async : false,//默认true异步请求 ，false同步请求 
	      data : $("#toOrderForm").serialize(), //待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
	      success : function(data) { 
	           if (500 == data) {
	              //系统内部异常
	              popStatus(4, '系统异常！', 3);
	           } else if (501 == data) {
	              //用户未登录，请求被拦截
	        	   popStatus(2, '请先登录！', 3);
	           } else {
	              //正确返回结果
	              if(data.result == 1){            	 
	            	  //popStatus(1, '验证通过！', 3);
	            	  $("#toOrderForm").submit();
	              }else{
	            	  popStatus(4, '验证失败！', 3);
	              }
	          }
	     }
	});
}
//去买体验宝
function toBuyIngot(){
	popStatus(1, '客官稍等，马上到购买体验宝页面', 3, 'http://www.maxtp.com', true);
}
