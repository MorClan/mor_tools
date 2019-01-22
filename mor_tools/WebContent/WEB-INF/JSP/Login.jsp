<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Login</h2>
	<p>
		<font color="red">${loginError}</font>
	</p>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="Username">Username:</label> <input type="text" name="Username" />
			</div>
			<div class="pure-control-group">
				<label for="password">Password:</label> <input type="password"
					name="password" />
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Login!</button>
			</div>
		</fieldset>
	</form>
	<p><a href="RegisterSerlvet">Register</a></p>

</body>
</html>