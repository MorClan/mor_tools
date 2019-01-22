<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kills</title>
</head>
<body>
<h1>Clan Deaths</h1>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Area</th>
			<th>Gear Level</th>
			<th>Range</th>
		</tr>
		<c:forEach var="death" items="${dlist}">
		<tr>
			<td>${death.town}</td>
			<td>${death.gearLevel}</td>
			<td>${death.distance}</td>
		</tr>
		</c:forEach>
		</table>
		<a href="MainServlet">Back to main</a>
		
		<div class="Submit">
		<h2>Register Death</h2>
		<form id="addDeath" name="addDeath" method="post" action="DeathServlet" class="pure-form pure-form-aligned">
		<fieldset>
		
			<div class="location">
				<label for="location">Area: </label> 
				<select name="location">
				<c:forEach var="location" items="${Locations}">
				<option value="${location}"> ${location}</option>
				</c:forEach>
				</select>
			</div>
			<div class="gearLevel">
				<label for="gearLevel">Gear Level: </label>
				<table>
					<tr>
						<td>
						<input type="radio" name="gearLevel" value="low"> Low<br>
						</td>
						<td>
 						<input type="radio" name="gearLevel" value="medium"> Medium<br>
 						</td>
 						<td>
  						<input type="radio" name="gearLevel" value="high"> High<br> 
  						</td>
  						</tr>
  				</table> 
			</div>
			<div class="distance">
				<label for="distance">Distance: <br></label>
				<table>
				<tr>
				<td>
				<input type="radio" name="distance" value="0-100">0-100<br>
				</td>
				<td>
 				<input type="radio" name="distance" value="100-300">100-300 <br>
 				</td>
 				<td>
  				<input type="radio" name="distance" value="300-500">300-500 <br>
  				</td>
  				<td>
  				<input type="radio" name="distance" value="500+">500+<br>
  				</td>  
  				</tr>
  				</table>
			</div>
			<div class="pure-controls">
				<button id="knapp" type="submit" class="pure-button pure-button-primary">Submit</button>
			
			</div>
		</fieldset>
	</form>
	</div>
	
</body>
</html>