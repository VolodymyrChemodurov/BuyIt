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
					if (responseText == value && /^[a-z0-9_-]{4,15}$/i.test(responseText)) {
						$('#register').prop('disabled', false);
						$('#logindiv').text("");
						$('#logindiv').addClass('valid').closest(
						'.control-group').removeClass('error')
						.addClass('success');
					} else {
						$('#register').prop('disabled', true);
						if(responseText != value)
							$('#logindiv').text(responseText);
						$('#logindiv').closest('.control-group').removeClass(
						'success').addClass('error');
					}
				}
			});
		} else $('#register').prop('disabled', true);
	});
});