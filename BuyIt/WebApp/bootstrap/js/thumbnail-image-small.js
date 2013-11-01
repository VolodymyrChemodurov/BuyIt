$(window).load(function() {
	var maxWidth = 200;
	var maxHeight = 160;
	var ratio = 0;
	
	$('.my-image').each(function() {
		
		var width = $(this).width();
		var height = $(this).height();
		
		if (width > maxWidth) {
			ratio = maxWidth / width;
			height = height * ratio;
			width = maxWidth;
			
			$(this).css("width", width);
			$(this).css("height", height);
			
		}

		if (height > maxHeight) {
			ratio = maxHeight / height;
			height = maxHeight;
			width = width * ratio;
			
			$(this).css("height", height);
			$(this).css("width", width);
		}

		$(this).css('margin-top', maxHeight - height);
		$(this).parent().parent().css('visibility', 'visible');
		flag = false;
	});
});