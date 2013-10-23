<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="com.epam.lab.buyit.model.User"
	scope="session" />
<form method="get" action="logOutServlet">

	<ul id="topMenu" class="nav pull-right">
		<c:if test="${user.role=='true'}">
			<li style="color: white;">
				<a href="adminPageServlet"role="text">
					<h4><jsp:getProperty property="login" name="user" />
					</h4>
			</a>
			</li>
		</c:if>
		<c:if test="${user.role=='false'}">
			<li class="dropdown" style="color: white;"><a
				class="dropdown-toggle" data-toggle="dropdown" href="#"
				style="padding-right: 0;" role="text">
					<h4><jsp:getProperty property="login" name="user" /><b
							class="caret"></b>
					</h4>
			</a>

				<ul class="dropdown-menu">
					<li><a href="userProfile">Profile</a></li>
					<li class="divider"></li>
					<li><a href="userSalesServlet">Sales</a></li>
					<li><a href="userShoppingServlet">Shopping</a></li>
					<li><a href="#">Comments</a></li>
					<li><a href="userAddProductServlet">Product</a></li>
				</ul></li>
		</c:if>
		<li class=""><a href="registration" role="button"
			style="padding-right: 0">
				<button class="btn btn-default btn-warning" type="submit">Log
					Out</button>
		</a></li>
	</ul>
</form>
