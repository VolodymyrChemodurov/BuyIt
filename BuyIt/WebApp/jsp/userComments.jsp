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
				<li><a href="userShoppingServlet">Shopping</a></li>
				<li	id="active"><strong>Comments</strong></li>
				<li><a href="userAddProductServlet">Product</a></li>
			</ul>
			<!-- / #vMenu -->
			<div style="overflow: hidden;">
				<div width="200" class="left-menu">
					<ul class="nav nav-list" id="shoppingTabs">
						<li class="nav-header">Comments</li>
						<li class="active"><a href="#">For me</a></li>
					</ul>
				</div>
				<!-- /left-menu -->

				<div id="maContent" class="corAll5">
					<div id="commentsForMe">
						<c:if test="${empty userComments}">
							<h1 style="text-align: center;">Sorry, but enybody didn't leave comment for you!</h1>
						</c:if>
						<c:if test="${not empty userActiveShopping}">
							<h1>Massages leave for you</h1>
							<div id="table-wrapper">
							<div id="table-scroll">
							<table class="table table-striped">
								<thead>
									<tr>
										<th><span class="text">From who</span></th>
										<th><span class="text">Message</span></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="message" items="${userComments}">
										<tr>
											<td><a href="user_wall?id=${message.fromUserId}"> 
											<c:forEach var="userTemp" items="${users}">
												<c:if test="${userTemp.idUser == message.fromUserId}">
													<c:out value="${userTemp.login}"></c:out>  
												</c:if>
											</c:forEach>
											
											
											</a></td>
											<td>${message.message}</td>
																					

										</tr>
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
</body>
</html>
