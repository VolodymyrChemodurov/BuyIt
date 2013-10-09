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
						<form class="form-horizontal" method="post"
							action="registrationServlet">
							<h4>Your personal information</h4>
							<div class="control-group">
								<label class="control-label" for="alogin">Login </label>
								<div class="controls">
									<input type="text" id="alogin" name="login" placeholder="Login"
										value="aleg" class="tip"  data-toggle="tooltip" data-placement="right"
										title="Login contains only number, small letters and '-' '_'">
									<div id="logindiv"></div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstName">First name
								</label>
								<div class="controls">
									<input type="text" id="firstName" name="firstName"
										placeholder="First Name" value="Aleg">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="lastName">Last name </label>
								<div class="controls">
									<input type="text" id="lastName" name="lastName"
										placeholder="Last Name" value="Gupalo">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="email">Email </label>
								<div class="controls">
									<input type="text" id="email" name="email" placeholder="Email"
										value="aleg@qw.com">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="phone">Phone </label>
								<div class="controls">
									<input type="text" id="phone" name="phone" placeholder="Phone"
										value="1234567897">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">Password </label>
								<div class="controls">
									<input type="password" id="password" value="alegaleg"
										name="password" placeholder="Password">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="confirmPassword">Confirm
									Password </label>
								<div class="controls">
									<input type="password" id="confirmPassword"
										name="confirmPassword" placeholder="Confirm Password"
										value="alegaleg">
								</div>
							</div>

							<h4>Your address</h4>

							<div class="control-group">
								<label class="control-label" for="region">State</label>
								<div class="controls">
									<select id="region" name="region">
										<option value="">-</option>
										<option value="1">Vinnucka</option>
										<option value="2">Volunska</option>
										<option value="3">Dnipropetrovska</option>
										<option value="4">Donetska</option>
										<option value="5">Jutomirska</option>
										<option value="6">Zakarpatska</option>
										<option value="7">Zaporizka</option>
										<option value="8">Ivano-Frankivska</option>
										<option value="9">Kyivska</option>
										<option value="10">Kirovogradska</option>
										<option value="11">Krum</option>
										<option value="12">Lyganska</option>
										<option value="13">Lvivska</option>
										<option value="14">Mukolaivska</option>
										<option value="15">Odeska</option>
										<option value="16">Poltavska</option>
										<option value="17">Rivnenska</option>
										<option value="18">Symska</option>
										<option value="19">Ternopilska</option>
										<option value="20">Kharkivska</option>
										<option value="21">Khersonska</option>
										<option value="22">Khmelnutska</option>
										<option value="23">Sherkaska</option>
										<option value="24">Shernigivska</option>
										<option value="25">Shernivetska</option>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="city">City</label>
								<div class="controls">
									<input onclick="newTooltip();" type="text" id="city" name="city" placeholder="City"
										value="Lviv">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="street">Street</label>
								<div class="controls">
									<input type="text" id="street" name="street"
										placeholder="Street" value="Alegaleg">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="house">House № / Flat
									№</label>
								<div class="controls">
									<input type="text" style="width: 85px;" id="house" name="house"
										placeholder="House number" value="1">
									&nbsp;&nbsp;/&nbsp; <input type="text" style="width: 85px;"
										id="house" name="house" placeholder="Flat Number" value="1">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="zipCode">Zip Code</label>
								<div class="controls">
									<input type="text" id="zipCode" name="zipCode"
										placeholder="Zip Code" value="12345">
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
	<script src="bootstrap/js/tip.js" type="text/javascript"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>

</body>
</html>
