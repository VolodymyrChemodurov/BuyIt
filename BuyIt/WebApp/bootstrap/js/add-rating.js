$(document).ready(function() {
	var currentRating = $("#myrating").val();
	$('.rating-input').click(function() {
		var value = parseInt($("#myrating").val()) + 1;
		var id = $('#id').val();
		var fromId = $('#fromId').val();
		if (value != '' && id != fromId) {
			$.ajax( {
				type: 'POST',
				url: 'rating',
				data: {'rating': value, 'id': id, 'fromId': fromId},
				success: function(responseText) {
					$('#myrating').val(parseInt(responseText) - 1);
					currentRating = responseText;
					$('#current').text('New rating: ' + parseInt(responseText));
					$('#add').text('You add: ' + parseInt(value));
					$('#myModal').modal('toggle');
				}
			});
		} else {
			$("#myrating").val(currentRating);
		}
	});
	
});