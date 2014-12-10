function timeDown(id, date) {
	var ts = (new Date(date)) - (new Date());// ����ʣ��ĺ�����
	if (ts < 0){
		ts = 0;
	}
	var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);// ����ʣ�������
	var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10);// ����ʣ���Сʱ��
	var mm = parseInt(ts / 1000 / 60 % 60, 10);// ����ʣ��ķ�����
	var ss = parseInt(ts / 1000 % 60, 10);// ����ʣ�������
	dd = checkTime(dd);
	hh = checkTime(hh);
	mm = checkTime(mm);
	ss = checkTime(ss);
	document.getElementById(id).innerHTML = dd + "<em>天</em>" + hh
			+ "<em>时</em>" + mm + "<em>分</em>" + ss + "<em>秒</em>";
}
function checkTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}
function countdown(id, date) {
	timeDown(id, date);
	window.setInterval(function() {
		timeDown(id, date);
	}, 1000);

}
function timeDown_hour(id, date) {
	var ts = (new Date(date)) - (new Date());// ����ʣ��ĺ�����
	if (ts < 0){
		ts = 0;
	}
	var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);// ����ʣ�������
	var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10) + dd * 24;// ����ʣ���Сʱ��
	var mm = parseInt(ts / 1000 / 60 % 60, 10);// ����ʣ��ķ�����
	var ss = parseInt(ts / 1000 % 60, 10);// ����ʣ�������
	dd = checkTime(dd);
	hh = checkTime(hh);
	mm = checkTime(mm);
	ss = checkTime(ss);
	document.getElementById(id).innerHTML = hh + ":" + mm + ":" + ss + "";
}

function countdown_hour(id, date) {
	timeDown_hour(id, date);
	window.setInterval(function() {
		timeDown_hour(id, date);
	}, 1000);

}