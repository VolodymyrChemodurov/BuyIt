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

$('#salesTabs li:eq(1) a').click(function() {
	$(this).tab('show');
	$('#activeSales').show();
	$('#endedSales').hide();
	$('#addNewSale').hide();
});
$('#salesTabs li:eq(2) a').click(function() {
	$(this).tab('show');
	$('#activeSales').hide();
	$('#endedSales').show();
	$('#addNewSale').hide();
});
$('#salesTabs li:eq(3) a').click(function() {
	$(this).tab('show');
	$('#activeSales').hide();
	$('#endedSales').hide();
	$('#addNewSale').show();
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

