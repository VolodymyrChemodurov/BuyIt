$(document).ready(
		function() {
			
			$.validator.addMethod("loginRegex", function(value, element) {
		        return this.optional(element) || /^[a-z0-9_-]{4,15}$/i.test(value);
		    }, "Username must contain only letters, numbers, or dashes.");
			
			$.validator.addMethod("firstNameRegex", function(value, element) {
		        return this.optional(element) || /^[A-Z][a-z]+{3,15}$/i.test(value);
		    }, "FIRST NAME");
			
			$.validator.addMethod("lastNameRegex", function(value, element) {
		        return this.optional(element) || /^[A-Z][a-z-]+{3,15}$/i.test(value);
		    }, "LAST NAME");
			
			$.validator.addMethod("passwordRegex", function(value, element) {
		        return this.optional(element) || /^[\\w_-]{6,15}$/i.test(value);
		    }, "PASSWORD");
			
			$('#registration-form').validate(
					{
						rules : {
							lastName : {
								lastNameRegex : true,
								required : true
							},
							email : {
								required : true,
								email : true
							},
							firstName : {
								firstNameRegex: true,
								required : true
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