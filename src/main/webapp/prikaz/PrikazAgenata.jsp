<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled agenata</title>
</head>
<body>
<!-- banner -->
<div class="inside-banner">
  <div class="container"> 
    <span class="pull-right"><a href="/">Home</a> / Agenti</span>
    <h2>Agenti</h2>
</div>
</div>
<!-- banner -->
<%@ include file="../header.jsp" %>

<div class="container">
	<div class="spacer agents">
		<div class="row">
		  <div class="col-lg-8  col-lg-offset-2 col-sm-12">
			<c:if test="${!empty agenti}">
				<c:forEach var="agent" items="${agenti }">
					<div class="row" style="border: border-width:3px; border-style:groove; border-color: #C0C0C0">
			       			<div class="col-lg-7 col-sm-7 "><h2>${agent.ime} ${agent.prezime}</h2><p>${agent.agencija.naziv }</p></div>
			        		<div class="col-lg-3 col-sm-3 "><span class="glyphicon glyphicon-envelope"></span> ${agent.agencija.adresa}<br>
			        		<span class="glyphicon glyphicon-earphone"></span> ${agent.brojTelefona}</div>
					</div>	
				</c:forEach>	
			</c:if>
		  </div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>