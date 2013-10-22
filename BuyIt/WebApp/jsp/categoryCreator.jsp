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


<script src="themes/js/jquery.js" type="text/javascript"></script>

</head>

<body data-spy="scroll" data-target=".navbar">
	<jsp:include page="navbar"></jsp:include>
	
	<div class="container">
		<div id="maWrapper" class="corAll5">
			<ul id="vMenu">
				<li><a href="adminMainPage">Ban Users</a></li>
				<li id="active"><strong>Create Category</strong></li>
				<li><a href="adminRegistration">Register Administrator</a></li>
				<li><a href="adminProfile">Profile</a></li>
			</ul>
			<!-- / #vMenu -->
				
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

					<div class="span9">
						<h3>Registration</h3>
						<div class="well">
						
	                            	<form class="form-horizontal" method="post" id="createCategory-form"
										action="createCategoryServlet">

										<h4>Create new category</h4>
										
										<div class="control-group">
											<label class="control-label" for="category">Category name </label>
											<div class="controls">
												<input type="text" id="category" name="categoryName" placeholder="Category name"
													class="tip" data-toggle="tooltip" data-placement="right"
													title="More then 4 characters Only number, small letters and '-' '_'">
											</div>
										</div>
										
										<div class="control-group">
											<div class="controls">
												<button class="btn btn-large btn-success" type="submit"	id="register">Create</button>
											</div>
										</div>
										
									</form>
									
									<hr class="soft" />
										
									<form class="form-horizontal" method="post" id="createCategory-form"
										action="createCategoryServlet">
										
										<h4>Create new Sub-category</h4>
										
										<h4>Select category</h4>
										<div class="control-group">
											<label class="control-label" for="categoryView">State</label>
											<div class="controls">
												<select id="categoryView" name="selectedCategory">
													<option value="">Select...</option>
<%-- 													<c:forEach var="cat" items="${category}"> --%>
<%-- 															<option value="${role}">${role}</option> --%>
<%-- 													</c:forEach> --%>
												</select>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="firstName">First name
											</label>
											<div class="controls">
												<input type="text" id="firstName" name="firstName"
													placeholder="First Name" class="tip" data-toggle="tooltip"
													data-placement="right" title="Start only from capital letter">
											</div>
										</div>
										
										
			
										<div class="control-group">
											<div class="controls">
												
												<button class="btn btn-large btn-success" type="submit" name="adminRole" value="1"
													id="register">Create</button>
											</div>
										</div>
									</form>
						</div>
					</div>
				</div>
				
				<!-- /maContent -->
			</div>
		</div>


	<div style="height: 330px;"></div>
	


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