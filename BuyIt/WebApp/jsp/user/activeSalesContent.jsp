<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<style>

</style>

<div id="activeSales">
	<c:if test="${empty userActiveSales}">
		<h1 style="text-align: center;">Sorry, but you have not any
			active sales!</h1>
		<h3 style="text-align: center;">You can add new sale, to preview
			it here</h3>
	</c:if>
	<c:if test="${not empty userActiveSales}">
		<h1>Active sales</h1>
		<div id="table-wrapper">
  			<div id="table-scroll">
		<table class="table table-striped">
			<thead>
				<tr>
					<th><span class="text">Product Name</span></th>
					<th><span class="text">Start Time</span></th>
					<th><span class="text">End Time</span></th>
	
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${userActiveSales}">
					<tr>
						<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
						<td class="time">${product.auction.startTime}</td>
						<td class="time">${product.auction.endTime}</td>

						<td>
						<form action="userEditProduct" method="get">
							<input class="text" style="display: none" name="productId" value="${product.idProduct}">				
								<button type="submit" class="btn btn-success" style="width:60px; padding: 0 4px 0 4px;"
									onclick="editProduct(${product.idProduct})">edit</button>
						</form>
						</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		</div>
		</div>

	</c:if>
</div>

<script src="bootstrap/js/time-formatter.js"></script>

