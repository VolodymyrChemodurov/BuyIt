$(document).ready(function() {
	$('#bidConfirmation').on('show', function () {
		var input =  $('#bidInput').val();
		$('#placeBidInput').val(input);
		$('.message').text('Your bid: ' + input + '$');
	});
});