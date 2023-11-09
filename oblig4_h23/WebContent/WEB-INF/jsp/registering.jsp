<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="oblig4_h23.Skjema" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->

<title>Registering</title>
</head>
<body>
 <style>
.tooltip {
  position: relative;
  display: inline-block;
}
.tooltip .tooltiptext {
  visibility: hidden;
  width: 250px;
  background-color: black;
  color: #fff;
  text-align: left;
  border-radius: 6px;
  padding: 5px 0;
  /* Position the tooltip */
  position: absolute;
  z-index: 1;
}
.tooltip:hover .tooltiptext {
  visibility: visible;
  top: -5px;
  left: 105%;
}
</style>

<body style="text-align:center;">

    
	<h2>Registration</h2>
	<form action="RegistrerServlet" method="post" class="pure-form pure-form-aligned">
		<fieldset>
		
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text" id="f" onkeyup="fornavnFunction();"
					name="fornavn" value="${skjema.fornavn}" /> 
					
					<font color="red">${skjema.fornavnFeil}</font>
					
				
			</div>
			<div class="pure-control-group">
				<label for="etternavne">Etternavn:</label> <input type="text" id="l" onkeyup="etternavnFunction();"
					name="etternavn" value="${skjema.etternavn}" /> 
					
					<font color="red">${skjema.etternavnFeil}</font>
					
			</div>
			<div class="pure-control-group">
				<label for="tlf">Telefon nummer (8 tall):</label> <input type="text" id="pn" onkeyup="tlfFunction();"
					name="tlf" value="${skjema.tlf}" /> 
					
					<font color="red">${skjema.tlfFeil}</font>
</div>
            <div class="pure-control-group tooltip">
                <label for="passord">Passord:</label> <input type="passord" id="pw" onkeyup="passordFunction();"
                    name="passord" value="${skjema.passord}" /> 

                    <span class="tooltiptext">Password rules <br>
                        <span style="color: #ff0000">Red(very weak)</span>: Inneholder bare smaa bokstaver. <br>
                        <span style="color: #FFFF00">Yellow(weak)</span>: Inneholder bare smaa og store bokstaver <br>
                        <span style="color: #00FF00">Green(strong)</span>: Inneholder smaa bokstaver, store bokstaver og tall eller spesielle tegn.
                </span>
                
	<font color="red">${skjema.passordFeil}</font>


            </div>		
				
			
			<div class="pure-control-group">
				<label for="gjentatPassord">Gjenta passord:</label> <input
					type="passord" id="rpw" onkeyup="gjentaPassordFunction();" name="gjentaPassord"
					value="${skjema.gjentaPassword}" /> 
					
					<font color="red">${skjema.gjentaPassordFeil}</font>
					
					
			</div>
			<div class="pure-control-group">
				<label for="gender">Gender:</label> <input type="radio" name="kjonn"
					value="mann"
					 />mann
				<input type="radio" name="kjonn" value="kvinne"
					 />kvinne
					 
					 <font color="red">${skjema.kjonnFeil}</font>
				
			</div>

      
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Registrer</button>
			</div>
			<p>
			 Har allerede en konto? <a href="http://localhost:8080/oblig4/LoginServlet">trykk her</a>
			</p>
		</fieldset>
	</form>
	<script src="KlientSjekk.js"></script>
</body>
</html>