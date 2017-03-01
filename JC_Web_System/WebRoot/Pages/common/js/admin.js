
/*��ҳ�󵼺�������js*/
$(function() {
	var icons = {
		header : "ui-icon-circle-arrow-e",
		activeHeader : "ui-icon-circle-arrow-s"
	};
	$("#accordion").accordion({
		icons : icons,
		heightStyle : "content",
		event : "click hoverintent",
		fillSpace:true
		
	});
	$( "#menu" ).menu();
	
});

/*��ͣչ������
 * hoverIntent | Copyright 2011 Brian Cherne
 * http://cherne.net/brian/resources/jquery.hoverIntent.html
 * modified by the jQuery UI team
 */
$.event.special.hoverintent = {
	setup : function() {
		$(this).bind("mouseover", jQuery.event.special.hoverintent.handler);
	},
	teardown : function() {
		$(this).unbind("mouseover", jQuery.event.special.hoverintent.handler);
	},
	handler : function(event) {
		var currentX, currentY, timeout, args = arguments, target = $(event.target), previousX = event.pageX, previousY = event.pageY;

		function track(event) {
			currentX = event.pageX;
			currentY = event.pageY;
		}
		;

		function clear() {
			target.unbind("mousemove", track).unbind("mouseout", clear);
			clearTimeout(timeout);
		}

		function handler() {
			var prop, orig = event;

			if ((Math.abs(previousX - currentX) + Math
					.abs(previousY - currentY)) < 7) {
				clear();

				event = $.Event("hoverintent");
				for (prop in orig) {
					if (!(prop in event)) {
						event[prop] = orig[prop];
					}
				}
				// ��ֹ����ԭʼ�¼�����Ϊ���¼��ᱻ�첽���������¼����ٿ��� (#6028)
				delete event.originalEvent;

				target.trigger(event);
			} else {
				previousX = currentX;
				previousY = currentY;
				timeout = setTimeout(handler, 100);
			}
		}

		timeout = setTimeout(handler, 100);
		target.bind({
			mousemove : track,
			mouseout : clear
		});
	}
};
/*��ҳ�󵼺�������js*/


