$(document).ready(function() {
	$('.my-image').each(function() {
		var maxWidth = 200;
		var maxHeight = 150;
		var ratio = 0;
		var width = $(this).width();
		var height = $(this).height();
		if (width > maxWidth) {
			ratio = maxWidth / width;
			$(this).css("width", maxWidth);
			$(this).css("height", height * ratio);
			height = height * ratio;
			width = width * ratio;
		}

		if (height > maxHeight) {
			ratio = maxHeight / height;
			$(this).css("height", maxHeight);
			$(this).css("width", width * ratio);
			width = width * ratio;
			height = height * ratio;
		}
		$(this).css('margin-top', 260 - height - 100);
	});
});