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
	<link rel="stylesheet" type="text/css" href="skjema.css">
	
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<form id="skjema" name="skjema" method="post" action="RegisterSerlvet" class="pure-form pure-form-aligned">
		<fieldset>
		
			<div class="pure-control-group">
				<label for="Username">Username:</label> <input id="Username" type="text"
					name="Username" value="${skjema.username}" /> 
					<p id="usernameFeilmelding" class="feil">${skjema.usernameFeilmelding}</p>
					
			</div>
			
			<div class="pure-control-group">
				<label for="password">Password:</label> <input id="password" type="password"
					name="password" value="" /> 
					<p id="passordServerFeil" class="feil">${skjema.passwordFeilmelding}</p>
					<p class="feil" id="passordTilbakemelding"></p>
			</div>
			
			<div class="pure-control-group">
				<label for="passwordRepetert">Password:</label> <input id="passwordRepetert"
					type="password" name="passwordRepetert"
					value="" /> 
					<p id="passordRepetertServerFeil" class="feil">${skjema.passwordRepetertFeilmelding}</p>
			</div>
			
			<div class="pure-controls">
				<button id="knapp" type="submit" class="pure-button pure-button-primary">Submit</button>
			
			</div>
		</fieldset>
	</form>
	<p><a href="LoginServlet">Login!</a></p>
	
	<script src="scripts/InputValidering.js"></script>
</body>
</html>