$(document).ready(function() {
	$('#register').prop('disabled', true);
	$('#alogin').focusout(function() {
		var value = $("#alogin").val();
		if (value != '') {
			$.ajax( {
				type: 'POST',
				url: 'check',
				data: {'login': value},
				success: function(responseText) {
					if (responseText == value) {
						$('#register').prop('disabled', false);
						$('#logindiv').text("");
						$('#logindiv').addClass('valid').closest(
						'.control-group').removeClass('error')
						.addClass('success');
					} else {
						$('#register').prop('disabled', true);
						$('#logindiv').text(responseText);
						$('#logindiv').closest('.control-group').removeClass(
						'success').addClass('error');
					}
				}
			});
		} else $('#register').prop('disabled', true);
	});
});