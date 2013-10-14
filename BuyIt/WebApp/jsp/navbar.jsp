<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header">
	<div class="container">
		<!-- Navbar ================================================== -->
		<div id="logoArea" class="navbar">
			<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="navbar-inner">
				<a class="brand" href="homePage"><img
					src="themes/images/logo.png" alt="Bootsshop"></a>
				<form class="form-inline navbar-search" method="post"
					action="searchServlet">
					<input id="srchFld" class="srchTxt" type="text" name="srchedFld">
					<select class="srchTxt" name="srchedTxt">
						<option>Select...</option>
						<c:forEach var="product" items="${categories}">
							<option>${product}</option>
						</c:forEach>
					</select>
					<button type="submit" id="submitButton" class="btn btn-primary">Go</button>
				</form>
				<c:if test="${empty user}">
					<jsp:include page="navbarLogin"></jsp:include>
				</c:if>
				<c:if test="${not empty user}">
					<jsp:include page="navbarLogout"></jsp:include>
				</c:if>
			</div>
		</div>
	</div>
</div>
