<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos oglasa za nekretninu</title>
</head>
<body>
<!-- banner -->
<div class="inside-banner">
  <div class="container"> 
    <span class="pull-right"><a href="/">Pocetna strana</a> / Unos nove nekretnine / Unos oglasa za nekretninu</span>
    <h2>Unos oglasa za nekretninu</h2>
</div>
</div>
<!-- banner -->

<%@ include file="../header.jsp" %>

<div class="container">
	<div class="spacer">
		<div class="row register">
			<c:if test="${!empty nekretnina}">
				<form action="/oglasi/noviOglas" method="post">
					Text oglasa <br>
					<textarea name="tekst" class="textarea" style="width:100%; height:250px;"></textarea>
					<input type="hidden" name="nekretnina" value="${nekretnina.nekretninaID}"><br>
					Cena <input type="number" name="cena" class="form-control"/>
					<input type="submit" value="Postavi oglas" class="btn btn-success">
				</form>
			</c:if>
		</div>
	  
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>