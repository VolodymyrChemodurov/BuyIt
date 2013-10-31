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
				</div>
				
				<!-- /left-menu -->
				<div id="maContent" class="corAll5">

					<div class="span9">
						<h3>Registration</h3>
						<div class="well">
							<div class="row">
								<div class="span3">
									<form class="form-horizontal" method="post" id="createCategory-form"
										action="createCategoryServlet">

										<h4>Create new category</h4>
										
										<div class="control-group">
											<label class="control-label" for="categoryCreate">Category name </label>
											<div class="controls">
												<input type="text" id="categoryCreate" name="categoryName" placeholder="Category name"
													class="tip" data-toggle="tooltip" data-placement="right"
													title="More then 4 characters, only characters">
											</div>
										</div>
										
										<div class="control-group">
											<div class="controls">
												<button class="btn btn-large btn-success" type="submit"	id="createButton">Create</button>
											</div>
										</div>
										
									</form>
								</div>
								
								<div class="span3" style="float:right">
									<c:if test="${(messageHeader!=null) && (message!=null)}">
										<div class="alert alert-${alert}">
											<h4>${messageHeader}</h4>
											${message}
										</div>
									</c:if>
								</div>
							</div>
								
								<hr class="soft" />
								
							<div class="row">
								
								<div class="span3">
									<form class="form-horizontal" method="post" id="createCategory-form"
										action="createCategoryServlet">
										
										<h4>Create new Sub-category</h4>
										
										<h5>Select category</h5>
										<div class="control-group">
											<label class="control-label" for="categoryView">Category</label>
											<div class="controls">
												<select id="categoryView1" name="selectedCategory">
													<option>Select...</option>
													<c:forEach var="category" items="${categories}">
														<option value="${category.idCategory}">${category.name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="subCategoryCreate">Sub-category name </label>
											<div class="controls">
												<input type="text" id="subCategoryCreate" name="subCategoryCreate" placeholder="Sub-category name"
													class="tip" data-toggle="tooltip" data-placement="right"
													title="More then 4 characters, only characters">
											</div>
										</div>
										
										<div class="control-group">
											<div class="controls">
												<button class="btn btn-large btn-success" type="submit"	id="createButton">Create</button>
											</div>
										</div>
										
									</form>
								</div>
								<div class="span3" style="float:right">
									<c:if test="${(messageHeader1!=null) && (message1!=null)}">
										<div class="alert alert-${alert1}">
											<h4>${messageHeader1}</h4>
											${message1}
										</div>
									</c:if>
								</div>

								
							</div>
						</div>
					</div>
				</div>
				
				<!-- /maContent -->
			</div>
		</div>


	<div style="height: 30px;"></div>
	


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
	<script src="bootstrap/js/search.js"></script>
</body>
</html>