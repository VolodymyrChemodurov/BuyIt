$(document).ready(function() {
	$('#buyConfirmation').on('show', function () {
		var input =  $('#quantityInput').val();
		var price = $('#price').val();
		$('#quantity').val(input);
		$('.message').text('Items count: ' + input);
		$('.message2').text('To pay: ' + (input * price));
	});
});