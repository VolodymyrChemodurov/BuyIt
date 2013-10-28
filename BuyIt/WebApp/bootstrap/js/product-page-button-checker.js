$(document).ready(function() {
			$(window).load(
					function() {
						console.log("session user:" + $('#userId').val()
								+ "  product userId:"
								+ $('#userIdProduct').val());
						if ($('#userId').val() == $('#userIdProduct').val()) {
							$('#buyItButton').attr("disabled", "disabled");

							$('#placeBidButton').attr("disabled", "disabled");
							$('#quantityInput').attr("disabled", "disabled");
							$('#bidInput').attr("disabled", "disabled");
						}
					});

			$('#bidInput').change(function() {
				var placeBidButton = $('#placeBidButton');
				var currentPrice = document.getElementById("currentBid").value;
				var bid = $('#bidInput').attr('value');
				if (parseInt(currentPrice) >= parseInt(bid)) {
					placeBidButton.attr("disabled", "disabled");
				} else {
					placeBidButton.removeAttr("disabled");
				}

			});

			$('#quantityInput').change(function() {
				var count = $('#count').val();
				console.log("count: " + count);
				var quantity = $('#quantityInput').val();
				if (parseInt(quantity) > parseInt(count)) {
					$('#buyItButton').attr("disabled", "disabled");
				} else {

					$('#buyItButton').removeAttr("disabled");
				}

			});
			$('#buyItForm').submit(function(event){
				if ($('#quantityInput').attr('value') == "") {
					return false;
				}
			});
			$('#placeABidForm').submit(function(event){
				if ($('#bidInput').attr('value') == "") {
					return false;
				}
			});
			
			$('#bidInput').keypress(function(e) {
				// alert("Enter");
				if (e.which == 13) {
					if ($('#bidInput').attr('value') == "") {
						return false;
					}
				}
			});
			$('#quantityInput').keypress(function(e) {
			 //alert("Enter");
				if (e.which == 13) {
					if ($('#quantityInput').attr('value') == "") {
						return false;
					}
				}
			});
			

		});