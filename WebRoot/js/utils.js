function BG() {
	//向上获取父类元素
	this.getParentElem = function (childNade, parentNode) {
		var _this = childNade.closest(parentNode);
		return _this;
	}
	//获取class结果集
	this.getResult = function (data) {
		if (!(isArray(data))) {
			var message = "参数格式错误！请传入数组";
			var errorMessage = new Error(message);
			return errorMessage.message;
		}
		var size = data.length;
		var objectSet = {};
		for (var i = 0; i < size; i++) {
			if ($("." + data[i]).size() != 0) {
				objectSet[data[i]] = $("." + data[i]);
			}
		}
		return objectSet;
	}

	//事件绑定
	this.bindEvents = function (className, e, callFN, eType) {
		var _this = typeof(className) != "object" ? $(className) : className;
		var _type = eType != undefined ? true : false;
		if (typeof(e) != "string") {
			return;
		}
		if (_type) {
			_this.unbind().bind(e, callFN);
		} else {
			_this.die().live(e, callFN);
		}
	}	
	//tab选项卡
	/*tabLi--操作li
	tabBox--操作内容的class/id
	current--选中的样式	
	 */
	this.Tab = function (tabLi, tabBox, current, mouse) {
		//触发行为判断
		if(mouse=='hover'){
			mouse = 'mouseover';	
		}else{
			mouse = 'click';
		};		
		//方法判断
		if(typeof($(tabLi).eq(0).attr("tabNav"))=="undefined"){//按下标
			TabInit();
			$this.bindEvents(tabLi, mouse, tabFun);			
		}else{//按属性
			TabAttrInit();
			$this.bindEvents(tabLi, mouse, tabAttr);
		};
		
		//下标方法
		function tabFun() {
			$(this).addClass(current).siblings().removeClass(current);
			var index = $(tabLi).index($(this));
			$(tabBox).eq(index).show().siblings().hide();
		}
		//下标方法初始状态
		function TabInit(){
			$(tabLi).eq(0).addClass(current);
			$(tabBox).eq(0).show();
		}
		//tabNav属性方法
		function tabAttr() {
			var tab = $(this).attr("tabNav");
			$(this).addClass(current).siblings().removeClass(current);			
			$(tabBox+"[tabBox="+tab+"]").show().siblings().hide();
		}
		//tabNav属性方法初始状态
		function TabAttrInit(){
			$(tabLi).eq(0).addClass(current);
			var tab = $(tabLi).eq(0).attr("tabNav");			
			$(tabBox+"[tabBox="+tab+"]").show();
		}
	}
}

//实例化对象
var $this = new BG();
/**
 * 弹出
 * @param 选项 options  {message, onok, width, cId, mClass, view, oncancel, ondone, oKName, cancelName,obj,init}
 */
function pop_confirm(options) {
	var message;
	var onok;
	var oncancel;
	var ondone;
	var init;
	var time;
	var title = '提示';
	var _cId = 'popConfirm';
	var _mClass = 'mask';
	var _width = 'auto';
	var view = 'block';
	var _this = '';
	var button = 'allButton';
	var okName = "确定";
	var cancelName = "取消";
	var _align = 'center';
	if (typeof(options) == "string") {
		message = options;
	} else if (typeof(options) == "object") {
		if (typeof(options["time"]) == "string") {
			time = options["time"];
		}
		if (typeof(options["message"]) == "string") {
			message = options["message"];
		}
		if (typeof(options["onok"]) == "function") {
			onok = options["onok"];
		}
		if (typeof(options["width"]) == "string") {
			_width = options["width"];
		}
		if (typeof(options["oncancel"]) == "function") {
			oncancel = options["oncancel"];
		}
		if (typeof(options["ondone"]) == "function") {
			ondone = options["ondone"];
		}
		if (typeof(options["init"]) == "function") {
			init = options["init"];
		}
		if (typeof(options["okName"]) == "string") {
			okName = options["okName"];
		}
		if (typeof(options["title"]) == "string") {
			title = options["title"];
		}
		if (typeof(options["cancelName"]) == "string") {
			cancelName = options["cancelName"];
		}
		if (typeof(options["button"]) == "string") {
			button = options["button"];
		}
		if (typeof(options["view"]) == "string") {
			view = options["view"];
		}
		if (typeof(options["align"]) == "string") {
			_align = options["align"];
		}
		if (typeof(options["cId"]) == "string") {
			_cId = options["cId"];
		}
		if (typeof(options["mClass"]) == "string") {
			_mClass = options["mClass"];
		}
		if (typeof(options["obj"]) == "object") {
			_this = options["obj"];
		}
	} else {
		throw new Error("Wrong arguments");
	}

	if (message.search(/bg_/g) != -1) {
		var _message = message.replace(/bg_/g, '');
	} else {
		_message = message;
	}

	$("." + _mClass).remove();
	$("#" + _cId).remove();
	var html = '<div class="pop" style="width:' + _width + ';z-index:99999" id="' + _cId + '">';
	html += '<h1>' + title + '<a href="javascript:void(0)" class="popClose g" style="display:' + view + '"></a></h1>';
	html += '<div class="popBox"><div class="popCon fix">' + _message + '</div>';
	switch (button) {
	case 'none':
		html += '';
		break;
	case 'ok':
		html += '<div class="popButton" style="text-align:'+ _align +'"><input type="button" value="'+ okName +'" class="popInput popOk"></div>';
		break;
	case 'cancel':
		//html += '<div class="popButton" style="text-align:'+ _align +'"><input type="button" value="'+ cancelName +'" class="popInput popCancel"></div>';
		html += '<div class="popButton" style="text-align:'+ _align +'"><a class="popCancel" href="javascript:void(0)">' + cancelName + '</a></div>';
		break;
	case 'allButton':
		//html += '<div class="popButton" style="text-align:'+ _align +'"><input type="button" value="' + okName + '" class="popInput popOk mR20"> <input type="button" value="' +cancelName + '" class="popInput popCancel"></div>';
		html += '<div class="popButton" style="text-align:'+ _align +'"><input type="button" value="' + okName + '" class="popInput popOk mR20"> <a class="popCancel" href="javascript:void(0)">' + cancelName + '</a></div>';
		break;
	}
	html += '</div></div><div id="dis" class="popMask ' + _mClass + '"></div>';
	//$("#body", window.top.document).append(html)
    $(document.body).append(html);
	var box = $("#"+_cId);
	box.css("position", "fixed");
	/*box.css("position", "absolute");*/
	box.css("top", parseInt(($(window).height() - box.height()) / 2) + "px");
	box.css("left", parseInt(($(window).width() - box.width()) / 2) + "px");
	var state = $('.pop');
	if (state.is(':visible') && init) {
		init(state, _this);
	}
	if (ondone) {
		ondone.call(box);
	}
	//自动关闭	
	if(time!=undefined){		
		setTimeout(
			function(){				
				$("#dis").remove();
				box.remove();
			},time);
	}
	//按钮事件
	box.find(".popClose").click(function () {
		if (oncancel) {
			oncancel.call($(this));
		}
		$("#dis").remove();
		box.remove();
	});
	box.find(".popOk").click(function () {
		var state;
		if (onok) {
			//state = onok.call($(this));
			state = onok(_this);
		}
		
		state = state == undefined ? true : state;

		if (state) {
			$("#dis").remove();
			//$("." + _mClass, window.top.document).remove();
			box.remove();
		}

		return false;
	});
	box.find(".popCancel").click(function () {
		if (oncancel) {
			oncancel.call($(this));
		}
		$("#dis").remove();
		//$("." + _mClass, window.top.document).remove();
		box.remove();
		return false;
	});
}




//输入框提示文字
function inputTip() {
	var _html,
	idLabel,
	inputTips,
	_this,
	_parent,
	_thisVal,
	input = $("input:text, textarea, input:password");
	input.each(function () {

		_this = $(this);
		_thisVal = _this.val();
		idLabel = _this.attr("id");
		inputTips = _this.attr("tipMsg");
		if (!inputTips) {
			return;
		};
		if (!idLabel) {
			idLabel = "id_" + new Date().getTime();
			_this.attr("id", idLabel);
		};
		var _height = _this.outerHeight();
		_html = "<label class='inputMsg' for=" + idLabel + " > " + inputTips + "</label>";
		_this.parent().addClass("rel");
		if (_this.prev().is(".inputMsg")) {
			return;
		} else {
			_this.before(_html);
		};
		if (_thisVal != "") {
			$(this).prev("label").hide();
		};

		input.focusin(function () {
			$(this).prev("label").hide();
		});
		input.blur(function () {
			if ($(this).val() == "") {
				$(this).prev("label").show();
			}
		});
	});
}
			
			//IE下placeholder兼容
			
		function input(theInput, val) {
			var $input = $("#"+theInput+"");
			var val = val;
			$input.attr({value:val});
			$input.focus(function() {
				if ($input.val() == val) {
					$(this).attr({value:""});
				}
			}).blur(function() {
				if ($input.val() == "") {
					$(this).attr({value:val});
				}
			});
			$('.pCSearchButton').click(function(){
				if( $input.val() != "search..."){ 
					alert('找到了')
				}else{
					$input.val('');
					alert('请输入要查找的商品');
				}
			})
	}

//textarea字数限制
function areaNum(obj,n,t,i){	
	var len=$(obj).val().length;	
	var num=n-len;	
	if( n < len ){
		$("."+t).html('已超出<b style="color:#f00">'+Math.abs(num)+'</b>字')
		$("."+i)[0].disabled = true;
	}else{
		$("."+t).html('还可输入<b class="num">'+num+'</b>字');
		$("."+i)[0].disabled = false;
	};
};
function areaNums(obj,n,t,i){	
	var len=$(obj).val().length;	
	var num=n-len;	
	if( n < len ){
		$("."+t).html('已超出<b style="color:#f00">'+Math.abs(num)+'</b>字');
		$("."+i)[0].disabled = true;
	}else{
		$("."+t).html('还可输入<b class="num">'+num+'</b>字');
		$("."+i)[0].disabled = false;
	};
};
// flash轮播
function flash(id,t){
	var oBox = document.getElementById(id);
	if(!oBox){
		return;
	}
	var oList = oBox.getElementsByTagName("ul")[0];	
	var aImg = oBox.getElementsByTagName("img");
	var timer = null;
	var playTimer = null;
	var index = i = 0;
	var bOrder = true;
	var aTmp = [];
	var aBtn = null;
	//生成数字按钮
	for (i = 1; i < aImg.length+1; i++) aTmp.push("<li>"+ i +"</li>");	
	//插入元素
	var parentDiv = document.createElement('div');
	var oCount = document.createElement("ul");
	parentDiv.className = "count";
	
	
	oCount.className = "fR"
	oCount.innerHTML = aTmp.join("");
	
	oBox.appendChild(parentDiv);
	parentDiv.appendChild(oCount);
	aBtn = oBox.getElementsByTagName("ul")[1].getElementsByTagName("li");
	//判断只有一张图片隐藏插入元素
	if(aImg.length==1){
		oBox.getElementsByTagName("ul")[1].style.display="none";
	}
	//初始化状态
	cutover();
	//按钮点击切换
	for (i = 0; i < aBtn.length; i++)
	{
		aBtn[i].index = i;
		aBtn[i].onmouseover = function ()
		{
			index = this.index;
			cutover()
		}
	}
	function cutover()
	{
		if(aBtn[index]){
			for (i = 0; i < aBtn.length; i++) aBtn[i].className = "";
			aBtn[index].className = "current";
			startMove(-(index * aImg[0].offsetHeight))
		}
		
	}
	function next()
	{		
		index++;
		if (aImg.length-1 < index) index=0;
		cutover();		
	}
	//是否自动播放
	if(t!="no"){
		playTimer = setInterval(next, t);
		//鼠标移入展示区停止自动播放
		oBox.onmouseover = function ()
		{
			clearInterval(playTimer);					
		};
		//鼠标离开展示区开始自动播放
		oBox.onmouseout = function ()
		{
			playTimer = setInterval(next, 5000);			
		};
	};	
	function startMove(iTarget)
	{
		clearInterval(timer);
		timer = setInterval(function ()
		{
			doMove(iTarget);
		}, 30);
	}
	function doMove (iTarget)
	{
		var iSpeed = (iTarget - oList.offsetTop) / 10;
		iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
		oList.offsetTop == iTarget ? clearInterval(timer) : oList.style.top = oList.offsetTop + iSpeed + "px";
	}
};

function LeftMenu(_id){
	$(".pCLeftMenuCon dt").click(function(){
			$(this).nextAll().toggle().end().find(".pCUp").toggleClass("pCDown");
	});
	// if(_id){
		// $("#"+_id).find("dt").click();
	// }
	$(".pCLeftMenuCon dd").has("ul").hover(function(){
		$(this).addClass("hover").find(".menuPop").show();
	},function(){
		$(this).removeClass("hover").find(".menuPop").hide();
	});
}

