$(document).ready(
		function() {
			
			$.validator.addMethod("loginRegex", function(value, element) {
		        return this.optional(element) || /^[a-z0-9_-]{4,15}$/i.test(value);
		    }, "Username must contain only letters, numbers, or dashes.");
			
			$.validator.addMethod("firstNameRegex", function(value, element) {
		        return this.optional(element) || /^[A-Z][a-zA-Z ]+$/i.test(value);
		    }, "FIRST NAME");
			
			$.validator.addMethod("lastNameRegex", function(value, element) {
		        return this.optional(element) || /^[a-zA-Z ]+$/i.test(value);
		    }, "LAST NAME");
			
			$.validator.addMethod("passwordRegex", function(value, element) {
		        return this.optional(element) || /^[\w_-]{6,15}$/i.test(value);
		    }, "PASSWORD");
			
			$.validator.addMethod("phoneRegex", function(value, element) {
		        return this.optional(element) || /^\d{10}$/i.test(value);
		    }, "PHONE");
			
			$.validator.addMethod("cityRegex", function(value, element) {
		        return this.optional(element) || /^[A-Za-z]+$/i.test(value);
		    }, "CITY");
			
			$.validator.addMethod("streetRegex", function(value, element) {
		        return this.optional(element) || /^[A-Za-z]+$/i.test(value);
		    }, "STREET");
			
			$.validator.addMethod("houseRegex", function(value, element) {
		        return this.optional(element) || /^[\d]{1,3}[a-z]*\/[\d]{1,3}[a-z]*$/i.test(value);
		    }, "");
			
			$.validator.addMethod("zipCodeRegex", function(value, element) {
		        return this.optional(element) || /^\d{5}$/i.test(value);
		    }, "ZIP_CODE");
			
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