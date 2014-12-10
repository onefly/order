// JavaScript Document
//弹出框

function id(id){
  return document.getElementById(id);	
}
function oTk(a,b,c,e){
	  uPbox(a,b,c,e);
}
//弹出框函数upbox(box,clickobj,mask,Close)
function uPbox(obj, mask, Close,val) {
	obj.style.display = 'block';
	Ele_pos();
	mask.style.display = 'block';
	mAsk(mask);
	//判断添加的文字
	 if(val&&obj==id("sc")){
	  var nam = val.split('|');
		var	_left =Math.abs($('#sc h3').width()-nam[0].length*18-$('#sc h3 em').width()-50)/2+"px";
		   $('#sc h3').html("<em style='top:0px;left:"+_left+"'></em>"+nam[0]);
		   $('#sc a').html("<em></em>"+nam[1]);
	      
		  $('#sc a').attr("href",nam[2]);
	}
	Close.onclick = function() {
		mask.style.display = 'none';
		obj.style.display = 'none';
	}
	
	window.onscroll = function() {
		if (obj.style.display == 'block') Ele_pos();
		document.title=obj.style.top
	}
	window.onresize = function() {
		if (mask.style.display == 'block') mAsk(mask);
   		if (obj.style.display == 'block') Ele_pos();
 	}
	function Ele_pos(){//获取obj1的位置并赋值
		var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
		var scrollLeft = document.documentElement.scrollLeft || document.body.scrollLeft;
	
		obj.style.top = ($(window).height() - obj.offsetHeight) / 2 + scrollTop+ 'px';
		obj.style.left = (document.documentElement.clientWidth - obj.offsetWidth) / 2 + scrollLeft+ 'px';
	}
	

}

function mAsk(mask){//获取oMask的最大高度 与 最大宽度并赋值
	    var w = Math.max(document.body.offsetWidth, document.documentElement.clientWidth);
		var h = Math.max($(document).height(), $(document.body).height());
		mask.style.width = w + 'px';
		mask.style.height = h + 'px';
}

function oPbox(obj, mask, Close,li){
	    obj.style.display = 'block';
		var w = Math.max(document.body.offsetWidth, document.documentElement.clientWidth);
		var h = Math.max($(document).height(), $(document.body).height());
		mask.style.width = w + 'px';
		mask.style.height = h + 'px';
		mask.style.display = 'block';
		Ele_pos()
		Close.onclick = function() {
			mask.style.display = 'none';
			obj.style.display = 'none';
	}
	function Ele_pos(){//获取obj1的位置并赋值
		obj.style.top = getPos(li).top+li.offsetHeight+"px";
		obj.style.left = getPos(li).left-obj.offsetWidth+li.offsetWidth+"px";
	}

}

//getPos 获取绝对位置
function getPos(obj) {
		var pos = {left: 0, top: 0};
		
		while(obj) {
			pos.left += obj.offsetLeft;
			pos.top += obj.offsetTop;
			obj = obj.offsetParent;
		}
		return pos;
}

