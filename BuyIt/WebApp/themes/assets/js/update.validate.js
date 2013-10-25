$(document).ready(
		function() {
			
			$.validator.addMethod("loginRegex", function(value, element) {
		        return this.optional(element) || /^[a-z0-9_-]{4,15}$/i.test(value);
		    }, "Username must contain only letters, numbers, or dashes.");
			
			$.validator.addMethod("firstNameRegex", function(value, element) {
		        return this.optional(element) || /^[A-Z][a-zA-Z ]+$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("lastNameRegex", function(value, element) {
		        return this.optional(element) || /^[A-Z][a-zA-Z ]+$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("passwordRegex", function(value, element) {
		        return this.optional(element) || /^[\w_-]{6,15}$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("phoneRegex", function(value, element) {
		        return this.optional(element) || /^\d{10}$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("cityRegex", function(value, element) {
		        return this.optional(element) || /^[A-Za-z]+$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("streetRegex", function(value, element) {
		        return this.optional(element) || /^[A-Za-z]+$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("houseRegex", function(value, element) {
		        return this.optional(element) || /^[\d]{1,3}[a-z]?$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("flatRegex", function(value, element) {
		        return this.optional(element) || /^[\d]{1,3}[a-z]?$/i.test(value);
		    }, "\*\*\*");
			
			$.validator.addMethod("zipCodeRegex", function(value, element) {
		        return this.optional(element) || /^\d{5}$/i.test(value);
		    }, "\*\*\*");
			$.validator.addMethod("emailRegex", function(value, element) {
				return this.optional(element) || /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(value);
		    }, "\*\*\*");
			
			$('#userUpdateContainer').validate(
					{
						rules : {
							lastName : {
								required : true,
								lastNameRegex : true
							},
							email : {
								required : true,
								emailRegex : true
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