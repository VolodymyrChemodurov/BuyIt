$(window).load(function() {
        $('.my-image').each(function() {
                var maxWidth = 200;
                var maxHeight = 160;
                var ratio = 0;
                var width = $(this).width();
                var height = $(this).height();
                var flag = false;
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
                if(!flag)
                        $(this).css('margin-top', 260 - height - 100);
                $(this).parent().parent().css('visibility','visible');
        });
});