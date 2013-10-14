jQuery('document').ready(function() {
	jQuery('#olko').click(function() {
		jQuery('#form-container').show();
		jQuery('#image-container').hide();	
	});
	jQuery('#btn-back').click(function() {
		jQuery('#image-container').show();	
		jQuery('#form-container').hide();
	});
});



	
