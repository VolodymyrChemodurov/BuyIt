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
				<a class="brand" href="index.html"><img
					src="themes/images/logo.png" alt="Bootsshop"></a>
				<form class="form-inline navbar-search" method="post"
					action="products.html">
					<input id="srchFld" class="srchTxt" type="text"> <select
						class="srchTxt">
						<c:forEach var="product" items="${products}">
							<option>${product.key}</option>
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