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

<link href="themes/assets/css/assets_style.css" rel="stylesheet">

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
						<li class="active">Registration</li>
					</ul>
					<h3>Registration</h3>
					<div class="well">
						<!--
	<div class="alert alert-info fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	<div class="alert fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	 <div class="alert alert-block alert-error fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div> -->
						<form class="form-horizontal" method="post" id="registration-form"
							action="registrationServlet">
							<h4>Your personal information</h4>
							<div class="control-group">
								<label class="control-label" for="alogin">Login </label>
								<div class="controls">
									<input type="text" id="alogin" name="login" placeholder="Login"
										class="tip" data-toggle="tooltip" data-placement="right" maxlength="15"
										title="More then 4 characters Only number, small letters and dashes">
									<div id="logindiv"></div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstName">First name
								</label>
								<div class="controls">
									<input type="text" id="firstName" name="firstName"
										placeholder="First Name" class="tip" data-toggle="tooltip" maxlength="15"
										data-placement="right" title="More than 2 characters">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="lastName">Last name </label>
								<div class="controls">
									<input type="text" id="lastName" name="lastName" maxlength="15"
										placeholder="Last Name" class="tip" data-toggle="tooltip"
										data-placement="right" title="More than 3 characters">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="email">Email </label>
								<div class="controls">
									<input type="text" id="email" name="email" maxlength="25" placeholder="Email">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="phone">Phone </label>
								<div class="controls">
									<input type="text" id="phone" name="phone" maxlength="10" placeholder="Phone"
										class="tip" data-toggle="tooltip" data-placement="right"
										title="Yours phone number (10 digits)">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">Password </label>
								<div class="controls">
									<input type="password" id="password2" name="password" maxlength="15"
										placeholder="Password" class="tip" data-toggle="tooltip"
										data-placement="right"
										title="More then 6 characters. Only numbers, small letters and dashes">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="confirmPassword">Confirm
									Password </label>
								<div class="controls">
									<input type="password" id="confirmPassword2" maxlength="15"
										name="confirmPassword" placeholder="Confirm Password"
										class="tip" data-toggle="tooltip" data-placement="right"
										title="Confirm your password">
								</div>
							</div>

							<h4>Your address</h4>

							<div class="control-group">
								<label class="control-label" for="region">State</label>
								<div class="controls">
									<select id="region" name="region">
										<option value="">-</option>
										<c:forEach var="current" items="${region}">
											<option value="${current}">${current}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="city">City</label>
								<div class="controls">
									<input type="text" id="city" maxlength="15"
										name="city" placeholder="City" class="tip"
										data-toggle="tooltip" data-placement="right"
										title="Please enter your city">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="street">Street</label>
								<div class="controls">
									<input type="text" id="street" name="street" maxlength="15"
										placeholder="Street" class="tip" data-toggle="tooltip"
										data-placement="right" title="Please enter your street">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="house">House №</label>
								<div class="controls">
									<input type="text" id="house" name="house" maxlength="4"
										placeholder="House number">
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="flat">Flat №</label>
								<div class="controls">
									<input type="text" id="flat" name="flat" maxlength="4"
										placeholder="Flat number">
								</div>
							</div>
							

							<div class="control-group">
								<label class="control-label" for="zipCode">Zip Code</label>
								<div class="controls">
									<input type="text" id="zipCode" name="zipCode" maxlength="5"
										placeholder="Zip Code" class="tip" data-toggle="tooltip"
										data-placement="right" title="Enter zip code (5 digits)">
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<button class="btn btn-large btn-success" type="submit"
										id="register">Register</button>
								</div>
							</div>
							</fieldset>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<jsp:include page="footer"></jsp:include>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->


	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="bootstrap/js/login-check.js" type="text/javascript"></script>
	<script src="bootstrap/js/tip.js" type="text/javascript"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
	<script src="themes/assets/js/jquery.validate.js"></script>
	<script src="http://jquery.bassistance.de/validate/additional-methods.js"></script>
	<script src="themes/assets/js/script.js"></script>
	<script src="bootstrap/js/search.js"></script>

</body>
</html>
