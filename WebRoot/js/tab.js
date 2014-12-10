$(document).ready(function() 
{
	$('.baby_tab_cont').hide();
	$('.tab1').show();
	$('div.baby_tab_wrap ul li.tab1').addClass('on');
	$('div.baby_tab_wrap ul li').click(function()
	{
		var thisClass = this.className.slice(0,4);
		$('.baby_tab_cont').hide();
		$('div.' + thisClass).show(); 
		$('div.baby_tab_wrap ul li').removeClass('on');
		$(this).addClass('on');
	});
});