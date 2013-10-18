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
			<hr class="soften">
			<h2>Contact Details</h2>
			<hr class="soften">
			<div class="row">
				<div class="span4">
					<p>
						buyitinternetauction@gmail.com<br> ﻿Tel 123-456-6780<br>
						Fax 123-456-5679<br> web:buyit.com
					</p>
				</div>

				<div class="span4">
					<h4>Managers</h4>
					<hr class="soften">
					<h5>Chemodurov Volodymyr</h5>
					<p>
						098-266-81-76<br>
					</p>
					<h5>Reka Andrii</h5>
					<p>
						097-606-50-09<br>
					</p>
					<h5>Gupalo Oleg</h5>
					<p>
						096-381-96-48<br>
					</p>
					<h5>Doroshenko Maksym</h5>
					<p>
						098-463-02-50<br>
					</p>
					<h5>Lobachov Pavlo</h5>
					<p>
						063-654-02-29<br>
					</p>
				</div>
				<div class="span4">
					<h4>Email Us</h4>
					<form class="form-horizontal" action=emailUs method="post">

						<fieldset>
							<div class="control-group">

								<input type="text" placeholder="subject" class="input-xlarge"
									name="subject">

							</div>
							<div class="control-group">
								<textarea rows="3" id="textarea" placeholder="your message"
									class="input-xlarge" name="message"></textarea>

							</div>

							<button class="btn btn-large" type="submit">Send Message</button>

						</fieldset>

					</form>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer"></jsp:include>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
	<script src="bootstrap/js/search.js"></script>

</body>
</html>