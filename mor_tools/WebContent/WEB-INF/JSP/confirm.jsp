<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Confirmation</h1>
	<p>You are now registered as: </p>
	<p>
		&nbsp;&nbsp;&nbsp;${bekreftet.username}<br />
	</p>
	<a href="MainServlet">Continue to the main page</a>
</body>
</html>