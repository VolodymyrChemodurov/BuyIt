$(window).load(function() {
	$('.my-image-mini').each(function() {
		//var maxWidth = $('#gallery').width()*0.3;
		var maxHeight = 70;
		var ratio = 0;
		//console.log('hello');
		console.log($('#gallery').width());
		var width = $(this).width();
		var height = $(this).height();
		if (width > height) {
			ratio = height / width;
			$(this).css("width", '28%');
			$(this).css("height", (100 * ratio)+'%');
		}

		else{
			ratio = width / height;
			$(this).css("width", (28*ratio) +'%');
			$(this).css("height", '100%');
		}
		//$(this).css('margin-top', parseInt((70 - height) / 2));
		$(this).css('visibility', 'visible');
	});
});