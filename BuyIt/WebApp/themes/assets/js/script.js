$(document).ready(
		function() {
			
			$.validator.addMethod("loginRegex", function(value, element) {
		        return this.optional(element) || /^[a-z0-9_-]{4,15}$/i.test(value);
		    }, "Username must contain only letters, numbers, or dashes.");
			
			$.validator.addMethod("firstNameRegex", function(value, element) {
		        return this.optional(element) || /^[A-Z][a-zA-Z ]+$/i.test(value);
		    }, "Start only from capital letter");
			
			$.validator.addMethod("lastNameRegex", function(value, element) {
		        return this.optional(element) || /^[A-Z][a-zA-Z ]+$/i.test(value);
		    }, "Start only from capital letter");
			
			$.validator.addMethod("passwordRegex", function(value, element) {
		        return this.optional(element) || /^[\w_-]{6,15}$/i.test(value);
		    }, "More then 6 characters. Only numbers, small letters and dashes");
			
			$.validator.addMethod("phoneRegex", function(value, element) {
		        return this.optional(element) || /^\d{10}$/i.test(value);
		    }, "Yours phone number (10 digits)");
			
			$.validator.addMethod("cityRegex", function(value, element) {
		        return this.optional(element) || /^[A-Za-z]+$/i.test(value);
		    }, "Please enter valid city name");
			
			$.validator.addMethod("streetRegex", function(value, element) {
		        return this.optional(element) || /^[A-Za-z]+$/i.test(value);
		    }, "Please enter valid street name");
			
			$.validator.addMethod("houseRegex", function(value, element) {
		        return this.optional(element) || /^[\d]{1,3}[a-z]?$/i.test(value);
		    }, "Please enter valid house number");
			
			$.validator.addMethod("flatRegex", function(value, element) {
		        return this.optional(element) || /^[\d]{1,3}[a-z]?$/i.test(value);
		    }, "Pleas enter valid flat number");
			
			$.validator.addMethod("zipCodeRegex", function(value, element) {
		        return this.optional(element) || /^\d{5}$/i.test(value);
		    }, "Enter zip code (5 digits)");
			
			$('#registration-form').validate(
					{
						rules : {
							lastName : {
								required : true,
								lastNameRegex : true
							},
							email : {
								required : true,
								email : true
							},
							firstName : {
								required : true,
								firstNameRegex: true
							},
							login : {
								loginRegex: true,
								required : true
							},
							password : {
								required : true,
								passwordRegex: true,
							},
							confirmPassword : {
								required : true,
								minlength : 6,
								equalTo : "#password2"
							},
							phone: {
								phoneRegex: true
							},
							city: {
								cityRegex: true
							},
							street: {
								streetRegex: true
							},
							house: {
								houseRegex: true
							},
							flat: {
								flatRegex: true
							},
							zipCode: {
								zipCodeRegex: true
							}
						},
						highlight : function(element) {
							$(element).closest('.control-group').removeClass(
									'success').addClass('error');
						},
						success : function(element) {
							element.text('OK!').addClass('valid').closest(
									'.control-group').removeClass('error')
									.addClass('success');
						}
					});

		});