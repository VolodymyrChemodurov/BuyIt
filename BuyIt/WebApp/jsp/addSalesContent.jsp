<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div id="addNewSale">
	<div class="mycontent">
		<h3>Create new auction</h3>
		<div class="myrow">
			<span class="span-1">Product name:</span> <span class="span-2"><input
				name="productName" value="" /></span>
		</div>
		<div class="myrow">
			<span class="span-1">Category:</span> <span class="span-2"> <select
				id="category" name="category">
					<option value=""></option>
					<c:forEach var="category" items="${categories}">
						<option value="${category.idCategory}">${category.name}</option>
					</c:forEach>
			</select>
			</span>
		</div>
		<div class="myrow">
			<span class="span-1">Sub Category:</span> <span class="span-2">
				<c:if test=""></c:if> <select disabled="disabled" id="subCategory"
				name="subCategory">
					<option value=""></option>

			</select>
			</span>
		</div>
		<br>

		<div class="myrow">
			<span class="span-1" style="width: 160px">End time</span>
			<div style="padding-left: 40px; padding-bottom: 20px;"
				class="input-append date form_datetime"
				data-date="2013-02-21T15:25:00Z">
				<input size="16" type="text" value="" readonly
					style="border-radius: 0; padding: 2px;"> <span
					class="add-on" style="padding: 2px;"><i class="icon-remove"></i></span>
				<span class="add-on" style="border-radius: 0; padding: 2px;"><i
					class="icon-calendar"></i></span>
			</div>
		</div>


	</div>
	<div id="right-menu" class="my-right-content"
		style="min-height: 150; height: 150px;">

		<div id="form-container" style="padding-top: 40px">
			<div class="myrow-sales">
				<span style="margin-left: 0px; margin-right: 5px; width: 20px;"
					class="span-3"> <input id="auctionCheck" type="checkbox">
				</span> <span class="span-2"
					style="margin-left: 0px; margin-right: 5px; width: 110px;"><b>Auction</b></span>
				<span class="span-2"
					style="margin-left: 0px; margin-right: 5px; width: 100px;">Start
					price</span> <span class="span-2"><input id="startPrice"
					disabled="disabled" style="width: 100px;" name="startPrice"
					value="" /></span>

			</div>
			<div class="myrow-sales">
				<span style="margin-left: 0px; margin-right: 5px; width: 20px;"
					class="span-3"> <input id="buyNowCheck" type="checkbox">
				</span> <span class="span-2"
					style="margin-left: 0px; margin-right: 5px; width: 110px;"><b>Buy
						it now</b></span> <span class="span-2"
					style="margin-left: 0px; margin-right: 5px; width: 100px;">Price</span>
				<span class="span-2"><input id="buyNowPrice"
					disabled="disabled" style="width: 100px;" name="buyNowPrice"
					value="" /></span>
			</div>
			<div class="myrow-sales">
				<span class="span-2"
					style="padding-left: 140px; margin-left: 0px; margin-right: 5px; width: 100px;">Count</span>
				<span class="span-2"><input id="count" disabled="disabled"
					style="width: 100px;" name="count" value="" /></span>
			</div>



		</div>
	</div>


	<div class="panel-group" id="accordion">
		<div
			style="background-color: #eeeeee; margin-top: 40px; padding-top: 3px;"
			class="panel panel-default">
			<div class="panel-heading">
				<h4 style="padding-left: 40px;" class="panel-title">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion" href="#collapseOne">Delivery</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="container" style="margin-left: 40px;">
						<textarea class="textarea" placeholder="Enter text ..."
							style="width: 850px; height: 200px"></textarea>

					</div>

				</div>
			</div>
		</div>
		<div style="background-color: #eeeeee; padding-top: 3px;"
			class="panel panel-default">
			<div class="panel-heading">
				<h4 style="padding-left: 40px;" class="panel-title">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion" href="#collapseTwo">Features</a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="container" style="margin-left: 40px;">
						<textarea class="textarea" placeholder="Enter text ..."
							style="width: 850px; height: 200px"></textarea>

					</div>
				</div>
			</div>
		</div>
		<div style="background-color: #eeeeee; padding-top: 3px;"
			class="panel panel-default">
			<div class="panel-heading">
				<h4 style="padding-left: 40px;" class="panel-title">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion" href="#collapseThree"> Description</a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="container" style="margin-left: 40px;">
						<textarea class="textarea" placeholder="Enter text ..."
							style="width: 850px; height: 200px"></textarea>

					</div>
				</div>
			</div>
		</div>
	</div>




</div>

	<script src="bootstrap/js/wysihtml5-0.3.0.js"></script>
	<script src="bootstrap/js/bootstrap-wysihtml5.js"></script>
	<script src="bootstrap/js/bootstrap-datetimepicker.js"></script>

	<script>
		$('.textarea').wysihtml5();
	</script>

	<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        format: "dd MM yyyy - hh:ii",
        autoclose: true,
        todayBtn: true,
        startDate: "2013-02-14 10:00",
        minuteStep: 5
    });
</script>



<%-- <div id="editPage" style="display: none;">
	<c:if test="${empty userActiveSales}">
		<h1 style="text-align: center;">Sorry, but you can not add new
			sale, because you are BLOKED</h1>
		<h3 style="text-align: center;">Contact with admin.</h3>

	</c:if>
</div> --%>

