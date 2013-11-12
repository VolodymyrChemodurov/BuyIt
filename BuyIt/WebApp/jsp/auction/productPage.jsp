<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>BuyIt online auction</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" />
<link rel="stylesheet" href="themes/assets_timer/css/styles.css" />
<link rel="stylesheet"
	href="themes/assets_timer/countdown/jquery.countdown.css" />

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen" />
<link href="themes/css/base.css" rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="themes/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<!-- Google-code-prettify -->
<link href="themes/js/google-code-prettify/prettify.css"
	rel="stylesheet" />
<!-- fav and touch icons -->
<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<style type="text/css" id="enject"></style>
<style>
.dis {
	pointer-events: none;
	cursor: default;
	disabled: disabled;
}


</style>
</head>

<body>
	<!-- ---------------------------NAVBAR---------------------------------------- -->
	<jsp:include page="navbar"></jsp:include>
	<div id="header" style="background: white">
		<div class="container">

			<div id="mainBody">
				<div class="container">
					<div class="row">
						<!-- -----------------SIDEBARMENU--------------- -->
						<jsp:include page="sidebarMenu"></jsp:include>
						<div class="span9">
							<ul class="breadcrumb">
								<li><a href="index">Home</a> <span
									class="divider">/</span></li>
								<li><a href="categoryViewer?id=${category.idCategory}">${category.name}</a>
									<span class="divider">/</span></li>


								<c:forEach var="subCategory"
									items="${category.listSubCategories}">
									<li><a
										href="select_category?id=${subCategory.idSubCategory}">${subCategory.name}</a>
										<span class="divider">/</span></li>

									<li class="active"><c:out value="${product.name}"></c:out></li>
								</c:forEach>
							</ul>

							<div class="row">
								<c:if test="${fn:length(product.description.itemPhotos) eq 0}">
									<div id="gallery" class="span3">
										<img
											src="<c:out value="themes/images/mocks/noAvailablePhoto.jpg"></c:out>"
											style="height: 250px" alt="no photo" />


									</div>
								</c:if>
								<c:if test="${fn:length(product.description.itemPhotos) eq 1}">
									<div id="gallery" class="span3" style="text-align: center">
										<a
											href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											title="<c:out value="${product.name }" />"> <img 
											class="my-image" style="visibility: hidden;"
											src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											alt="<c:out value="${product.name }" />">

										</a>

									</div>
								</c:if>
								<c:if
									test="${(fn:length(product.description.itemPhotos) gt 1) && (fn:length(product.description.itemPhotos) le 3)}">
									<div id="gallery" class="span3" style="text-align: center">
										<a
											href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											title="<c:out value="${product.name }" />"><div
												style="height: 250px; text-align: center">
												<img class="my-image" style="visibility: hidden;"
													src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
													alt="<c:out value="${product.name }" />">
											</div> </a>

										<div id="differentview" class="moreOptopm carousel slide">

											<div class="carousel-inner">

												<div class="item active" style="display: inline-block;">
													<c:forEach var="image" begin="1"
														items="${product.description.itemPhotos }">

														<a href="${image.path}">
															<div style="display: inline; width: 81px">
																<img class="my-image-mini" style="visibility: hidden;" src="${image.path}" alt=""
																	style="visibility: hidden" />
															</div>
														</a>
													</c:forEach>
												</div>

											</div>



										</div>

									</div>
								</c:if>

								<c:if test="${(fn:length(product.description.itemPhotos) >= 4)}">
									<div id="gallery" class="span3"
										style="text-align: center; height: 250px">
										<a
											href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											title="<c:out value="${product.name }" />"> <img
											class="my-image" style="visibility: hidden;"
											src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											alt="<c:out value="${product.name }" />">

										</a>

										<div id="differentview" class="moreOptopm carousel slide">

											<div class="carousel-inner">

												<div class="item active">
													<c:forEach var="image" begin="1" end="3"
														items="${product.description.itemPhotos }">
														<a href="${image.path}"> <img class="my-image-mini" style="visibility: hidden;"
															src="${image.path}" alt="" /></a>
													</c:forEach>
												</div>

												<div class="item">
													<c:forEach var="image" begin="4"
														items="${product.description.itemPhotos }">
														<a href="${image.path}"> <img style="width: 29%" style="visibility: hidden;"
															src="${image.path}" alt="" /></a>
													</c:forEach>

												</div>

											</div>


										</div>
									</div>
								</c:if>







								<!-- -------------------------CENTRAL CONTROL PANEL (place a bid , Buy it now )-------------------- -->
								<div class="span6">
									<input type="hidden" id="userIdProduct"
										value="${product.userId}" /> <input type="hidden" id="userId"
										value="${user.idUser}" /> <font size="5"> <c:out
											value="${product.name}"></c:out>
									</font> <br>
									<dir class="form-horizontal qtyFrm" style="padding: 10px">
										<small style="width: 250px" id="note"></small>
									</dir>
									<dir class="form-horizontal qtyFrm">
										<input type="hidden" id="currentBid"
											value="${product.auction.currentPrice}" />
										<input type="hidden" id="time"
											value="${product.auction.endTime}" />
										<input type="hidden" id="status"
											value="${product.auction.status}" />
										<div id="countdown"></div>
									</dir>
									<hr class="soft" />

									<!--                                                 ----------------------        PLACE A BID------------------------- -->
									<c:if test="${product.auction.currentPrice != 0 }">
										<div class="form-horizontal qtyFrm">
											<div class="control-group">
												<label class="control-label" style="width: 40%"> <span>Current
														Price: <c:out value="${product.auction.currentPrice}"></c:out>$
												</span>
												</label>
												<div class="controls">
													<label class="control-label" style="width: 27%"> <span
														> Your Bid:</span>
													</label> <input type="number" name="bid" id="bidInput"
														min="${product.auction.currentPrice+1}" max="999999"
														value="${product.auction.currentPrice+1}"
														class="span1" placeholder="Your Bid" /> <a
														id="placeBidButton" href="#bidConfirmation" role="button"
														data-toggle="modal"
														class="btn btn-default btn-primary pull-right">Place a
														Bid </a>
												</div>
											</div>
										</div>
										<hr class="soft" />

										<div id="bidConfirmation" class="modal hide fade"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h3 id="myModalLabel">Bid confirmation</h3>
											</div>
											<form id="placeABidForm" method="get"
												action="bid_serve?id_product">
												<input type="hidden" id="currentPrice"
													value="${product.auction.currentPrice}"> <input
													type="hidden" name="id_product"
													value="${product.idProduct}" /> <input type="hidden"
													name="bid" id="placeBidInput" />
												<div class="modal-body">
													<p>Are you sure that you want to participate in this
														auction?</p>
													<p class="message"></p>
												</div>
												<div class="modal-footer">
													<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
													<button type="submit" id="placeBidButton"
														class="btn btn-default btn-primary pull-right">Place
														a Bid</button>
												</div>
											</form>
										</div>
									</c:if>
									<!-- ---------------------------------------------BUY IT NOW------------------------ -->

									<c:if test="${product.auction.buyItNow != 0 }">
										<div class="form-horizontal qtyFrm">
											<div class="control-group">
												<label class="control-label" style="width: 40%"> <span>
														Buy it Now: <c:out value="${product.auction.buyItNow}"></c:out>
														$
												</span>
												</label>
												<div class="controls">
													<label class="control-label" style="width: 27%" text-align="right">
														<span>Quantity:</span>
													</label> <input type="number" maxlength="4" min="1" id="quantityInput"
														max="${product.auction.count}" name="quantity"
														class="span1" value="1" /> <a id="buyItButton"
														href="#buyConfirmation" role="button" data-toggle="modal"
														class="btn btn-default btn-primary pull-right">Buy it
														now </a>
												</div>
											</div>
										</div>
										<hr class="soft" />



										<div id="buyConfirmation" class="modal hide fade"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h3 id="myModalLabel">Bid confirmation</h3>
											</div>
											<form id="buyItForm" class="form-horizontal qtyFrm"
												action="buyItServe" method="POST">
												<input type="hidden" name="id_product"
													value="${product.idProduct}" /> <input type="hidden"
													name="count" id="count" value="${product.auction.count}" />
												<input type="hidden" name="quantity" id="quantity" /> <input
													type="hidden" name="price" id="price"
													value="${product.auction.buyItNow}" />
												<div class="modal-body">
													<p>Are you sure that you want to participate in this
														auction?</p>
													<p class="message"></p>
													<p class="message2"></p>
												</div>
												<div class="modal-footer">
													<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
													<button type="submit" id="placeBidButton"
														class="btn btn-default btn-primary pull-right">Buy
														it now</button>
												</div>
											</form>
										</div>


									</c:if>

									<h4>
										<c:choose>
										<c:when test="${product.auction.count == 0}">
										No Items in Stock
										</c:when>
										<c:when test="${product.auction.count == 1}">
										<c:out value="${product.auction.count}"></c:out>
										 Item in Stock
										</c:when>
										<c:when test="${product.auction.count > 1}">
										<c:out value="${product.auction.count}"></c:out>
										 Items in Stock
										</c:when>
										</c:choose>
									</h4>

									<hr class="soft clr" />
									<h5>
										Seller: <a href="user_wall?id=${seller.idUser}"
											class="btn btn-link"><c:out value="${seller.login}"></c:out></a>
										<c:if test="${seller.ban != 'unbanned' }">
											<font style="color: red"> (<c:out
													value="${seller.ban}"></c:out>)
											</font>
										</c:if>
									</h5>




								</div>
								<!--    ------------DELIVERY--------BID HISTORY----------DETAILS------------ -->
								<div class="span9">
									<div class="thumbnail">
										<ul id="productDetail" class="nav nav-tabs">
											<li class="active"><a href="#home" data-toggle="tab">Product
													Details</a></li>
											<li><a href="#history" data-toggle="tab">Bid History</a></li>
											<li><a href="#delivery" data-toggle="tab">Delivery</a></li>
											<li><a href="#features" data-toggle="tab">Features</a></li>
										</ul>
										<div id="myTabContent" class="tab-content">
											<div class="tab-pane fade active in" id="home"
												style="padding-left: 30px; padding-right: 30px">
												<div class="form-horizontal qtyFrm">
													${product.description.descText}</div>
												<hr class="soft" />
												Auction start time: <span class="time">${product.auction.startTime}</span>
												<br> Auction end time: <span class="time">${product.auction.endTime}</span>
												<hr class="soft" />
											</div>


											<div class="tab-pane fade" id="history"
												style="padding-left: 30px;  padding-right: 30px">

												<table class="table table-bordered">
													<tbody>
														<tr class="techSpecRow">
															<th>User Name</th>
															<th>Time</th>
															<th>Amount</th>
														</tr>
														<c:forEach var="userItem" items="${userList}">
															<tr class="techSpecRow">
																<!--  <td class="techSpecTD1">${userItem.login}</td>-->
																<td class="techSpecTD1"><a href="user_wall?id=${userItem.idUser}" >${userItem.login}</a></td>
																<c:forEach var="bid" items="${userItem.bidList}">
																	<td class="techSpecTD1"><span class="time">${bid.time}</span></td>
																	<td class="techSpecTD1">${bid.amount}</td>
																</c:forEach>
															</tr>
														</c:forEach>

													</tbody>
												</table>

											</div>



											<div class="tab-pane fade" id="delivery"
												style="padding-left: 30px;  padding-right: 30px">


												<hr class="soft" />
												${product.delivery }
												<hr class="soft" />
												<br class="clr">
											</div>

											<div class="tab-pane fade" id="features"
												style="padding-left: 30px;  padding-right: 30px">

												<hr class="soft" />
												${product.description.features}
												<hr class="soft" />
												<br class="clr">
											</div>


										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

			</div>

			<!-- MainBody End ============================= -->
			<script src="themes/js/jquery.js" type="text/javascript"></script>
			<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
			<script src="themes/js/google-code-prettify/prettify.js"></script>
			<script src="themes/js/bootshop.js"></script>
			<script src="themes/js/jquery.lightbox-0.5.js"></script>

			<!-- JavaScript includes -->
			<script src="themes/assets_timer/countdown/jquery.countdown.js"></script>
			<script src="themes/assets_timer/js/script.js"></script>

			<script src="bootstrap/js/search.js"></script>

			<script src="bootstrap/js/thumbnail-image-large.js"
				type="text/javascript"></script>
			<script src="bootstrap/js/thumbnail-image-mini.js"
				type="text/javascript"></script>


			<script src="bootstrap/js/product-page-button-checker.js"
				type="text/javascript"></script>
			<script src="bootstrap/js/bid-confirmation.js" type="text/javascript"></script>
			<script src="bootstrap/js/buy-confirmation.js" type="text/javascript"></script>
			<script src="bootstrap/js/time-formatter.js" type="text/javascript"></script>
		</div>
		<!--                 ----------------footer--------------------------------------- -->
		<jsp:include page="footer"></jsp:include>
	</div>
</body>
</html>
