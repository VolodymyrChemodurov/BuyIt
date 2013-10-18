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

$("#category").change(function() {
	var str = "";
	$("#category option:selected").each(function() {
		if ($(this).text() != "") {
			str += $(this).text() + " ";
			$("#subCategory").prop('disabled', false);
			$("#subCategory").empty();
			$.ajax( {
				type: 'POST',
				url: 'subcategory',
				data: {'categoryId': $(this).val()},
				success: function(data) {
					$.each(data, function(index, value) {
						a=value;
					  $("#subCategory").append('<option value="">'+value.name+'</option>');
					});
				}
			});
			
		} else {
			$("#subCategory").prop('disabled', true);
		}
	});

}).change();

$('#passwordBlockCancel').click(function() {
	$('#changePasswordBlock').hide();
});

$('#passwordBlockApply').click(function() {
	var old = $("oldPassword").value();
	var newp = $("newPassword").value();
	var confirm = $("confirmPassword").value();
	
	if (old == ''){
		
	} else if(newp == ''){}
	
	$.ajax( {
		type: 'POST',
		url: 'subcategory',
		data: {'categoryId': $(this).val()},
		success: function(data) {
			$.each(data, function(index, value) {
				a=value;
			  $("#subCategory").append('<option value="">'+value.name+'</option>');
			});
		}
	});
	
	
});

function showPasswordBlock(){
	$('#changePasswordBlock').show();
}

function editProduct(id) {

	$('#salesTabs li:eq(3) a').click();
	$('#salesTabs li:eq(3) a').click();
}

$('#salesTabs li:eq(4) a').click(function() {
	$(this).tab('show');
	$('#activeSales').hide();
	$('#endedSales').hide();
	$('#addNewSale').hide();
	$('#editTab').show();
	$('#editPage').show();

});

$('#salesTabs li:eq(1) a').click(function() {
	$(this).tab('show');
	$('#activeSales').show();
	$('#endedSales').hide();
	$('#addNewSale').hide();
	$('#editTab').hide();
	$('#editPage').hide();

});
$('#salesTabs li:eq(2) a').click(function() {
	$(this).tab('show');
	$('#activeSales').hide();
	$('#endedSales').show();
	$('#addNewSale').hide();
	$('#editTab').hide();
	$('#editPage').hide();
});
$('#salesTabs li:eq(3) a').click(function() {
	$(this).tab('show');
	$('#activeSales').hide();
	$('#endedSales').hide();
	$('#addNewSale').show();
	$('#editTab').hide();
	$('#editPage').hide();
});

$('#shoppingTabs li:eq(1) a').click(function() {
	$(this).tab('show');
	$('#activeShopping').show();
	$('#purchasedShopping').hide();
	$('#lostShopping').hide();
});
$('#shoppingTabs li:eq(2) a').click(function() {
	$(this).tab('show');
	$('#activeShopping').hide();
	$('#purchasedShopping').show();
	$('#lostShopping').hide();
});
$('#shoppingTabs li:eq(3) a').click(function() {
	$(this).tab('show');
	$('#activeShopping').hide();
	$('#purchasedShopping').hide();
	$('#lostShopping').show();
});
