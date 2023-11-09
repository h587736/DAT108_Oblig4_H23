<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import ="oblig4_h23.UserDAO" %>
<%@ page import ="oblig4_h23.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Deltaker liste</title>
</head>
<body>
	<h2>Deltaker liste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Gender</th>
			<th align="left">Navn</th>
			<th align="left">Telefon nummer</th>
		</tr>
		
        <c:forEach items="${list}" var="i">
            <c:choose>
                <c:when test="${i.tlf == bruker.tlf}">
                    <tr bgcolor="#aaffaa">
                        <td align="center">${i.kjonn == "MANN" ? "&#9794;" : "&#9792;"}</td>
                        <td>${i.fornavn} ${i.etternavn}</td>
                        <td>${i.tlf}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr bgcolor="#ffffff">
                        <td align="center">${i.kjonn == "MANN" ? "&#9794;" : "&#9792;"}</td>
                        <td>${i.fornavn} ${i.etternavn}</td>
                        <td>${i.tlf}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>

			<form action="ParticipantListServlet" method="post" class="pure-form pure-form-aligned">
	<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Log out</button>
			</div>
	</form>
</body>
</html>