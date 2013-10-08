<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<html>
<head>
<meta charset="utf-8">
<title>BuyIt</title>
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

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen">
<link href="themes/css/base.css" rel="stylesheet" media="screen">
<!-- Bootstrap style responsive -->
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
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<!-- Sidebar ================================================== -->
				<jsp:include page="sidebarMenu"></jsp:include>
				<!-- Sidebar end=============================================== -->
				<div class="span9">
					<ul class="breadcrumb">
						<li><a href="homePageServlet">Home</a> <span class="divider">/</span></li>
						<li class="active"><c:out value="${subCategory.name}"></c:out></li>
					</ul>


					<h3>
						<c:out value="${subCategory.name}"></c:out>
					</h3>
					<div class="item">
						<ul class="thumbnails">
							<c:forEach begin="${requestScope.number}" end="${requestScope.number + 1}" var="current">
								<c:set var="product" 
								value="${subCategory.products[current]}" scope="request"></c:set>
								<jsp:include page="item_preview"></jsp:include>
							</c:forEach>
						</ul>
					</div>					
					
					<a href="category?number=${current - 1}">PREV</a>
					<a href="category?number=${current + 1}/>">NEXT</a>

				</div>
			</div>
		</div>
		<!-- MainBody End ============================= -->
		<!-- Footer ================================================================== -->
		<div id="footerSection">
			<div class="container">
				<div class="row">
					<div class="span3">
						<h5>ACCOUNT</h5>
						<a href="login.html">YOUR ACCOUNT</a> <a href="login.html">PERSONAL
							INFORMATION</a> <a href="login.html">ADDRESSES</a> <a
							href="login.html">DISCOUNT</a> <a href="login.html">ORDER
							HISTORY</a>
					</div>
					<div class="span3">
						<h5>INFORMATION</h5>
						<a href="contact.html">CONTACT</a> <a href="register.html">REGISTRATION</a>
						<a href="legal_notice.html">LEGAL NOTICE</a> <a href="tac.html">TERMS
							AND CONDITIONS</a> <a href="faq.html">FAQ</a>
					</div>
					<div class="span3">
						<h5>OUR OFFERS</h5>
						<a href="#">NEW PRODUCTS</a> <a href="#">TOP SELLERS</a> <a
							href="special_offer.html">SPECIAL OFFERS</a> <a href="#">MANUFACTURERS</a>
						<a href="#">SUPPLIERS</a>
					</div>
					<div id="socialMedia" class="span3 pull-right">
						<h5>SOCIAL MEDIA</h5>
						<a href="#"><img width="60" height="60"
							src="themes/images/facebook.png" title="facebook" alt="facebook"></a>
						<a href="#"><img width="60" height="60"
							src="themes/images/twitter.png" title="twitter" alt="twitter"></a>
						<a href="#"><img width="60" height="60"
							src="themes/images/youtube.png" title="youtube" alt="youtube"></a>
					</div>
				</div>
				<p class="pull-right">© Bootshop</p>
			</div>
			<!-- Container End -->
		</div>
		<!-- Placed at the end of the document so the pages load faster ============================================= -->
		<script src="themes/js/jquery.js" type="text/javascript"></script>
		<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="themes/js/google-code-prettify/prettify.js"></script>
		<script src="bootstrap/js/login-check.js" type="text/javascript"></script>
		<script src="themes/js/bootshop.js"></script>
		<script src="bootstrap/js/bootstrap-tooltip.js"></script>
		<script src="themes/js/jquery.lightbox-0.5.js"></script>
		<script src="bootstrap/js/tooltip.js" type="text/javascript"></script>
</body>
</html>
