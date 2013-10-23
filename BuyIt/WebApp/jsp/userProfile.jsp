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
<link href="themes/assets/css/assets_style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="navbar"></jsp:include>
	<!-- Header End====================================================================== -->

	<div id="userProfile-container" class="container">
		<div id="maWrapper" class="corAll5">
			<ul id="vMenu">
				<li id="active"><strong>Profile</strong></li>
				<li><a href="userSalesServlet">Sales</a></li>
				<li><a href="userShoppingServlet">Shopping</a></li>
				<li><a href="#">Comments</a></li>
				<li><a href="userAddProductServlet">Product</a></li>
			</ul>
			<!-- / #vMenu -->
			<div style="overflow: hidden;">
				<div width="200" class="left-menu">
					<div class="avatar-wrapper">
						<img src="${user.avatar}">
					</div>
					<a style="color:white; padding-left: 20px;"><i class="icon-user"></i>Change avatar</a>
					<br>
					<a onclick="showPasswordBlock()" id="passwordLink"style="color:white; padding-left: 20px;"><i class="icon-user"></i>Change password</a>
					<div id="changePasswordBlock" style="display:none;">
						<form action="changePasswordServlet" method="post">
							<span style="color:green; font-size: 14px;">Change password block</span>
							<input id="login" style="display: none; color:green;" name="login" value="${user.login}"/>
							<input id="oldPassword" type="password" placeholder="Old password" name="oldPassword"/>
							<input id="newPassword" type="password" placeholder="New password" name="newPassword"/>
							<input id="confirmPassword" type="password" placeholder="Confirm password" name="confirmPassword"/>
							<div id="passwordChangeResult" style="display: none; color:green;"><b>Password changed</b></div>
							<button id="passwordBlockApply" type="submit" style="width: 92px; margin-top:2px;" class="btn btn-success">Apply</button>
							<button id="passwordBlockCancel"style="width: 92px; margin-top:2px;" class="btn btn-danger">Cancel</button>
						</form>
					</div>	
						
				</div>
				<!-- /left-menu -->




				<div id="maContent" class="corAll5">
					<div class="mycontent">
						<h3>General information</h3>
						<div class="myrow">
							<span class="span-1">First Name:</span> <span class="span-2"><c:out
									value="${user.firstName}"></c:out></span>
						</div>
						<div class="myrow">
							<span class="span-1">Last Name:</span> <span class="span-2"><c:out
									value="${user.lastName}"></c:out></span>
						</div>
						<div class="myrow">
							<span class="span-1">Role:</span> <span class="span-2"><c:out
									value="${user.ban}"></c:out></span>
						</div>
						<h3>Address</h3>
						<div class="myrow">
							<span class="span-1">City:</span> <span class="span-2"><c:out
									value="${user.contact.address.city}"></c:out></span>
						</div>
						<div class="myrow">
							<span class="span-1">Region:</span> <span class="span-2"><c:out
									value="${user.contact.address.region}"></c:out> obl</span>
						</div>
						<div class="myrow">
							<span class="span-1">Street</span> <span class="span-2"><c:out
									value="${user.contact.address.street}"></c:out></span>
						</div>
						<div class="myrow">
							<span class="span-1">House / Flat</span>
							<c:if test="${user.contact.address.flat eq ''}">
								<span class="span-2"><c:out
										value="${user.contact.address.house}"></c:out></span>
							</c:if>
							<c:if test="${user.contact.address.flat != ''}">
								<span class="span-2"><c:out
										value="${user.contact.address.house.concat('/').concat(user.contact.address.flat)}"></c:out></span>
							</c:if>
						</div>


						<div class="myrow">
							<span class="span-1">Zip Code</span> <span class="span-2"><c:out
									value="${user.contact.address.zipCode}"></c:out></span>
						</div>
						<h3>Contacts</h3>
						<div class="myrow">
							<span class="span-1">Phone:</span> <span class="span-2"><c:out
									value="${user.contact.phone}"></c:out></span>
						</div>
						<div class="myrow">
							<span class="span-1">Email:</span> <span class="span-2"><c:out
									value="${user.contact.email}"></c:out></span>
						</div>


					</div>
					<div id="right-menu" class="my-right-content">
						<div id="image-container" style="display: block">
							<img id="userEditImage" src="bootstrap/img/edit.png" />
						</div>
						<div id="form-container" style="display: none">
							<form action="userPageServlet" method="post">
								<div class=myrow style="padding-top: 40px;">
									<span class="span-2"><input id="firstName" name="firstName"
										value="${user.firstName}" /> </span>
								</div>
								<div class=myrow>
									<span class="span-2"><input name="lastName"
										value="${user.lastName}" /> </span>
								</div>
								<div class=myrow style="padding-top: 70px;">
									<span class="span-2"><input name="city"
										value="${user.contact.address.city}" />
									</span>
								</div>
								<div class=myrow>
									<span class="span-2">
										<select id="region" name="region">
											<option value="${user.contact.address.region}">${user.contact.address.region}</option>
											<c:forEach var="current" items="${region}">
												<c:if test="${user.contact.address.region != current}">
													<option value="${current}">${current}</option>
												</c:if>
											</c:forEach>
										</select>
									</span>
								</div>
								<div class=myrow>
									<span class="span-2"><input name="street"
										value="${user.contact.address.street}" /> </span>
								</div>
								<div class=myrow>
									<span class="span-2"><input name="house"
										style="width: 85px;" value="${user.contact.address.house}" />
									</span> <span class="span-2"><input name="flat"
										style="width: 86px;" value="${user.contact.address.flat}" />
									</span>
								</div>
								<div class=myrow>
									<span class="span-2"><input name="zipCode"
										value="${user.contact.address.zipCode}" /> </span>
								</div>
								<div class=myrow style="padding-top: 40px;">
									<span class="span-2"><input name="phone"
										value="${user.contact.phone}" /> </span>
									<button type="submit" style="margin-left: 40px; width: 120px;"
										class="btn btn-mini btn-success">Apply changes</button>
								</div>
								<div class=myrow>
									<span class="span-2"><input name="email"
										value="${user.contact.email}" /> </span> <button
										id="btn-back" style="margin-left: 40px; width: 120px;"
										class="btn btn-mini btn-danger" >Cancel	</button>
								</div>
							</form>
						</div>
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
	<script src="themes/assets/js/jquery.validate.js"></script>
	<script src="http://jquery.bassistance.de/validate/additional-methods.js"></script>
	<script src="themes/assets/js/update.validate.js"></script>
	<script src="bootstrap/js/userPage.js"></script>
	<script src="bootstrap/js/search.js"></script>
</body>
</html>
