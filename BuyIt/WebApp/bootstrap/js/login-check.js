$(document).ready(function() {
	$('#inputLogin').focusout(function() {
		var value = $("#inputLogin").val();
		$.get('check', {
			login : value
		}, function(responseText) {
			if(responseText == value) {
				$('#register').prop('disabled', false);
				$('#logindiv').text("");
			}
			else {
				$('#register').prop('disabled', true);
				$('#logindiv').text(responseText);
			}
		});
	});
});