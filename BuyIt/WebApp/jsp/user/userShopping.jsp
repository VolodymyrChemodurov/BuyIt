<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<html lang="en">
<head>
<meta charset="utf-8">
<title>BuyIt</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap style -->

<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen">
<link href="themes/css/base.css" rel="stylesheet" media="screen">
<!-- Bootstrap style responsive -->
<link href="bootstrap/css/userpage.css" rel="stylesheet">
<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="themes/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<!-- Google-code-prettify -->
<link href="themes/js/google-code-prettify/prettify.css"
	rel="stylesheet">
<!-- fav and touch icons -->
<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<style type="text/css" id="enject"></style>
</head>
<body>
	<jsp:include page="navbar"></jsp:include>
	<!-- Header End====================================================================== -->

	<div class="container">
		<div id="maWrapper" class="corAll5">
			<ul id="vMenu">
				<li><a href="userProfile">Profile</a></li>
				<li><a href="userSalesServlet">Sales</a></li>
				<li id="active"><strong>Shopping</strong></li>
				<li><a href="userCommentsServlet">Comments</a></li>
				<li><a href="userAddProductServlet">Product</a></li>
			</ul>
			<!-- / #vMenu -->
			<div style="overflow: hidden;">
				<div width="200" class="left-menu">
					<ul class="nav nav-list" id="shoppingTabs">
						<li class="nav-header">My shopping</li>
						<li class="active"><a href="#">Active</a></li>
						<li><a href="#">Purchased</a></li>
						<li><a href="#">Lost</a></li>
						<li><a href="#">Bought</a></li>
					</ul>
				</div>
				<!-- /left-menu -->

				<div id="maContent" class="corAll5">
					<div id="activeShopping">
						<c:if test="${empty userActiveShopping}">
							<h1 style="text-align: center;">Sorry, but now you do not
								take part in any auctions!</h1>
						</c:if>
						<c:if test="${not empty userActiveShopping}">
							<h1>Active auctions in which you participate</h1>
							<div id="table-wrapper">
								<div id="table-scroll">
									<table class="table table-striped">
										<thead>
											<tr>
												<th><span class="text">Product Name</span></th>
												<th><span class="text">Start Time</span></th>
												<th><span class="text">End Time</span></th>
												<th><span class="text">Price</span></th>
												<th><span class="text">My bid</span></th>
												<th><span class="text">Buy</span></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="product" items="${userActiveShopping}">
												<tr>
													<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
													<td class="time">${product.auction.startTime}</td>
													<td class="time">${product.auction.endTime}</td>
													<td>${product.auction.currentPrice}</td>
													<c:forEach var="bids" items="${bids}">
														<c:if
															test="${bids.auctionId eq product.auction.idAuction}">
															<td><c:out value="${bids.amount}" /></td>
															<td>
																<form action="bid_serve">
																	<input type="hidden" value="${product.idProduct}"
																		name="id_product" /> <input type="hidden"
																		value="${bids.amount + 1}" name="bid" />
																	<button class="btn btn-primary"
																		style="width: 100px; padding: 0 4px 0 4px;"
																		onclick="editProduct(${product.idProduct})">Bid
																		${bids.amount + 1}</button>
																</form>
															</td>
														</c:if>
													</c:forEach>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
					</div>
					<div id="purchasedShopping" style="display: none;">
						<c:if test="${empty userPurchasedShopping}">
							<h1 style="text-align: center;">Sorry, but you didn't won
								any auction.</h1>
							<h3 style="text-align: center;">You can improve it :)</h3>

						</c:if>
						<c:if test="${not empty userPurchasedShopping}">
							<h1>Auctions whitch you WON</h1>
							<div id="table-wrapper">
								<div id="table-scroll">
									<table class="table table-striped">
										<thead>
											<tr>
												<th><span class="text">Product Name</span></th>
												<th><span class="text">Start Time</span></th>
												<th><span class="text">End Time</span></th>
												<th><span class="text">Price</span></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="product" items="${userPurchasedShopping}">
												<tr>
													<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
													<td class="time">${product.auction.startTime}</td>
													<td class="time">${product.auction.endTime}</td>
													<td>${product.auction.currentPrice}</td></tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

						</c:if>


					</div>
					<div id="lostShopping" style="display: none;">
						<c:if test="${empty userLostShopping}">
							<h1 style="text-align: center;">Sorry, but you didn't lost
								any auction.</h1>
						</c:if>
						<c:if test="${not empty userLostShopping}">
							<h1>Active auctions in whitch you participate</h1>
							<div id="table-wrapper">
								<div id="table-scroll">
									<table class="table table-striped">
										<thead>
											<tr>
												<th><span class="text">Product Name</span></th>
												<th><span class="text">Start Time</span></th>
												<th><span class="text">End Time</span></th>
												<th><span class="text">Price</span></th>
												<th><span class="text">My bid</span></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="product" items="${userLostShopping}">
												<tr>
													<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
													<td class="time">${product.auction.startTime}</td>
													<td class="time">${product.auction.endTime}</td>
													<td>${product.auction.currentPrice}</td>
													<td><c:forEach var="bids" items="${bids}">
															<c:if
																test="${bids.auctionId eq product.auction.idAuction}">
																<c:out value="${bids.amount}" />
															</c:if>
														</c:forEach></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
					</div>
					<div id="buyShopping" style="display: none;">
						<c:if test="${empty userBuyShopping}">
							<h1 style="text-align: center;">Sorry, but you do not by
								anything, yet.</h1>
							<h3 style="text-align: center;">You can improve it :)</h3>

						</c:if>
						<c:if test="${not empty userBuyShopping}">
							<h1>Products whitch you bought</h1>
							<div id="table-wrapper">
								<div id="table-scroll">
									<table class="table table-striped">
										<thead>
											<tr>
												<th><span class="text">Product Name</span></th>
												<th><span class="text">Start Time</span></th>
												<th><span class="text">End Time</span></th>
												<th><span class="text">Price</span></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="product" items="${userBuyShopping}">
												<tr>
													<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
													<td class="time">${product.auction.startTime}</td>
													<td class="time">${product.auction.endTime}</td>
													<td>${product.auction.buyItNow}</td>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

						</c:if>


					</div>

				</div>
				<!-- /maContent -->
			</div>
		</div>

	</div>

	<div style="height: 60px;"></div>



	<jsp:include page="footer"></jsp:include>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
	<script src="bootstrap/js/userPage.js"></script>
	<script src="bootstrap/js/search.js"></script>
	<script src="bootstrap/js/time-formatter.js"></script>
</body>
</html>
