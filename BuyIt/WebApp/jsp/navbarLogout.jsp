<jsp:useBean id="user" class="com.epam.lab.buyit.model.User"
	scope="session" />
<form method="get" action="logOutServlet">

	<ul id="topMenu" class="nav pull-right">
		<li class="dropdown" style="color: white;"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" style="padding-right: 0;" role="text" >
			<h4><jsp:getProperty property="login" name="user" /><b class="caret"></b></h4></a>
						<ul class="dropdown-menu">
				<li><a href="userProfile">Profile</a></li>
				<li class="divider"></li>
				<li><a href="#">Products</a></li>
				<li><a href="#">Bids</a></li>
				<li><a href="#">Comments</a></li>
			</ul>
		</li>
		<li class=""><a href="registration" role="button" style="padding-right: 0">
				<button class="btn btn-large btn-warning" type="submit">Log	Out</button>
		</a></li>
</ul>
</form>
