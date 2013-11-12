$(document).ready(function() {
	$('#buyConfirmation').on('show', function () {
		var input =  $('#quantityInput').val();
		if(input <= $('#count').val()){
			var price = $('#price').val();
			$('#quantity').val(input);
			$('.message').text('Items count: ' + input);
			$('.message2').text('To pay: ' + (input * price) + "$");
		}else{
			$('.#buyConfirmation').toggle('hide');
		}
		
		
	});
});