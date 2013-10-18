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

$('#oldPassword').change(function() {
	var password = $("#oldPassword").val();
	var login = $("#login").val();
	if (password == ''){
		$('#passwordChangeResult').empty();
		$('#passwordChangeResult').show();
		$('#passwordChangeResult').append('<span style ="color:red;">Incorrect old password</span>');
		$('#passwordBlockApply').attr("disabled", "disabled");
	} else {
		$.ajax( {
			type: 'POST',
			url: 'checkPassword',
			data: {'login': login, 'password':password},
			success: function(data) {
				if (data == login) {
					$('#passwordChangeResult').empty();
					$('#passwordChangeResult').append('<span style ="color:red;">Incorrect old password</span>');
					$('#passwordBlockApply').attr("disabled", "disabled");
					$('#passwordChangeResult').show();
				} else {
					$('#passwordChangeResult').hide();
					$('#passwordBlockApply').removeAttr("disabled");

				}
			}
		});
	}
});


function showPasswordBlock(){
	$('#changePasswordBlock').show();
}

function editProduct(id) {

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
