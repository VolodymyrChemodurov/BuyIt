<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.thumbnail-my img {
	height: 150px;
}

.thumbnail-my .caption {
	padding: 9px;
	color: #555;
}

.span3 {
	width: 190px;
}

.thumbnail-my {
	width: 200px;
	height: 240px;
	display: block;
	padding: 4px;
	line-height: 20px;
	border: 1px solid #ddd;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.055);
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.055);
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.055);
	-webkit-transition: all .2s ease-in-out;
	-moz-transition: all .2s ease-in-out;
	-o-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
	background: #fff;
	position: relative;
	border: 1px solid #eee;
	text-align:center;
}
</style>
<li class="span3">
	<div class="thumbnail-my">
		<a href="product_details.html"><img
			src="<c:out value="${product.description.itemPhotos[0].path }"></c:out>"></a>
		<div class="caption">
			<h5>
				<c:out value="${product.name}"></c:out>
			</h5>
			<h4>
				<a class="btn" href="product_details.html">VIEW</a> <span
					class="pull-right"><c:out
						value="${product.auction.buyItNow}"></c:out></span>
			</h4>
		</div>
	</div>
</li>