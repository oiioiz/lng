var fn_getDrawInfo = function(api, $target, callback) {
	var url = "http://localhost:8080/api/" + api;

	$.getJSON(url, function(data) {
		fn_drawBalls(data, $target);
		if (callback) {
			callback(data);
		}
	});
}

var fn_colorClassSelector = function(ballNo) {
	var colorClass = '';

	if (ballNo < 11) {
		colorClass = 'label-warning';
	} else if (ballNo >= 11 && ballNo < 21) {
		colorClass = 'label-primary';
	} else if (ballNo >= 21 && ballNo < 31) {
		colorClass = 'label-danger';
	} else if (ballNo >= 31 && ballNo < 41) {
		colorClass = 'label-default';
	} else {
		colorClass = 'label-success';
	}

	return colorClass;
}

var fn_drawBalls = function(drawInfo, $target) {
	var html = "";
	var balls = [ "drwtNo1", "drwtNo2", "drwtNo3", "drwtNo4", "drwtNo5",
			"drwtNo6", "bnusNo" ];

	if (drawInfo.hasOwnProperty('drwNo')) {
		$.each(balls, function(idx, val) {
			html += '<span class="label '
					+ fn_colorClassSelector(eval("drawInfo." + val))
					+ ' draw-ball">';
			html += eval("drawInfo." + val);
			html += '</span>&nbsp;';

			if (idx === 5) {
				html += '&nbsp;+&nbsp;';
			}
		});
	} else {
		$.each(drawInfo, function(idx, val) {
			html += '<span class="label ' + fn_colorClassSelector(val)
					+ ' draw-ball">';
			html += val;
			html += '</span>&nbsp;';
		});
	}

	$target.find('*[data-role="ui-ball-list"]').empty().append(html);
}

var fn_getLastDrawInfo = function() {
	var $target = $('*[data-role="ui-last-info"]');
	var callback = function(data) {
		$target.find('*[data-role="ui-round"]').append(data.drwNo);
		$target.find('*[data-role="ui-date"]').append(data.drwNoDate);
	}
	fn_getDrawInfo(0, $target, callback);
}

$(document).ready(function() {
	fn_getLastDrawInfo();
	$('ul[data-role="ui-most-winning-sort"]').find('a:first').click();
	$('ul[data-role="ui-with-bonus-number"]').find('a:first').click();
});