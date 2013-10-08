<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<li class="span3">
	<div class="thumbnail">
		<a href="product_details.html"><img
			src=<c:out value="${product.description.itemPhotos[0].path }"></c:out>></a>
		<div class="caption">
			<h5><c:out value="${product.name}"></c:out></h5>
			<h4>
				<a class="btn" href="product_details.html">VIEW</a> <span
					class="pull-right"><c:out value="${product.price}"></c:out></span>
			</h4>
		</div>
	</div>
</li>