<jsp:useBean id="user" class="com.epam.lab.buyit.model.User"
	scope="session" />
<form method="get" action="logoutServlet">
	<ul id="topMenu" class="nav pull-right">
		<li style="color: white;"><a style="padding-right: 0;" role="text"><h4><jsp:getProperty property="login" name="user" /></h4></a></li>
		<li class="" ><a href="registration"
			role="button" style="padding-right: 0">
				<button class="btn btn-large btn-warning" type="submit">Log
					Out</button>
		</a></li>
</form>
</ul>