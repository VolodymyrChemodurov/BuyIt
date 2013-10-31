$(window).load(function() {
	var maxWidth = 200;
	var maxHeight = 160;
	var ratio = 0;
	
	$('.my-image').each(function() {
		
		var width = $(this).width();
		var height = $(this).height();
		var flag = false;
		
		console.log(this);
		console.log(width);
		console.log(height);
		
		if (width > maxWidth) {
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
		console.log(this);
		console.log(width);
		console.log(height);
		
		if (!flag) {
			$(this).css('margin-top', 160 - Math.floor(height));
		}
		$(this).parent().parent().css('visibility', 'visible');
		flag = false;
	});
});