<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

<style>
	thead { display:block; margin:0px; cell-spacing:0px; left:0px; }
	tbody { display:block; overflow:auto; height:200px; }
	th { height:50px; width:60px; }
	td { height:50px; width:80px; margin:0px; cell-spacing:0px;}
</style>

<script src="themes/js/jquery.js" type="text/javascript"></script>

<script type="text/javascript">


$( document ).ready(function() {
	$("input").each(function(){
		if(this.id == "banned"){
			this.disabled = true; 
			this.type = "hidden";
			};
		if(this.id == "uunbanned"){
			this.disabled = true; 
			this.type = "hidden";
			};
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
					<div class="table table-striped" id="navbar">
					<!-- class="mycontent" -->
					<h2>General information about users</h2>
						<br class="clr"/>
						<table cellpadding="1">
						<thead>
							<tr class="success">
								<th colspan="4"><h3>General information</h3></th>
								<th colspan="3"><h3>Adress</h3></th>
								<th colspan="6"><h3>Contacts</h3></th>
							</tr>
							<tr class="success">
								<th>
									First Name 
								</th>
								<th>
									Last Name 
								</th>
								<th>
									Status 
								</th>
								<th>
									City 
								</th>
								<th>
									Region 
								</th>
								<th>
									Street 
								</th>
								<th>
									House / Flat 
								</th>
								<th>
									Zip Code 
								</th>
								<th>
									Phone 
								</th>
								<th>
									Email 
								</th>
								<th>
								</th>
								<th>
								</th>
								
							</tr>
							</thead>

							<tbody>
							<c:forEach items="${onlyUsers}" var="user">
							
								<tr>
									<td>
										<c:out value="${user.firstName}"></c:out>
									</td>
									<td>
										<c:out	value="${user.lastName}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.ban}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.contact.address.city}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.contact.address.region}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.contact.address.street}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.contact.address.house}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.contact.address.zipCode}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.contact.phone}"></c:out> 
									</td>
									<td>
										<c:out	value="${user.contact.email}"></c:out> 
									</td>
									<td>
										 <form method="post" action="adminPageServlet">
												<input type="hidden" value="${user.idUser}" name="idUsr"/>
									            <input class="btn btn-success" style="padding: 0 4px 0 4px;" id="${user.ban}" type="submit" name="button" value="bann"/>
									            <input type="hidden" value="${user.idUser}" name="idUsr"/>
								            	<input class="btn btn-danger" style="padding: 0 4px 0 4px;" id="u${user.ban}" type="submit" name="button" value="unbann"/>
								         </form>
									</td>
								</tr>
							
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

<!-- 				/maContent -->
			</div>
		</div>


	<div style="height: 330px;"></div>
	


	<jsp:include page="footer"></jsp:include>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
	<script src="bootstrap/js/userPage.js"></script>
</body>
</html>