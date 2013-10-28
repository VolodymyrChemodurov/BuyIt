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
			$("#subCategory").append('<option value=""></option>');
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
		$("#startPrice").val("1");
		$("#count").attr('readonly', true);
		$("#count").val("1");
		$("#endedTime").show();
		$("#addProductSubmitButton").attr('disabled', false);
	} else {
		$("#startPrice").attr('readonly', true);
		$("#startPrice").val("");
		if($("#buyNowCheck").prop("checked")){
			$("#count").attr('readonly', false);
		} else{
			$("#count").attr('readonly', true);
			$("#count").val("");
			$("#endedTime").hide();
			$("#addProductSubmitButton").attr('disabled', true);
		}
	}
});

$("#buyNowCheck").change(function(){
	if ($("#buyNowCheck").prop("checked")) {
		$("#endedTime").show();
		$("#buyNowPrice").attr('readonly', false);
		$("#buyNowPrice").val("1");
		$("#count").val("1");
		$("#addProductSubmitButton").attr('disabled', false);
		if(!$("#auctionCheck").prop("checked")){
			$("#count").attr('readonly', false);
		}
	} else {
		$("#buyNowPrice").attr('readonly', true);
		$("#buyNowPrice").val("");
		$("#count").attr('readonly', true);
		if(!$("#auctionCheck").prop("checked")){
			$("#count").val("");
			$("#addProductSubmitButton").attr('disabled', true);
			$("#endedTime").hide();
		}
	}
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
	$('#changeAvatarBlock').hide();
	$('#changePasswordBlock').show();
}

function showAvatarBlock(){
	$('#changePasswordBlock').hide();
	$('#changeAvatarBlock').show();
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
	$('#buyShopping').hide();
	
});
$('#shoppingTabs li:eq(2) a').click(function() {
	$(this).tab('show');
	$('#activeShopping').hide();
	$('#purchasedShopping').show();
	$('#lostShopping').hide();
	$('#buyShopping').hide();
});
$('#shoppingTabs li:eq(3) a').click(function() {
	$(this).tab('show');
	$('#activeShopping').hide();
	$('#purchasedShopping').hide();
	$('#lostShopping').show();
	$('#buyShopping').hide();
});

$('#shoppingTabs li:eq(4) a').click(function() {
	$(this).tab('show');
	$('#activeShopping').hide();
	$('#purchasedShopping').hide();
	$('#lostShopping').hide();
	$('#buyShopping').show();
});

function editProduct(id) {
	$('#salesTabs li:eq(3) a').trigger("click");
	return false;
}



$(document).ready(function() {
	$('#avatar').wheelzoom();
	$('#avatar').zoom({
		on : 'grab'
	});
});

$('#changeAvatar').click(function(){
	$('#avatarUpload').click();
});

$(':file').change(function() {
	
	var file = this.files[0];
	
	size = file.size;
	type = file.type;
	error = "";

	if (size > 2097152)
		error = "Only less then 2 Mb file. ";

	if (type.indexOf("image") == -1)
		error = "File is not an image";

	if (error == "") {
	
	} else {
		$('#avatarChangeError').html(error);
		$('#avatarChangeError').show();
		$("#changeAvatarForm").each(function() {
			this.reset();
		});
	}
});	

 $('#avatarBlockApply').click(function(event) {
	      
	   var fileVal = $('#avatarUpload').val();
	   if (fileVal == '') {
		   event.preventDefault();
		   $('#avatarChangeError').html("Choose file at first!");
		   $('#avatarChangeError').show();
	   }
 });
