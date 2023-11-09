<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Logg in</title>
</head>
<body>
	<h2>Logg in</h2>
	
	<p>Bare registrerte deltakere har mulighet til aa se deltakerlisten.</p>
	
	<c:choose>
    <c:when test="${error=='1'}">
	<p>
		<font color="red">Denne brukeren eksisterer ikke</font>
	</p>
        <br />
          </c:when> 
          <c:when test="${error=='2'}">
          <p>
          	<font color="red">Ugyldig tlf eller passord</font>
          	</p>
          	<br />
          	</c:when>
        </c:choose>
	
	<form action="LoginServlet" method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="tlf">Telefon nummer:</label> <input type="text" name="tlf" />
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input type="passord"
					name="passord" />
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Logg
					in</button>
			</div>
			<p>Ingen bruker?</p>
			
			<a href="http://localhost:8080/oblig4/RegistrerServlet">Ny konto</a> 
			
		</fieldset>
	</form>

</body>
</html>