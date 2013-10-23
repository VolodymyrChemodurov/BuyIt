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
<link href="themes/css/item-preview.css" rel="stylesheet">
<style>
#table-scroll {
	height: 400px;
	overflow: auto;
	margin-top: 20px;
	border: 1px solid #ddd;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.055);
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.055);
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.055);
	-webkit-transition: all .2s ease-in-out;
	-moz-transition: all .2s ease-in-out;
	-o-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
	background: #fff;
	position: relative;
	border: 1px solid #eee;
}
</style>
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

					<div class="row">
						<div class="span2">
							<div class="thumbnail">
								<img src="${userInfo.avatar}">
							</div>
						</div>
						<div class="span7">
							<legend>User information</legend>
							<span class="label label-info">First name: ${userInfo.firstName}</span> 
							<span class="label label-info">Last name: ${userInfo.lastName}</span>
							<span class="label label-info">e-mail: ${userInfo.contact.email}</span>
							
							<row>
								<form class="form-inline" action="#" method="POST">
									<legend>You can leave your message here</legend>
									<input type="text" style='width: 85%' class="input-small"
										placeholder="Message">
									<button type="submit" style='width: 10%' class="btn btn-primary">Leave</button>
								</form>
							</row>

						</div>
					</div>

					<div class="row">
						<div class="span9">
							<div id="table-scroll">
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<th>From</th>
											<th>Message</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${messages}" var="message">
											<tr>
												<td style="width: 20%"><a href="user_wall?id=${message.key.idUser}" class="btn btn-link"/>user${message.key.login}</td>
												<td>${message.value.message}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

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