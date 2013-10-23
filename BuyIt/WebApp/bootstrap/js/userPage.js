jQuery('document').ready(function() {
	jQuery('#userEditImage').click(function() {
		jQuery('#form-container').show();
		jQuery('#image-container').hide();
	});
	jQuery('#btn-back').click(function() {
		jQuery('#image-container').show();
		jQuery('#form-container').hide();
	});
});

$("#category").change(function() {
	$("#category option:selected").each(function() {
		if ($(this).text() != "") {
			$("#subCategory").prop('disabled', false);
			$("#subCategory").empty();
			$.ajax( {
				type: 'POST',
				url: 'subcategory',
				data: {'categoryId': $(this).val()},
				success: function(data) {
					$.each(data, function(index, value) {
						a=value;
					  $("#subCategory").append('<option value="'+value.categoryId+'">'+value.name+'</option>');
					});
				}
			});
			
		} else {
			$("#subCategory").prop('disabled', true);
		}
	});

}).change();


function deleteEndedSales(id){
		$.ajax( {
			type: 'POST',
			url: 'userDeleteItemServlet',
			data: {'itemId': id},
			success: function(){
				$('#salesTabs li:eq(1) a').click();
			}
		});
}

$("#auctionCheck").change(function(){
	if ($("#auctionCheck").prop("checked")) {
		$("#startPrice").attr('readonly', false);
		$("#count").attr('readonly', true);
		$("#count").val("1");
		$("#endedTime").show();
		$("#addProductSubmitButton").attr('disabled', false);
	} else {
		$("#endedTime").hide();
		$("#startPrice").attr('readonly', true);
		if($("#buyNowCheck").prop("checked")){
			$("#count").attr('readonly', false);
		} else{
			$("#count").attr('readonly', true);
			$("#count").val("");
			$("#addProductSubmitButton").attr('disabled', true);
		}
	}
});

$("#buyNowCheck").change(function(){
	if ($("#buyNowCheck").prop("checked")) {
		$("#buyNowPrice").attr('readonly', false);
		$("#count").val("1");
		$("#addProductSubmitButton").attr('disabled', false);
		if(!$("#auctionCheck").prop("checked")){
			$("#count").attr('readonly', false);
		}
	} else {
		$("#buyNowPrice").attr('readonly', true);
		$("#count").attr('readonly', true);
		if(!$("#auctionCheck").prop("checked")){
			$("#count").val("");
			$("#addProductSubmitButton").attr('disabled', true);
		}
	}
});

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

$(document).ready(function(){
	$('#salesTabs li:eq(1) a').click();
});

$('#salesTabs li:eq(1) a').click(function() {
	$(this).tab('show');
	$("#maContent").empty();
	$("#maContent").load("activeSalesContent");

	

});
$('#salesTabs li:eq(2) a').click(function() {
	$(this).tab('show');
	$("#maContent").empty();
	$("#maContent").load("endedSalesContent");
	
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

function editProduct(id) {
	$('#salesTabs li:eq(3) a').trigger("click");
	return false;
}
