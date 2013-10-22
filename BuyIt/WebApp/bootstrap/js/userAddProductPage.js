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

$("#auctionCheck").change(function(){
	if ($("#auctionCheck").prop("checked")) {
		$("#startPrice").attr('disabled', false);
		$("#count").attr('disabled', true);
		$("#count").val("1");
	} else {
		$("#startPrice").attr('disabled', true);
		if($("#buyNowCheck").prop("checked")){
			$("#count").attr('disabled', false);
		} else{
			$("#count").attr('disabled', true);
			$("#count").val("");
		}
	}
});

$("#buyNowCheck").change(function(){
	if ($("#buyNowCheck").prop("checked")) {
		$("#buyNowPrice").attr('disabled', false);
		$("#count").val("1");
		if(!$("#auctionCheck").prop("checked")){
			$("#count").attr('disabled', false);
		}
	} else {
		$("#buyNowPrice").attr('disabled', true);
		$("#count").attr('disabled', true);
		if(!$("#auctionCheck").prop("checked")){
			$("#count").val("");
		}
	}
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
$('#salesTabs li:eq(3) a').click(function() {
	$(this).tab('show');
	$("#maContent").empty();
	$("#maContent").load("addSalesContent");
});