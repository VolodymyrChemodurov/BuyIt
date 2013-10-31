<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en">
<title>BuyIt</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap style -->

<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen">
<link href="themes/css/base.css" rel="stylesheet" media="screen">
<!-- Bootstrap style responsive -->
<link href="bootstrap/css/adminpage.css" rel="stylesheet">
<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="themes/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<!-- Google-code-prettify -->
<link href="themes/js/google-code-prettify/prettify.css"
	rel="stylesheet">
<!-- fav and touch icons -->
<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<style type="text/css" id="enject"></style>
<script src="themes/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("button").each(function() {
			if (this.id == "banned") {
				this.disabled = true;
				this.type = "hidden";
			}
			;
			if (this.id == "uunbanned") {
				this.disabled = true;
				this.type = "hidden";
			}
			;
		});
	});
</script>
</head>

<body data-spy="scroll" data-target=".navbar">
	<jsp:include page="navbar"></jsp:include>

	<div class="container">
		<div id="maWrapper" class="corAll5">
			<ul id="vMenu">
				<li id="active"><strong>Ban Users</strong></li>
				<li><a href="categoryCreator">Create Category</a></li>
				<li><a href="adminRegistration">Register Administrator</a></li>
				<li><a href="adminProfile">Profile</a></li>
			</ul>
			<!-- / #vMenu -->
			<!-- 			<div style="overflow: hidden;"> -->
			<!-- 				<div width="200" class="left-menu"> -->
			<!-- 					<div class="avatar-wrapper"> -->
			<%-- 						<img src="${user.avatar}"> --%>
			<!-- 					</div> -->
			<!-- 				</div> -->

			<div width="200" class="left-menu">
				<div class="avatar-wrapper">
					<img src="${user.avatar}">
				</div>
			</div>

			<!-- /left-menu -->

			<div id="maContent" class="corAll5">

				<h2>General information about users</h2>
				<div id="table-wrapper">
					<div id="table-scroll">
						<table class="table table-striped">
							<thead>
								<tr>
									<th><span class="text">First Name</span></th>
									<th><span class="text">Last Name</span></th>
									<th><span class="text">Status</span></th>
									<th><span class="text">City</span></th>
									<th><span class="text">Phone</span></th>
									<th><span class="text">Email</span></th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${onlyUsers}" var="user">

									<tr>
										<td><c:out value="${user.firstName}"></c:out></td>
										<td><c:out value="${user.lastName}"></c:out></td>
										<td><c:out value="${user.ban}"></c:out></td>
										<td><c:out value="${user.contact.address.city}"></c:out>
										</td>
										<td><c:out value="${user.contact.phone}"></c:out></td>
										<td><c:out value="${user.contact.email}"></c:out></td>
										<td>
											<form method="post" action="adminPageServlet">
												<input type="hidden" value="${user.idUser}" name="idUsr" />
<!-- 												<input class="btn btn-success" style="width:60px; padding: 0 4px 0 4px;" -->
<%-- 													id="${user.ban}" type="submit" name="button" value="bann" /> --%>
												<button class="btn btn-success" style="width:60px; padding: 0 4px 0 4px;"
													id="${user.ban}" type="submit" name="button" value="bann" >bann</button>
												<input type="hidden" value="${user.idUser}" name="idUsr" />
<!-- 												<input class="btn btn-danger" style="width:60px; padding: 0 4px 0 4px;" -->
<%-- 													id="u${user.ban}" type="submit" name="button" --%>
<!-- 													value="unbann" /> -->
												<button class="btn btn-danger" style="width:60px; padding: 0 4px 0 4px;"
													id="u${user.ban}" type="submit" name="button"
													value="unbann">unbann</button>
											</form>
										</td>
									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>



			</div>

			<!-- 				/maContent -->
		</div>
	</div>


	<div style="height: 30px;"></div>



	<jsp:include page="footer"></jsp:include>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
</body>
</html>