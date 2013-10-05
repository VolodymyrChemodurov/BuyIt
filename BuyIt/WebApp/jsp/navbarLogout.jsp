<ul id="topMenu" class="nav pull-right">
	<li><a><b><jsp:getProperty property="login"
					name="currentUser" /></b></a></li>
	<li id="logout">
		<form action="logoutS">
			<button class="btn btn-danger" type="submit">Log Out</button>
		</form>
	</li>
</ul>