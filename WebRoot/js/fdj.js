// JavaScript Document
$(function(){
	//标签切换
	$this.Tab(".itemNav li",".itemBox > .tabcon","un");
	$this.Tab(".itemPicS li",".itemPicM > .tabcon","un");
	//tips
	$('.tip').miniTip({'className':'yellow'});
	//多属性选择
	$(".itemAttr").each(function(){
		var attr = this;		
		$('dd a', attr).click(function(){	
			if($(this).hasClass('none')){
				return;	
			}else if($(this).hasClass('un')){
				$(this).removeClass("un");	
			}else{				
				$('dd a', attr).removeClass("un");
				$(this).addClass("un");
			}	
		});
	});	
	//采购量
	$(".itemNumIpnut").blur(function(){
		var val = $(".itemNumIpnut").val();	
		var checkNum = /^[0-9]*[1-9][0-9]*$/;
		if(checkNum.test(val)==false){
			alert("请输入正整数！");
			$(".itemNumIpnut").val("1");
		};	
	});
	$(".itemNumUp").click(function(){
		var val = parseInt($(".itemNumIpnut").val());
		var maxVal = $("#maxNum").html();
		if(val<maxVal){
			val =val + 1;
			$(".itemNumIpnut").val(val);
		}else{
			alert("超出可售数量！");
		};		
	});
	$(".itemNumDown").click(function(){
		var val = parseInt($(".itemNumIpnut").val());		
		if(val>1){
			val =val - 1;
			$(".itemNumIpnut").val(val);
		}else{
			alert("最少采购一桶！");
		};		
	});
});