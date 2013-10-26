$(document).ready(function() {
	var currentRating = $("#myrating").val();
	$('.rating-input').click(function() {
		var value = $("#myrating").val();
		var id = $('#id').val();
		var fromId = $('#fromId').val();
		if (value != '' && id != fromId) {
			$.ajax( {
				type: 'POST',
				url: 'rating',
				data: {'rating': value, 'id': id, 'fromId': fromId},
				success: function(responseText) {
					$('#myrating').val(responseText);
					currentRating = responseText;
					$('#current').text('Current rating: ' + (parseInt(responseText) + 1));
					$('#add').text('You add: ' + (parseInt(value) + 1));
					$('#myModal').modal('toggle');
				}
			});
		} else {
			$("#myrating").val(currentRating);
		}
	});
	
});