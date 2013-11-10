$(document).ready(function() {
	$('#bidConfirmation').on('show', function () {
		var input =  Math.ceil($('#bidInput').val());
		if(input > $('#currentPrice').val()){
			$('#placeBidInput').val(input);
			$('.message').text('Your bid: ' + input + '$');
		} else {
			$('.#bidConfirmation').toggle('hide');
		}
	});
});