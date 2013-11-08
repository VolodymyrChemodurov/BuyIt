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
						<li><a href="index">Home</a> <span class="divider">/</span></li>
						<li class="active">Registration</li>
					</ul>
					<h3>Registration</h3>
					<div class="well">
						<form class="form-horizontal" method="post" id="registration-form"
							action="registrationServlet">
							<h4>Your personal information</h4>
							<div class="control-group">
								<label class="control-label" for="alogin">Login <b style="color:red">*</b></label>
								<div class="controls">
									<input type="text" id="alogin" name="login" placeholder="Login"
										class="tip" data-toggle="tooltip" data-placement="right" maxlength="15"
										title="More then 4 characters Only number, small letters and dashes">
									<div id="logindiv"></div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstName">First name <b style="color:red">*</b>
								</label>
								<div class="controls">
									<input type="text" id="firstName" name="firstName"
										placeholder="First Name" class="tip" data-toggle="tooltip" maxlength="15"
										data-placement="right" title="More than 2 characters">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="lastName">Last name <b style="color:red">*</b></label>
								<div class="controls">
									<input type="text" id="lastName" name="lastName" maxlength="15"
										placeholder="Last Name" class="tip" data-toggle="tooltip"
										data-placement="right" title="More than 3 characters">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="email">Email <b style="color:red">*</b></label>
								<div class="controls">
									<input type="text" id="email" name="email" maxlength="25" placeholder="Email">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="phone">Phone <b style="visibility: collapse;">*</b></label>
								<div class="controls">
									<input type="text" id="phone" name="phone" maxlength="10" value="" placeholder="Phone"
										class="tip" data-toggle="tooltip" data-placement="right"
										title="Yours phone number (10 digits)">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">Password <b style="color:red">*</b></label>
								<div class="controls">
									<input type="password" id="password2" name="password" maxlength="15"
										placeholder="Password" class="tip" data-toggle="tooltip"
										data-placement="right"
										title="More then 6 characters. Only numbers, small letters and dashes">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="confirmPassword">Confirm
									Password <b style="color:red">*</b></label>
								<div class="controls">
									<input type="password" id="confirmPassword2" maxlength="15"
										name="confirmPassword" placeholder="Confirm Password"
										class="tip" data-toggle="tooltip" data-placement="right"
										title="Confirm your password">
								</div>
							</div>

							<h4>Your address</h4>

							<div class="control-group">
								<label class="control-label" for="region">State <b style="visibility: collapse;">*</b></label>
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
								<label class="control-label" for="city">City <b style="visibility: collapse;">*</b></label>
								<div class="controls">
									<input type="text" id="city" maxlength="15"
										name="city" placeholder="City" class="tip"
										data-toggle="tooltip" data-placement="right"
										title="Please enter your city">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="street">Street <b style="visibility: collapse;">*</b></label>
								<div class="controls">
									<input type="text" id="street" name="street" maxlength="15"
										placeholder="Street" class="tip" data-toggle="tooltip"
										data-placement="right" title="Please enter your street">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="house">House № <b style="visibility: collapse;">*</b></label>
								<div class="controls">
									<input type="text" id="house" name="house" maxlength="4"
										placeholder="House number">
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="flat">Flat № <b style="visibility: collapse;">*</b></label>
								<div class="controls">
									<input type="text" id="flat" name="flat" maxlength="4"
										placeholder="Flat number">
								</div>
							</div>
							

							<div class="control-group">
								<label class="control-label" for="zipCode">Zip Code <b style="visibility: collapse;">*</b></label>
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
