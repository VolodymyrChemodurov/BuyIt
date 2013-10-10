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
		<ul class="nav nav-tabs">
			<li class="active" style="margin-left: 6px"><a href="#"><b>Profile</b></a></li>
			<li><a href="#"><b>Sales</b></a></li>
			<li><a href="#"><b>Shopping</b></a></li>
			<li><a href="#"><b>Comments</b></a></li>
		</ul>
		<div class="row">
			<span class="inner-left-menu"> asdasdasdasd asdasdas
				dasdasdsad asdasasd asdasdddddddddddddddd asdddddddddddddddddddddd
				asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd </span>
		</div>
	</div>
<div class="container">
	<div id="maWrapper" class="corAll5">
		<ul id="vMenu">
			<li id="active"><strong>Profile</strong></li>
			<li><a href="#">Salles</a></li>
			<li><a href="#">Shopping</a></li>
			<li><a href="#">Comments</a></li>
		</ul>
		<!-- / #vMenu -->
		<div style="overflow: hidden;">
			<div width="200" class="left-menu">
				<ul class="navs" id="navs">
					<li id="navs-1-1" class="current"><big>Аукционы и Купить
							сейчас! <span class="status_icon"></span>
					</big>
						<ul>
							<li class="active"><a href="/myaccount/bid.php">Действующие</a></li>
							<li><a href="/myaccount/won.php">Куплено</a></li>
							<li><a href="/myaccount/notwon.php">Не куплено</a></li>
							<li><a href="/myaccount/payu/MyPayments.php">Список моих
									платежей</a></li>
							<li><a href="/myaccount/Debates/alert.php">Предупреждения
									по сделкам</a></li>
							<li class="jump"><a href="/myaccount/feedbacks/add.php">Отзывы</a></li>
						</ul></li>
					
				</ul>
			</div>
			<!-- /left-menu -->




			<div id="maContent" class="corAll5">
				<h2 class="themeHead tmp-cz-color">Список лотов со ставками</h2>
				<div class="paddingContent">

					<div class="table-msg">
						<table align="center" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td class="totop"><img
										src="http://static.allegrostatic.pl/site_images/209/0/common/msg.gif"
										alt="" width="30" height="30" class="displayBlock"></td>
									<td class="tomiddle">
										<div class="msg">
											<b>В настоящее время вы не принимаете участия в торгах ни
												по одному из лотов</b>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="rgTopPosition">
						<div class="recommendedGalleryWrapper"></div>
					</div>




				</div>
				<!--/paddingContent -->


			</div>
			<!-- /maContent -->
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

</body>
</html>