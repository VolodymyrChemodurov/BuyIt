<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<title>BuyIt</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen" />
<link href="themes/css/base.css" rel="stylesheet" media="screen" />
<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="themes/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<link href="themes/js/google-code-prettify/prettify.css"
	rel="stylesheet" />
<link href="themes/css/simplePagination.css" rel="stylesheet"
	type="text/css">

<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="themes/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="themes/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="themes/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="themes/images/ico/apple-touch-icon-57-precomposed.png">

<script src="themes/js/jquery.js" type="text/javascript"></script>
<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
<script src="themes/js/google-code-prettify/prettify.js"></script>

<script src="themes/js/bootshop.js"></script>
<script src="themes/js/jquery.lightbox-0.5.js"></script>

<!--     <link type="text/css" rel="stylesheet" href="themes/css/pagination/animate.css"> -->
<!--     <link type="text/css" rel="stylesheet" href="themes/css/pagination/github.css"> -->
<link type="text/css" rel="stylesheet"
	href="themes/css/pagination/jPages.css">
<!--     <link type="text/css" rel="stylesheet" href="themes/css/pagination/style.css"> -->

<script type="text/javascript"
	src="themes/js/pagination/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="themes/js/pagination/highlight.pack.js"></script>
<script src="themes/js/pagination/jPages.js"></script>
<script src="themes/js/pagination/js.js"></script>
<script type="text/javascript" src="themes/js/pagination/tabifier.js"></script>
<script src="bootstrap/js/search.js"></script>

<style type="text/css" id="enject"></style>

<script type="text/javascript">
	$(document).ready(function() {
		$("div.holder").jPages({
			containerID : "itemContainer",
			perPage : 9,
			startPage : 1,
			startRange : 1,
			midRange : 5,
			endRange : 1
		});
	});
</script>

</head>

<body>
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<div class="span9">

					<h3>
						Search result <small class="pull-right">
							${aviliablePrdcts} products are available </small>
					</h3>

					<hr class="soft" />

					<div id="myTab" class="pull-right">
						<a href="#listView" data-toggle="tab"><span
							class="btn btn-large"><i class="icon-list"></i></span></a> <a
							href="#blockView" data-toggle="tab"><span
							class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
					</div>

					<br class="clr" />

					<div class="tab-content">
						<div class="tab-pane" id="listView">
							<c:forEach items="${srchedPrdct}" var="item">
								<c:forEach items="${buyingDetails}" var="item1">

									<c:set var="auction" value="${item1.productId}" />
									<c:set var="product" value="${item.idProduct}" />

									<c:if test="${(auction == product)}">
										<div class="row">
											<div class="span2">

												<!-- Image of product -->
												<c:set var="flag" value="0" scope="page" />
												<c:forEach items="${images}" var="item3">
													<c:forEach items="${description}" var="item4">
														<c:set var="desc" value="${item4.idDescription}" />
														<c:set var="image" value="${item3.descriptionId}" />
														<c:if test="${(desc == image) && flag != 1}">
															<img src="${item3.path}" alt="" />
															<c:set var="flag" value="${flag + 1}" scope="page" />
														</c:if>
													</c:forEach>
												</c:forEach>

											</div>
											<div class="span4">
												<h3>
													<c:out value="${item.name}" />
												</h3>
												<hr class="soft" />
												<p>
													<!-- Short details -->
													<c:forEach items="${description}" var="item2">
														<c:set var="detail" value="${item2.productId}" />
														<c:if test="${(detail == product)}">
															<c:out value="${item2.descText}" />
														</c:if>
													</c:forEach>
												</p>
												<a class="btn btn-small pull-right"
													href="product_details.html">View Details</a>
												<!-- forward to product_detail.jsp -->
												<br class="clr" />
											</div>
											<div class="span3 alignR">
												<form class="form-horizontal qtyFrm">
													<h3>${item1.currentPrice}</h3>
													<!-- get price of the product from DB -->
													<br /> <a href="product_details.html"
														class="btn btn-large btn-primary"> Add to <i
														class=" icon-shopping-cart"></i></a>
													<!-- forward to shopping_card.jsp -->

												</form>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</c:forEach>
							<hr class="soft" />
						</div>

						<div class="tab-pane  active" id="blockView">
							<ul class="thumbnails" id="itemContainer">
								<c:forEach items="${srchedPrdct}" var="item">
									<c:forEach items="${buyingDetails}" var="item1">

										<c:set var="auction" value="${item1.productId}" />
										<c:set var="product" value="${item.idProduct}" />

										<c:if test="${(auction == product)}">

											<li class="span3">
												<div class="thumbnail">
													<!-- forward to product_detail.jsp -->
													<a href="product_details.html"> <!-- 													<img src="themes/images/products/3.jpg" alt=""/> -->
														<c:set var="flag" value="0" scope="page" /> <c:forEach
															items="${images}" var="item3">
															<c:forEach items="${description}" var="item4">
																<c:set var="desc" value="${item4.idDescription}" />
																<c:set var="image" value="${item3.descriptionId}" />
																<c:if test="${(desc == image) && flag != 1}">
																	<img src="${item3.path}" alt="" />
																	<c:set var="flag" value="${flag + 1}" scope="page" />
																</c:if>
															</c:forEach>
														</c:forEach>
													</a>
													<div class="caption">
														<h5>
															<c:out value="${item.name}" />
														</h5>
														<p>For details. Click here</p>
														<h4 style="text-align: center">
															<a class="btn" href="#">Add to <i
																class="icon-shopping-cart"></i> <!-- forward to product_detail.jsp -->
															</a> <a class="btn btn-primary" href="#">$
																${item1.currentPrice}</a>
														</h4>
														<!-- get price of the product from DB -->
													</div>
												</div>
											</li>

										</c:if>
									</c:forEach>
								</c:forEach>
							</ul>
							<hr class="soft" />
						</div>
					</div>

					<div class="holder pagination light-theme simple-pagination">
					</div>

					<br class="clr" />

				</div>
			</div>
		</div>
	</div>

</body>
</html>