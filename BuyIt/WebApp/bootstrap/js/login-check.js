$(document).ready(function() {
	$('#register').prop('disabled', true);
	$('#alogin').focusout(function() {
		var value = $("#alogin").val();
		if (value != '') {
			$.get('check', {
				login : value
			}, function(responseText) {
				if (responseText == value) {
					$('#register').prop('disabled', false);
					$('#logindiv').text("");					
				} else {
					$('#register').prop('disabled', true);
					$('#logindiv').text(responseText);
				}
			});
		} else $('#register').prop('disabled', true);
	});
});