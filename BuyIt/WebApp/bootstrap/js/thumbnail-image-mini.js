$(window).load(function() {
	$('.my-image-mini').each(function() {
		var maxWidth = 81;
		var maxHeight = 65;
		var ratio = 0;
		var width = $(this).width();
		var height = $(this).height();
		if (width > height) {
			ratio = maxWidth / width;
			$(this).css("width", maxWidth);
			$(this).css("height", height * ratio);
			height = height * ratio;
			width = width * ratio;
			flag = true;
		}

		if (height > maxHeight) {
			ratio = maxHeight / height;
			$(this).css("height", maxHeight);
			$(this).css("width", width * ratio);
			width = width * ratio;
			height = height * ratio;
			flag = true;
		}
		$(this).css('margin-top', parseInt((65 - height) / 2));
	});
});