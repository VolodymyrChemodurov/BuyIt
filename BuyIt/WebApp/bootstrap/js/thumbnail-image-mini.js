$(window).load(function() {
		console.log("mini");
        $('.my-image-mini').each(function() {
                var maxWidth = 81;
                var maxHeight = 65;
                var ratio = 0;
                var width = $(this).width();
                var height = $(this).height();
                var flag = false;
                console.log("0");
                if (width > height) {
                        ratio = maxWidth / width;
                        $(this).css("width", maxWidth);
                        $(this).css("height", height * ratio);
                        height = height * ratio;
                        width = width * ratio;
                        flag = true;
                        console.log("1");
                }

                if (height > maxHeight) {
                        ratio = maxHeight / height;
                        $(this).css("height", maxHeight);
                        $(this).css("width", width * ratio);
                        width = width * ratio;
                        height = height * ratio;
                        flag = true;
                }
                		console.log("hello");
                        $(this).css('margin-top', parseInt((65 - height)/2) );
        });
});