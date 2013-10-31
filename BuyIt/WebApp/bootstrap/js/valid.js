var validationflag;

function validateFormOnSubmit() {
	var temp = validateProductName($("#productName").val());
	var flag = true;
	$("#errorDiv").empty();
	if (temp != "") {
		$("#errorDiv").html(temp);
		flag = false;
	} else {
		temp = validateStartPrice($("#startPrice").val());
		if (temp != "") {
			$("#errorDiv").html(temp);
			flag = false;
		} else {
			temp = validateBuyNowPrice($("#buyNowPrice").val());
			if (temp != "") {
				$("#errorDiv").html(temp);
				flag = false;
			} else {
				temp = validateCount($("#count").val());
				if (temp != "") {
					$("#errorDiv").html(temp);
					flag = false;
				} else {
					if ($("#endTime").val() == "") {
						$("#errorDiv").html("Time field is empty");
						flag = false;
					} else {
						if ($("#errorImage").text() != "") {
							$("#errorDiv").html("Choose correct images");
							flag = false;
						}
					}
				}
			}
		}
	}

	if (flag) {
		$('#addProductButton').click();
	} else {
		$("#errorDiv").show();
	}
}

$("#startPrice").change(function() {
	var temp = validateStartPrice($(this).val());
	if (temp != "") {
		$("#errorDiv").show();
		$("#errorDiv").html(temp);
	} else {
		$("#errorDiv").hide();
	}
});

$("#buyNowPrice").change(function() {
	var temp = validateBuyNowPrice($(this).val());
	if (temp != "") {
		$("#errorDiv").show();
		$("#errorDiv").html(temp);
	} else {
		$("#errorDiv").hide();
	}
});

$("#count").change(function() {
	var temp = validateCount($(this).val());
	if (temp != "") {
		$("#errorDiv").show();
		$("#errorDiv").html(temp);
	} else {
		$("#errorDiv").hide();
	}
});

$("#productName").change(function() {
	var temp = validateProductName($(this).val());
	if (temp != "") {
		$("#errorDiv").show();
		$("#errorDiv").html(temp);
		$("#category").prop('disabled', true);
		$("#subCategory").prop('disabled', true);
	} else {
		$("#errorDiv").hide();
		$("#category").prop('disabled', false);
	}
});

$("#productName1").change(function() {
	var temp = validateProductName($(this).val());
	if (temp != "") {
		$("#errorDiv").show();
		$("#errorDiv").html(temp);
	} else {
		$("#errorDiv").hide();
	}
});

$("#endTime").change(function() {
	if ($(this).val() == "") {
		$("#errorDiv").show();
		$("#errorDiv").html("Count field is empty");
	} else {
		$("#errorDiv").hide();
	}
});

function validateStartPrice(fld) {
	var error = "";
	if ($("#auctionCheck").prop("checked")) {
		if (fld == "") {
			error = "Start price field is empty";
		} else if (fld.search(/[0-9]/)) {
			error = "Start price field must contain only numbers.";
		} else if (fld > 3000 || fld < 1) {
			error = "Start price field range [1;3000]";
		}
	}
	return error;
}

function validateBuyNowPrice(fld) {
	var error = "";
	if ($("#buyNowCheck").prop("checked")) {
		if ($("#auctionCheck").prop("checked")){
			if ($("#startPrice").val() <= fld){
				error = "Buy Now Price must be bigger than Start Price.";
			}
		}
		if (fld == "") {
			error = "Price field is empty";
		} else if (fld.search(/[0-9]/)) {
			error = "Price field must contain only numbers.";
		} else if (fld > 9999 || fld < 1) {
			error = "Start field price range [1;9999]";
		}
	}
	return error;
}

function validateCount(fld) {
	var error = "";
	if (fld == "") {
		error = "Count field is empty";
	} else if (fld.search(/[0-9]/)) {
		error = "Count field must contain only numbers.";
	} else if (fld > 10 || fld < 1) {
		error = "Count field range [1;10]";
	}
	return error;
}

function validateProductName(fld) {
	var error = "";
	if (fld.search(/[A-Za-zА-Яа-я0-9- _()]/)) {
		error = "Product name field must contain only numbers.";
	} else if (fld.length < 8) {
		error = "Product name must be more than 8 characters";
	}
	return error;
}

function trim(s) {
	return s.replace(/^\s+|\s+$/, '');
}
