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
			<a class="btn-my" href="#">INFO</a>
			<span class="pull-right"><a class="btn btn-primary" href="#"><c:out
						value="${product.auction.buyItNow}"></c:out></a></span>
		</h4>
	</div>
</li>