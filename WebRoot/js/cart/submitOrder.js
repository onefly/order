//提交订单操作
function submitOrder(){
	//是否确认收货人信息
	if($("#isSaveReceiver").val() == 0){
		
		$.ajax({
		      url : basePath+"/order/addOrder.json",
		      type : "post", //请求类型
		      async : false,//默认true异步请求 ，false同步请求 
		      data : $("#submitOrderForm").serialize(), //待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
		      success : function(data) { 
		           if (500 == data) {
		              //系统内部异常
		              popStatus(4, '系统异常！', 3);
		           } else if (501 == data) {
		              //用户未登录，请求被拦截
		        	   popStatus(2, '请先登录！', 3);
		           } else {
		              //正确返回结果
		              if(data.result.result == true){   
		            	
		            	  //popStatus(1, '验证通过！', 3);
		            	  //订单提交成功后，跳转到订单提交成功页面
		            	  $("#topayId").val(data.orderId);
		            	  $("#topayingot").val(data.order.payIngotNum);
		            	  $("#topayamonut").val(data.order.orderFund);
		            	  $("#topayorderCancelTime").val(data.orderCancelTime);
		            	  $("#toPayOrderForm").submit();
		              }else{
		            	
		            	  popStatus(4, data.result.message, 5);
		              }
		          }
		     }
		});
	}else{
		popStatus(2, '请确认收货人信息！', 3);
	}
}

//更换收货人信息
function changeReceiver(){
	$("#operateFlag").val(0);
	$("#isSaveReceiver").val(1);
	$("#defaultReceiver").hide();
	$("#otherReceiver").show();
}
//展示新增收货地址div
function showNewAddress(){
	//操作标记 是否是新增或者编辑操作 ；1 是，0 否
	$("#operateFlag").val(1);
	$("#currentReceiver").val(0);
	$("#newAddressDiv").show();
}
//编辑收货信息
function editAddress(id){
	//操作标记 是否是新增或者编辑操作 ；1 是，0 否
	$("#operateFlag").val(1);
	$("#radio_"+id).attr("checked","checked");
	$("#newaddressId").val($("#addressId_"+id).val());
	$("#newrecieveName").val($("#recieveName_"+id).val());
	$("#newrecieveMobilephone").val($("#recieveMobilephone_"+id).val());
	$("#newrecieveTelephone").val($("#recieveTelephone_"+id).val());
	$("#newaddress").val($("#address_"+id).val());
	var province = $("#province_"+id).val();
	var city = $("#city_"+id).val();;
	var district = $("#district_"+id).val();;
	_init_area(province,city,district);
	$("#newAddressDiv").show();
	$("#currentReceiver").val(id);
}
//几点左边收货地址列表单选框隐藏新增收货地址区域
function hideNewAddress(id){
	//操作标记 是否是新增或者编辑操作 ；1 是，0 否
	$("#operateFlag").val(0);
	$("#currentReceiver").val(id);
	$("#newAddressDiv").hide();
}
//点击保存按钮触发的操作
function onEnterSaveButton(){
	$("#isSaveReceiver").val(0);
	var flag = $("#operateFlag").val();
	if(flag == 1){
		var checkFlag = checkReceiverForm();
		if(checkFlag){
			saveReceiver();
		}
	}else{
		showSelectedReceiver();
	}
	
}
//保存新增或编辑的收货信息
function saveReceiver(){
	setAreaName();
		var current = $("#currentReceiver").val();
		var url = basePath;	
		if(current == 0){
			url = url +"/addr/addReceiver.json";
		}else{
			url = url +"/addr/updateReceiver.json";
		}	
		$.ajax({
		      url : url,
		      type : "post", //请求类型
		      async : false,//默认true异步请求 ，false同步请求 
		      data : $("#ReceiverForm").serialize(), //待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
		      success : function(data) { 
		           if (500 == data) {
		              //系统内部异常
		              popStatus(4, '系统异常！', 3);
		           } else if (501 == data) {
		              //用户未登录，请求被拦截
		        	   popStatus(2, '未登录！', 3);
		           } else {
		        	   if(data.result.status == true){
		        		  searchReceiverList(data.receiverId);	 	              
		        	   }else{
		        		   popStatus(4, data.result.message, 3);
		        	   }
		              
		          }
		     }
		});
		
	
}
//局部刷新查询收货地址列表 ，id为当前选择的收货地址ID
function searchReceiverList(id){
	var url = basePath+"/addr/getReceiverList.htm";
	$.ajax({
	      url : url,
	      type : "post", //请求类型
	      async : false,//默认true异步请求 ，false同步请求 
	      data : {receiverId:id}, //待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
	      success : function(data) { 
	           if (500 == data) {
	              //系统内部异常
	              popStatus(4, '系统异常！', 3);
	           } else if (501 == data) {
	              //用户未登录，请求被拦截
	        	   popStatus(2, '系统异常！', 3);
	           } else {
	              $("#receiverListDiv").html(data);
	              showSelectedReceiver();
	          }
	     }
	});
	
}
//	将选择好的结果展示到页面上
function showSelectedReceiver(){
	 var id = $("#currentReceiver").val();
     setValueToSpan(id);
     $("#defaultReceiver").show();
 	 $("#otherReceiver").hide();
}
//将值展示到span中
function setValueToSpan(id){	
	setValueToHiddenForm(id);
	$("#receiveNameSpan").text($("#recieveName_"+id).val());
	$("#mobileSpan").text($("#recieveMobilephone_"+id).val());
	$("#telephoneSpan").text($("#recieveTelephone_"+id).val());
	var detail = $("#provinceName_"+id).val()+$("#cityName_"+id).val()+$("#districtName_"+id).val()+$("#address_"+id).val();
	$("#detailAddrSpan").text(detail);
}
//将值赋值到隐藏表单内
function setValueToHiddenForm(id){	
	$("#recieveName").val($("#recieveName_"+id).val());
	$("#recievePhone").val($("#recieveMobilephone_"+id).val());
	$("#recieveTelephone").val($("#recieveTelephone_"+id).val());
	var detail = $("#provinceName_"+id).val()+$("#cityName_"+id).val()+$("#districtName_"+id).val()+$("#address_"+id).val();
	$("#detailAddress").val(detail);
	$("#province").val($("#province_"+id).val());
	$("#provinceName").val($("#provinceName_"+id).val());
	$("#city").val($("#city_"+id).val());
	$("#cityName").val($("#cityName_"+id).val());
	$("#district").val($("#district_"+id).val());
	$("#districtName").val($("#districtName_"+id).val());
	$("#address").val($("#address_"+id).val());
}

/*给地区赋值*/
function setAreaName(){
	$("#provinceName").val($("#s_province option:selected").text());
	$("#cityName").val($("#s_city option:selected").text());
	$("#districtName").val($("#s_county option:selected").text());
}
//验证保存收货人的表单
function checkReceiverForm(){
	if($("#newrecieveName").val().length == 0 ){
		popStatus(2, '请输入收货人！', 3);
		return false;
	}
	if($("#s_province").val() == 0){
		popStatus(2, '请选择省市区！', 3);
		return false;
	}
	if($("#s_city").val() == 0){
		popStatus(2, '请选择省市区！', 3);
		return false;
	}
	if($("#s_county").val() == 0){
		popStatus(2, '请选择省市区！', 3);
		return false;
	}
	if($("#newaddress").val().length == 0 ){
		popStatus(2, '请输入详细地址！', 3);
		return false;
	}
	if($("#newaddress").val().length < 10 ){
		popStatus(2, '详细地址长度必须大于10个字符！', 3);
		return false;
	}
	
	var mobile = $("#newrecieveMobilephone").val();
	if(!validatemobile(mobile)){
		return false;
	}
	return true;
}
function validatemobile(mobile)
{
    if(mobile.length==0)
    {
    	popStatus(2, '请输入手机号码！', 3);
       return false;
    }    
    if(mobile.length!=11)
    {
    	popStatus(2, '请输入正确的手机号码！', 3);
        return false;
    }
    
    var myreg = /^(((13[0-9]{1})|159|153|14[0-9]|17[0-9]|18[0-9]|15[0-9])+\d{8})$/;
    if(!myreg.test(mobile))
    {
    	popStatus(2, '请输入正确的手机号码！', 3);
        return false;
    }
    return true;
}