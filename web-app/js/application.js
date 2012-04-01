if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

/**
 * Creates timer.
 */
function setTimer(time, func, callback) {
    var a = {timer:setTimeout(func, time), callback:null};
    if (callback) {
        a.callback = callback;
    }
    return a;
}

/**
 * Clears timer.
 */
function clearTimer(a) {
    clearTimeout(a.timer);
    if (a.callback) {
        a.callback();
    }
    return this;
}