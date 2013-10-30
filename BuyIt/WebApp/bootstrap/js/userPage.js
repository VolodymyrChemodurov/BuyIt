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
			$("#subCategory").append('<option value=""></option>');
			$.ajax( {
				type: 'POST',
				url: 'subcategory',
				data: {'categoryId': $(this).val()},
				success: function(data) {
					$.each(data, function(index, value) {
						a=value;
					  $("#subCategory").append('<option value="'+value.idSubCategory+'">'+value.name+'</option>');
					});
				}
			});
			
		} else {
			$("#subCategory").empty();
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
		if ($("#subCategory").val() != ""){
			$("#addProductSubmitButton").attr('disabled', false);
		}
	} else {
		$("#startPrice").attr('readonly', true);
		$("#startPrice").val("");
		$("#errorDiv").hide();
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
		if(!$("#auctionCheck").prop("checked")){
			$("#count").attr('readonly', false);
		}
		if ($("#subCategory").val() != ""){
			$("#addProductSubmitButton").attr('disabled', false);
		}
	} else {
		$("#buyNowPrice").attr('readonly', true);
		$("#buyNowPrice").val("");
		$("#count").attr('readonly', true);
		$("#errorDiv").hide();
		if(!$("#auctionCheck").prop("checked")){
			$("#count").val("");
			$("#addProductSubmitButton").attr('disabled', true);
			$("#endedTime").hide();
		}
	}
});

$("#subCategory").change(function(){
	$("#subCategory option:selected").each(function() {
	if ($(this).val() != ""){
		if($("#auctionCheck").prop("checked") || $("#buyNowCheck").prop("checked")){
			$("#addProductSubmitButton").attr('disabled', false);
		}
	} else {
		$("#addProductSubmitButton").attr('disabled', true);
	}
	});
	
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
	$('#avatar').zoom({
		on : 'grab'
	});
});

$('#changeAvatar').click(function(){
	$('#avatarUpload').click();
});

$('#changeImage').click(function(){
	$('#imageUpload').click();
});

$('#imageUpload').change(function() {
	 $("#filelist").empty();
	 var flag = false;
	for (var i = 0; i < this.files.length; i++)
    {
		
		var file = this.files[i];
		
		size = file.size;
		type = file.type;
		error = "";
		
		if (size > 2097152)
			error = "Only less then 2 Mb file. ";
		
		if (type.indexOf("image") == -1)
			error = "File is not an image";
		
		if (error == "") {
			$("#filelist").append('<tr><td width="55%">'+file.name+'</td><td> <button type="button" class="btn btn-primary" style="width: 100px; padding: 0 4px 0 4px;" onclick="deleteImage('+i+')">Delete</button></td><td width="25%"></td></tr>');	
		} else {
			flag = true;
			$("#filelist").append('<tr><td width="60%">'+file.name+'</td><td> <button type="button" class="btn btn-primary" style="width: 100px; padding: 0 4px 0 4px;" onclick="deleteImage('+i+')">Delete</button></td><td width="40%" style="color:red;">'+error+'</td></tr>');	
		}
		
    }
	if(flag){
		$("#errorImage").show();
		$("#errorImage").html("Please choose correct images");
	} else {
		$("#errorImage").hide();
		$("#errorImage").empty();
	}
});

$('#clearImage').click(function(){
	 $("#filelist").empty();
	 $("#errorImage").hide();
	 $("#errorImage").empty();
	 var control = $('#imageUpload');
	 control.replaceWith( control = control.clone( true ) );
});


function deleteImage(id){
//	$('#imageUpload');
//	elm.replaceWith( elm = control.clone( true ) );
	var temp = $('#imageUpload').prop("files");
	for (var i = 0; i < temp.length; i++)
    {
		if(id == temp.length-1){
			temp.length = temp.length-1;
		}else if(i >= id){
			$('#imageUpload').files[i] =temp[i+1];
			temp.length = temp.length-1;
		}
    }
	
	$('#imageUpload').change();
	
}

$('#avatarUpload').change(function() {
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
