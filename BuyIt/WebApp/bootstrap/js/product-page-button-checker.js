$(document).ready(function() {
			$(window).load(
					function() {
						console.log("session user:" + $('#userId').val()
								+ "  product userId:"
								+ $('#userIdProduct').val());
						if ($('#userId').val() == $('#userIdProduct').val()) {
							
							$('#quantityInput').attr("disabled", "disabled");
							$('#bidInput').attr("disabled", "disabled");
							
							$('#buyItButton').attr("disabled", "disabled");
							$('#buyItButton').addClass('dis');
							$('#buyItButton').attr("tabindex", "-1");
							
							$('#placeBidButton').attr("disabled", "disabled");
							$('#placeBidButton').addClass('dis');
							$('#placeBidButton').attr("tabindex", "-1");
						}
					});
			

			$('#bidInput').keyup(function() {
				var placeBidButton = $('#placeBidButton');
				var currentPrice = document.getElementById("currentBid").value;
				var bid = $(this).val();
				console.log(bid);
				
				if ((parseInt(currentPrice) >= parseInt(bid))||(!($.isNumeric(bid)))||(bid.length > 6)) {
					placeBidButton.attr("disabled", "disabled");
					placeBidButton.addClass('dis');
					placeBidButton.attr('tabindex', '-1');
				} else {
					placeBidButton.removeAttr("disabled");
					placeBidButton.removeClass('dis');
				}
			});
			
			
			$('#bidInput').click(function() {
				var placeBidButton = $('#placeBidButton');
				var currentPrice = document.getElementById("currentBid").value;
				var bid = $(this).val();
				console.log(bid);
				
				if ((parseInt(currentPrice) >= parseInt(bid))||(!($.isNumeric(bid)))||(bid.length > 6)) {
					placeBidButton.attr("disabled", "disabled");
					placeBidButton.addClass('dis');
					placeBidButton.attr('tabindex', '-1');
				} else {
					placeBidButton.removeAttr("disabled");
					placeBidButton.removeClass('dis');
				}
			});

			$('#quantityInput').keyup(function() {
				var count = $('#count').val();
				console.log("count: " + count);
				var quantity = $('#quantityInput').val();
				if ((parseInt(quantity) > parseInt(count))|(parseInt(quantity) < 1)|(!($.isNumeric(quantity)))){
					$('#buyItButton').attr("disabled", "disabled");
					$('#buyItButton').addClass('dis');
					$('#buyItButton').attr('tabindex', '-1');
				} else {
					$('#buyItButton').removeClass('dis');
					$('#buyItButton').removeAttr("disabled");
				}

			});
			
			$('#quantityInput').click(function() {
				var count = $('#count').val();
				console.log("count: " + count);
				var quantity = $('#quantityInput').val();
				if ((parseInt(quantity) > parseInt(count))|(parseInt(quantity) < 1)|(!($.isNumeric(quantity)))){
					$('#buyItButton').attr("disabled", "disabled");
					$('#buyItButton').addClass('dis');
					$('#buyItButton').attr('tabindex', '-1');
				} else {
					$('#buyItButton').removeClass('dis');
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
//  Lock ENTER	
			$('#bidInput').keypress(function(e) {
				if (e.which == 13) {
					if ($('#bidInput').attr('value') == "") {
						return false;
					}
				}
			});
			$('#quantityInput').keypress(function(e) {
				if (e.which == 13) {
					if ($('#quantityInput').attr('value') == "") {
						return false;
					}
				}
			});

		});
