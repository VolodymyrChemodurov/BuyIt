<ul id="topMenu" class="nav pull-right">
	<li class=""><a href="registration" role="button"
		style="padding-right: 0"><button class="btn btn-large btn-warning"
				type="submit">Registartion</button></a>
	<li class=""><a href="#login" role="button" data-toggle="modal"
		style="padding-right: 0"><span class="btn btn-large btn-success">Login</span></a>
		<div id="login" class="modal hide fade in" tabindex="-1" role="dialog"
			aria-labelledby="login" aria-hidden="false">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3>Login Block</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal loginFrm" method="post"
					action="loginServlet">
					<div class="control-group">
						<input type="text" id="login" name="login" placeholder="Login">
					</div>
					<div class="control-group">
						<input type="password" id="password" name="password" placeholder="Password">
					</div>
					<div></div>
					<a class="dropdown-toggle" href="forgetPassword" style="text-decoration:none"><h4>Forget password</h4></a>
					<div></div>
					<button type="submit" class="btn btn-success">Sign in</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
				</form>
			</div>
		</div></li>
</ul>