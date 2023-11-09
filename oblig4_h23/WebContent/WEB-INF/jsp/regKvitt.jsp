<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="oblig4.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Registration Receipt</title>
</head>
<body>
	<h2>Registration Receipt</h2>
	<p>Registration is received</p>
	
		<%
		User user = (User)request.getAttribute("user");
		%>
		
		<p>${user.firstname}</p>
		<p>${user.lastname}</p>
		<p>${user.phone}</p>
		<p>${user.gender}</p>
	
	<a href="http://localhost:8080/oblig4/ParticipantListServlet">Look at the participant list</a>
</body>
</html>