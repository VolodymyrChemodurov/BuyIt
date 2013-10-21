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
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="themes/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="themes/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="themes/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="themes/images/ico/apple-touch-icon-57-precomposed.png">
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
				<li><a href="#">Comments</a></li>
			</ul>
			<!-- / #vMenu -->
			<div style="overflow: hidden;">
				<div width="200" class="left-menu">
					<ul class="nav nav-list" id="shoppingTabs">
						<li class="nav-header">My shopping</li>
						<li class="active"><a href="#">Active</a></li>
						<li><a href="#">Purchased</a></li>
						<li><a href="#">Lost</a></li>
					</ul>
				</div>
				<!-- /left-menu -->

				<div id="maContent" class="corAll5">
					<div id="activeShopping">
						<c:if test="${empty userActiveShopping}">
							<h1 style="text-align: center;">Sorry, but now you do not take part in any auctions!</h1>
						</c:if>
						<c:if test="${not empty userActiveShopping}">
							<h1>Active auctions in which you participate</h1>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Product Name</th>
										<th>Start Time</th>
										<th>End Time</th>
										<th>Current price</th>
										<th>Buy it now</th>
										<th>My bid</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${userActiveShopping}">
										<tr>
											<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
											<td>${product.auction.startTime}</td>
											<td>${product.auction.endTime}</td>
											<td>${product.auction.currentPrice}</td>
											<td>${product.auction.buyItNow}</td>
											<td>
												<form action="" method="">
														<c:forEach var="bids" items="${bids}">
															<c:if test="${bids.auctionId eq product.auction.idAuction}">
																<c:out value="${bids.amount}"/>
															</c:if>
														</c:forEach>
												</form>
											</td>
											

											<td>
												<form>
													<input type="hidden" value="${product.idProduct}" name="id" />
													<button class="btn btn-primary"
														style="padding: 0 4px 0 4px;"
														onclick="editProduct(${product.idProduct})">Plase a bid</button>
												</form>
											</td>
											<td>
												<form action="" method="">
													<input type="hidden" value="${product.idProduct}" name="id" />
													<button class="btn btn-success"
														style="padding: 0 4px 0 4px;" type="submit">Buy it Now</button>
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</c:if>
					</div>
					<div id="purchasedShopping"style="display: none;">
						<c:if test="${empty userPurchasedShopping}">
							<h1 style="text-align: center;">Sorry, but you do not by anything, yet.</h1>
							<h3 style="text-align: center;">You can improve it :)</h3>

						</c:if>
						<c:if test="${not empty userPurchasedShopping}">
							<h1>Auctions which you WON</h1>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Product Name</th>
										<th>Start Time</th>
										<th>End Time</th>
										<th>Current price</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${userPurchasedShopping}">
										<tr>
											<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
											<td>${product.auction.startTime}</td>
											<td>${product.auction.endTime}</td>
											<td>${product.auction.currentPrice}</td>
									</c:forEach>
								</tbody>
							</table>

						</c:if>
						
						
					</div>
					<div id="lostShopping"style="display: none;">
						<c:if test="${empty userLostShopping}">
							<h1 style="text-align: center;">Sorry, but you didn't lost any auction.</h1>
						</c:if>
						<c:if test="${not empty userLostShopping}">
							<h1>Active auctions in which you participate</h1>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Product Name</th>
										<th>Start Time</th>
										<th>End Time</th>
										<th>Current price</th>
										<th>Buy it now</th>
										<th>My bid</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${userLostShopping}">
										<tr>
											<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
											<td>${product.auction.startTime}</td>
											<td>${product.auction.endTime}</td>
											<td>${product.auction.currentPrice}</td>
											<td>${product.auction.buyItNow}</td>
											<td>
												<form action="" method="">
														<c:forEach var="bids" items="${bids}">
															<c:if test="${bids.auctionId eq product.auction.idAuction}">
																<c:out value="${bids.amount}"/>
															</c:if>
														</c:forEach>
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

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
</body>
</html>
