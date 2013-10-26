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
<link href="bootstrap/css/userpage.css" rel="stylesheet">
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
							<div class="thumbnail" style="text-align:center">
								<img src="${userInfo.avatar}">
								<input type="number" name="myrating" id="myrating" class="rating" value="${userRating}"/>
								
								<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  									<div class="modal-header">
    									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    									<h3 id="myModalLabel">Success</h3>
  									</div>
  									<div class="modal-body">
    									<p>Martin thanks you for adding rating!</p>
    									<p id="add"></p>
    									<p id="current"></p>
  									</div>
  									<div class="modal-footer">
    									<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
  									</div>
								</div>
							</div>
						</div>
						<div class="span7">
							<legend>${userInfo.login} information</legend>
							<span class="label label-info">Full name: ${userInfo.firstName} ${userInfo.lastName}</span> 
							<span class="label label-info">e-mail: ${userInfo.contact.email}</span>
							<c:if test="${userInfo.idUser ne user.idUser}">
							<row>
								<form class="form-inline" action="leave_message" method="POST">
									<legend>You can leave your message here</legend>
									<input type="text" style='width: 85%' class="input-small"
										placeholder="Message" name="message">
									<input type="hidden" id="fromId" name="fromId" value="${user.idUser}">
									<input type="hidden" id="id" name="toId" value="${userInfo.idUser}">
									<button type="submit" style='width: 10%' class="btn btn-primary">Leave</button>
								</form>
							</row>
							</c:if>
						</div>
					</div>

					<div class="row" style="padding-top: 20px">
						<div class="span9">
							<div id="table-wrapper">
								<div id="table-scroll">
									<table class="table table-striped table-hover">
										<thead>
											<tr>
												<th><span class="text">From</span></th>
												<th><span class="text">Message</span></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${messages}" var="message">
												<tr>
													<td style="width: 20%"><a href="user_wall?id=${message.key.idUser}" class="btn btn-link"/>${message.key.login}</td>
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
	</div>


	<jsp:include page="footer"></jsp:include>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
	<script src="bootstrap/js/search.js"></script>
	<script src="bootstrap/js/bootstrap-rating-input.min.js" type="text/javascript"></script>
	<script src="bootstrap/js/add-rating.js"></script>
</body>
</html>