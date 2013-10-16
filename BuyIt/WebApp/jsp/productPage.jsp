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
<!--Less styles -->
<!-- Other Less css file //different less files has different color scheam
	<link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
	-->
<!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
	<script src="themes/js/less.js" type="text/javascript"></script> -->
</head>



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
	<div id="header" style="background: white">
		<div class="container">

			<div id="mainBody">
				<div class="container">
					<div class="row">

						<jsp:include page="sidebarMenu"></jsp:include>
						<div class="span9">
							<ul class="breadcrumb">
								<li><a href="index.html">Home</a> <span class="divider">/</span></li>
								<li><a href="products.html">Products</a> <span
									class="divider">/</span></li>
								<li class="active">product Details</li>
							</ul>

							<div class="row">


								<c:if test="${fn:length(product.description.itemPhotos) eq 1}">
									<div id="gallery" class="span3">
										<a
											href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											title="<c:out value="${product.name }" />"> <img
											src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											style="width: 100%" alt="<c:out value="${product.name }" />">

										</a>
									</div>
								</c:if>
								<c:if
									test="${(fn:length(product.description.itemPhotos) gt 1) && (fn:length(product.description.itemPhotos) le 3)}">
									<div id="gallery" class="span3">
										<a
											href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											title="<c:out value="${product.name }" />"> <img
											src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											style="width: 99%" alt="<c:out value="${product.name }" />">

										</a>

										<div id="differentview" class="moreOptopm carousel slide">

											<div class="carousel-inner">

												<div class="item active">
													<c:forEach var="image"
														items="${product.description.itemPhotos }">
														<a href="${image.path}"> <img
															style="width: 81px; height: 65px" src="${image.path}"
															alt="" /></a>
													</c:forEach>
												</div>

											</div>

											<!-- 											<a class="left carousel-control" href="#myCarousel" -->
											<!-- 												data-slide="prev">‹</a> <a class="right carousel-control" -->
											<!-- 												href="#myCarousel" data-slide="next">›</a> -->

										</div>
										Photos in Gallery:
										<c:out value="${fn:length(product.description.itemPhotos)}"></c:out>
									</div>
								</c:if>

								<c:if test="${(fn:length(product.description.itemPhotos) >= 4)}">
									<div id="gallery" class="span3">
										<a
											href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											title="<c:out value="${product.name }" />"> <img
											src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
											style="width: 100%" alt="<c:out value="${product.name }" />">

										</a>

										<div id="differentview" class="moreOptopm carousel slide">

											<div class="carousel-inner">

												<div class="item active">
													<c:forEach var="image" begin="0" end="2"
														items="${product.description.itemPhotos }">
														<a href="${image.path}"> <img style="width: 29%"
															src="${image.path}" alt="" /></a>
													</c:forEach>
												</div>

												<div class="item">
													<c:forEach var="image" begin="3"
														items="${product.description.itemPhotos }">
														<a href="${image.path}"> <img style="width: 29%"
															src="${image.path}" alt="" /></a>
													</c:forEach>

												</div>
												Photos in Gallery:
												<c:out value="${fn:length(product.description.itemPhotos)}"></c:out>
											</div>

											<!-- 											<a class="left carousel-control" href="#myCarousel" -->
											<!-- 												data-slide="prev">‹</a> <a class="right carousel-control" -->
											<!-- 												href="#myCarousel" data-slide="next">›</a> -->

										</div>


										<div class="btn-toolbar">
											<div class="btn-group">
												<span class="btn"><i class="icon-envelope"></i></span> <span
													class="btn"><i class="icon-print"></i></span> <span
													class="btn"><i class="icon-zoom-in"></i></span> <span
													class="btn"><i class="icon-star"></i></span> <span
													class="btn"><i class=" icon-thumbs-up"></i></span> <span
													class="btn"><i class="icon-thumbs-down"></i></span>
											</div>
										</div>
									</div>
								</c:if>








								<div class="span6">
									<h3>
										<c:out value="${product.name}"></c:out>
									</h3>
									<c:if test="${diffInDays <= 1}">
										<font size="3" color="red">( <c:out
												value="${diffInDays}"></c:out> Days left for end )
										</font>
									</c:if>
									<c:if test="${diffInDays > 3}">
										<font size="3" color="green">( <c:out
												value="${diffInDays}"></c:out> Days left for end )
										</font>
									</c:if>
									<c:if test="${(diffInDays >1)&&(diffInDays <=3) }">
										<font size="3" color="red">( <c:out
												value="${diffInDays}"></c:out> Days left for end )
										</font>
									</c:if>
									<hr class="soft" />
									<c:if test="${product.auction.currentPrice != 0 }">
										<form class="form-horizontal qtyFrm">
											<div class="control-group">
												<label class="control-label"><span>Current
														Price: <c:out value="${product.auction.currentPrice}"></c:out>$
												</span></label>
												<div class="controls">
													<label class="control-label" text-align="right"><span>
															You Bid:</span></label> <input type="number"
														value="<c:out value="${product.auction.currentPrice+1}"></c:out>"
														class="span1" placeholder="Your Bid" />
													<button type="submit"
														class="btn btn-large btn-primary pull-right">
														Place a Bid</button>
												</div>
											</div>
										</form>
										<hr class="soft" />
									</c:if>

									<c:if test="${product.auction.buyItNow != 0 }">
										<form class="form-horizontal qtyFrm">
											<div class="control-group">
												<label class="control-label"><span> Buy it
														By: <c:out value="${product.auction.buyItNow}"></c:out> $
												</span></label>
												<div class="controls">
													<label class="control-label" text-align="right"><span>
															Quantity:</span></label> <input type="number" class="span1"
														placeholder="Qty." />
													<button type="submit"
														class="btn btn-large btn-primary pull-right">Buy
														it now</button>
												</div>
											</div>
										</form>
										<hr class="soft" />
									</c:if>

									<h4>
										<c:out value="${product.auction.count}"></c:out>
										items in stock
									</h4>

									<hr class="soft clr" />
									<p>
										<c:out value="${product.description.features}"></c:out>
									</p>
									<br class="clr" /> <a href="#" name="detail"></a>
									<hr class="soft" />
								</div>

								<div class="span9">
									<ul id="productDetail" class="nav nav-tabs">
										<li class="active"><a href="#home" data-toggle="tab">Product
												Details</a></li>
										<li><a href="#history" data-toggle="tab">Bid History</a></li>
										<li><a href="#profile" data-toggle="tab">Delivery</a></li>
									</ul>
									<div id="myTabContent" class="tab-content">
										<div class="tab-pane fade active in" id="home">
											<h4>Product Information</h4>
											<hr class="soft" />
											Auction start time:
											<c:out value="${product.auction.startTime}"></c:out>
											<br> Auction end time:
											<c:out value="${product.auction.endTime}"></c:out>
											<hr class="soft" />
											<c:out value="${product.description.descText} "></c:out>
											<hr class="soft" />
										</div>


										<div class="tab-pane fade" id="history">
											<h4>Bid History</h4>
											<hr class="soft" />
											<table class="table table-bordered">
												<tbody>
													<tr class="techSpecRow">
														<th>User Name</th>
														<th>Time</th>
														<th>Amount</th>
													</tr>
													<c:forEach var="userItem" items="${userList}">
														<tr class="techSpecRow">
															<td class="techSpecTD1">${userItem.login}"</td>
															<c:forEach var="bid" items="${userItem.bidList}">
																<td class="techSpecTD1">${bid.time}</td>
																<td class="techSpecTD1">${bid.amount}</td>
															</c:forEach>
														</tr>
													</c:forEach>

												</tbody>
											</table>
											<hr class="soft" />
										</div>



										<div class="tab-pane fade" id="profile">
											<h4>Information for Buyers</h4>

											<hr class="soft" />
											<c:out value="${product.delivery }"></c:out>
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

			<!-- MainBody End ============================= -->
			<script src="themes/js/jquery.js" type="text/javascript"></script>
			<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
			<script src="themes/js/google-code-prettify/prettify.js"></script>

			<script src="themes/js/bootshop.js"></script>
			<script src="themes/js/jquery.lightbox-0.5.js"></script>
			<script src="bootstrap/js/search.js"></script>


		</div>
		<jsp:include page="footer"></jsp:include>
</body>
</html>