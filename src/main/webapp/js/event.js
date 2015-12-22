$('div[data-role="ui-most-info"]').find('a').click(function(){
	if(!$(this).parent().hasClass('active')){
		$(this).parent().addClass('active').siblings().removeClass('active');
		
		var withBonusNumber = $('ul[data-role="ui-with-bonus-number"]').find('li.active>a').data('withBonusNumber');
		var mostWinningSort = $('ul[data-role="ui-most-winning-sort"]').find('li.active>a').data('mostWinningSort');
		var $target = $('div[data-role="ui-most-info"]');
		var api = 'most/' + withBonusNumber + '/' + mostWinningSort; 
		fn_getDrawInfo(api, $target);
	}
});