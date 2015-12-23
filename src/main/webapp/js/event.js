var $UiMostInfo = $('div[data-role="ui-most-info"]');
var $UiAppearanceInfo = $('div[data-role="ui-appearance-info"]');

$UiMostInfo.find('a').click(function(){
	if(!$(this).parent().hasClass('active')){
		$(this).parent().addClass('active').siblings().removeClass('active');
		
		var withBonusNumber = $UiMostInfo.find('ul[data-role="ui-with-bonus-number"]').find('li.active>a').data('withBonusNumber');
		var mostWinningSort = $UiMostInfo.find('ul[data-role="ui-most-winning-sort"]').find('li.active>a').data('mostWinningSort');
		var $target = $('div[data-role="ui-most-info"]');
		var api = 'most/' + withBonusNumber + '/' + mostWinningSort; 
		fn_getDrawInfo(api, $target);
	}
});

$UiAppearanceInfo.find('a').click(function(){
	if(!$(this).parent().hasClass('active')){
		$(this).parent().addClass('active').siblings().removeClass('active');
		
		var withBonusNumber = $UiAppearanceInfo.find('ul[data-role="ui-with-bonus-number"]').find('li.active>a').data('withBonusNumber');
		var $target = $('div[data-role="ui-appearance-info"]');
		var api = 'appearance/' + withBonusNumber; 
		fn_getDrawInfo(api, $target);
	}
});