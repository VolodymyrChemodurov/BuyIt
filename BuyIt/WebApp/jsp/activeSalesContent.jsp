<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="activeSales">
	<c:if test="${empty userActiveSales}">
		<h1 style="text-align: center;">Sorry, but you have not any
			active sales!</h1>
		<h3 style="text-align: center;">You can add new sale, to preview
			it here</h3>
	</c:if>
	<c:if test="${not empty userActiveSales}">
		<h1>Active sales</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Start Time</th>
					<th>End Time</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${userActiveSales}">
					<tr>
						<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
						<td>${product.auction.startTime}</td>
						<td>${product.auction.endTime}</td>

						<td>
								<button class="btn btn-success" style="padding: 0 4px 0 4px;"
									onclick="editProduct(${product.idProduct})">edit</button>
						</td>
						<td>
							<button class="btn btn-danger" style="padding: 0 4px 0 4px;"
								 onclick="deleteActiveSales(${product.idProduct})">delete</button></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

	</c:if>
</div>

