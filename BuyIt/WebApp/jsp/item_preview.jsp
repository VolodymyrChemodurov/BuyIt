<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="themes/css/item-preview.css" rel="stylesheet">

<li class="span3-my">
	<div class="thumbnail-my">
		<a href="product_details.html"><img
			src="<c:out value="${product.description.itemPhotos[0].path }"></c:out>"></a>
		<div class="caption">
			<h5>
				<c:out value="${product.name}"></c:out>
			</h5>
		</div>
		<h4>
			<a data-toggle="modal" href="#myModal${product.idProduct}" class="btn-my" href="#">INFO</a> <span class="pull-right"><a
				class="btn btn-primary" href="#"><c:out
						value="${product.auction.buyItNow}"></c:out></a></span>
		</h4>
		
	</div> <!-- Modal -->
	<div class="modal fade" id="myModal${product.idProduct}" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">${product.name}</h4>
				</div>
				<div class="modal-body">
				Start time: ${product.auction.startTime}<br/>
				End time: ${product.auction.endTime}<br/>
				Buy It Now: ${product.auction.buyItNow}<br/>
				Count: ${product.auction.count}<br/>
				Current Price: ${product.auction.currentPrice}<br/>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

</li>