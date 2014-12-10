// JavaScript Document
function funcInitSel(e){        
	var objUL = e.getElementsByTagName("ul")[0];
	document.onclick = function(){                
		if(e.getAttribute("state")=="0")
		objUL.style.display = "none";
	}
	
	var objTxt = e.getElementsByTagName("input")[0];
	var arrLi = objUL.getElementsByTagName("li");

	for(var i=0;i<arrLi.length;i++){
		arrLi[i].onmouseover = function(){
			this.className = "on";                
		}
		arrLi[i].onmouseout = function(){
			this.className = "";
		}
		
		arrLi[i].onclick = function(){
			objTxt.value = this.innerHTML;                
			e.setAttribute("state",0);
			objUL.style.display = "none";  
		}
	}
}

function funcSel(e){                 
	var objUL = e.getElementsByTagName("ul")[0];         
	if(objUL.style.display == "none" && e.getAttribute("state") == "1"){
		objUL.style.display = "";                 
	}if(e.offsetWidth > objUL.offsetWidth){
		objUL.style.width=e.offsetWidth-2 + "px";            
	}         
}

function funcSetOn(e,v){  
	if(e.getAttribute("state") == ""){
		funcInitSel(e);                                   
	}
	e.setAttribute("state",v);     
}
