$(document).ready(function() {
			$(window).load(
					function() {
						console.log("session user:" + $('#userId').val()
								+ "  product userId:"
								+ $('#userIdProduct').val());
						if ($('#userId').val() == $('#userIdProduct').val()) {
							$('#buyItButton').attr("disabled", "disabled");

							$('#placeBidButton').attr("disabled", "disabled");
							$('#quantity').attr("disabled", "disabled");
							$('#placeBidInput').attr("disabled", "disabled");
						}
					});

			$('#placeBidInput').change(function() {
				var placeBidButton = $('#placeBidButton');
				var currentPrice = document.getElementById("currentBid").value;
				var bid = $('#placeBidInput').attr('value');
				if (parseInt(currentPrice) >= parseInt(bid)) {
					placeBidButton.attr("disabled", "disabled");
				} else {
					placeBidButton.removeAttr("disabled");
				}

			});

			$('#quantity').change(function() {
				var count = $('#count').val();
				console.log("count: " + count);
				var quantity = $('#quantity').val();
				if (parseInt(quantity) > parseInt(count)) {
					$('#buyItButton').attr("disabled", "disabled");
				} else {

					$('#buyItButton').removeAttr("disabled");
				}

			});
			$('#buyItForm').submit(function(event){
				if ($('#quantity').attr('value') == "") {
					return false;
				}
			});
			$('#placeABidForm').submit(function(event){
				if ($('#placeBidInput').attr('value') == "") {
					return false;
				}
			});
			
			$('#placeBidInput').keypress(function(e) {
				// alert("Enter");
				if (e.which == 13) {
					if ($('#placeBidInput').attr('value') == "") {
						return false;
					}
				}
			});
			$('#quantity').keypress(function(e) {
			 //alert("Enter");
				if (e.which == 13) {
					if ($('#quantity').attr('value') == "") {
						return false;
					}
				}
			});
			

		});