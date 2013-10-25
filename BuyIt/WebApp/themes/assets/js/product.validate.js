$(document).ready(
		function() {
			
			$.validator.addMethod("startPriceRegex", function(value, element) {
				return this.optional(element) || (/^\d+$/.test(value) && ( value >= 0 && value <= 20000 ));
		    }, "\*\*\*");

			$.validator.addMethod("buyNowPriceRegex", function(value, element) {
				return this.optional(element) || (/^\d+$/.test(value) && ( value >= 0 && value <= 20000 ));
		    }, "\*\*\*");

			$.validator.addMethod("countRegex", function(value, element) {
				return this.optional(element) || (/^\d+$/.test(value) && ( value >= 0 && value <= 100 ));
		    }, "\*\*\*");
			
			
			
			$('#userAddProductServlet').validate(
					{
						rules : {
							startPrice: {
								required : true,
								startPriceRegex : true
							},
							buyNowPrice: {
								required : true,
								buyNowPriceRegex : true
							},
							count : {
								required : true,
								countRegex: true
							}
							
						},
				
						highlight : function(element) {
							$(element).closest('.myrow').removeClass(
									'success').addClass('error');
						},
						success : function(element) {
							element.addClass('valid1').closest(
									'.myrow').removeClass('error')
									.addClass('success');
						}
						
					});

		});