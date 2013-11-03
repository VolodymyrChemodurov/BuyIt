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
					var resp = responseText.split(':');
					$('#marksCount').text(resp[1]);
					$('#myrating').val(parseInt(resp[0]) - 1);
					currentRating = resp[0];
					$('#current').text('New rating: ' + parseInt(resp[0]));
					$('#add').text('You add: ' + parseInt(value));
					$('#myModal').modal('toggle');
				}
			});
		} else {
			$("#myrating").val(currentRating);
		}
	});
	
});