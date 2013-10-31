$(".time").each(function() {
	$(this).text($(this).text().substring(0, $(this).text().length - 5));

});
$(".time").each(function() {
	$(this).val($(this).val().substring(0, $(this).val().length - 5));

});