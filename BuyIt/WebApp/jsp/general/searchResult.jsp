<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<link type="text/css" rel="stylesheet"
	href="themes/css/pagination/jPages.css">

<style type="text/css" id="enject"></style>

</head>

<body>
	<jsp:include page="navbar"></jsp:include>
	<div id="mainBody">
		<div class="container">
			<div class="row">

				<jsp:include page="sidebarMenu"></jsp:include>
				<div class="span9">

					<h3>
						Search result <small class="pull-right">
							${aviliablePrdcts} products are available </small>
					</h3>

					<hr class="soft" />

					<!-- <div id="myTab" class="pull-right">
						<a href="#listView" data-toggle="tab"><span
							class="btn btn-large"><i class="icon-list"></i></span></a> <a
							href="#blockView" data-toggle="tab"><span
							class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
					</div> -->

					<br class="clr" />

					<div class="tab-content">
						<div class="tab-pane active" id="blockView">
							<ul class="thumbnails" id="itemContainer">
								<c:forEach items="${srchedPrdct}" var="product">

									<li class="span3 box">
										<div class="thumbnail">
											<!-- Image of product -->
											<c:choose>
												<c:when
													test="${fn:length(product.description.itemPhotos) eq 0}">
													<a href="productDetails?id=${product.idProduct}"> <img
														class="my-image" style="height: 150px"
														src="<c:out value="themes/images/mocks/noAvailablePhoto.jpg"></c:out>">
													</a>
												</c:when>
												<c:otherwise>
													<a href="productDetails?id=${product.idProduct}"> <img
														style="height: 150px"
														src="<c:out value="${product.description.itemPhotos[0].path }"></c:out>" />
													</a>
												</c:otherwise>
											</c:choose>

											<!-- Image of product -->
											<div class="caption">
												<h5>
													<c:choose>
														<c:when test="${fn:length(product.name) < 25}">
															<c:out value="${product.name}"></c:out>
														</c:when>
														<c:when test="${fn:length(product.name) >= 25}">
															<c:out value="${fn:substring(product.name, 0, 22)}..."></c:out>
														</c:when>
													</c:choose>
												</h5>
												<p>For details. Click here</p>
												<h4 style="text-align: center">
													<c:choose>
														<c:when test="${product.auction.buyItNow  <= 0}">
															<a class="btn btn-info" 
																<c:if test="${user.idUser eq product.userId}">
                                                					style="pointer-events: none; cursor: default; disabled: disabled" disabled tabindex=-1
                                                				</c:if> 
																href="bid_serve?id_product=${product.idProduct}&bid=${product.auction.currentPrice + 1}"> 
						                                    	Bid ${product.auction.currentPrice}$
						                                    </a>
						                                </c:when>
														<c:when test="${product.auction.currentPrice <= 0}">
															<a class="btn btn-info"
																<c:if test="${user.idUser eq product.userId}">
                                                					style="pointer-events: none; cursor: default; disabled: disabled" disabled tabindex=-1
                                                				</c:if> 
																href="buyItServe?id_product=${product.idProduct}&quantity=1"">
						                                        Buy ${product.auction.buyItNow}$
						                                    </a>
						                                </c:when>
														<c:otherwise>
															<a class="btn btn-info"
																<c:if test="${user.idUser eq product.userId}">
                                                					style="pointer-events: none; cursor: default; disabled: disabled" disabled tabindex=-1
                                                				</c:if> 
																href="buyItServe?id_product=${product.idProduct}&quantity=1"">
						                                       	Buy ${product.auction.buyItNow}$
						                                    </a>
						                                </c:otherwise>
													</c:choose>
												</h4>
												<!-- get price of the product from DB -->
											</div>
										</div>
									</li>

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
	<jsp:include page="footer"></jsp:include>
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
	<script src="bootstrap/js/search.js"></script>
	<script type="text/javascript"
		src="themes/js/pagination/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
		src="themes/js/pagination/highlight.pack.js"></script>
	<script src="themes/js/pagination/jPages.js"></script>
	<script src="themes/js/pagination/js.js"></script>
	<script type="text/javascript" src="themes/js/pagination/tabifier.js"></script>

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


</body>
</html>