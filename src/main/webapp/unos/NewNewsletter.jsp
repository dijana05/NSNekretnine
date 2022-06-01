<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos newsletter</title>
</head>
<body>
<!-- banner -->
<div class="inside-banner">
  <div class="container"> 
    <span class="pull-right"><a href="/">Pocetna strana</a> / Unos newsletter </span>
</div>
</div>
<!-- banner -->

<%@ include file="../header.jsp" %>

<div class="container">
	<c:if test="${!empty message }">
		${message}
	</c:if>

	<div class="spacer">
		<div class="row register">
				<form action="/newsletter/send-mail" method="post">
					Subject <input type="text" name="sub" class="form-control"/><br>
					Text <br>
					<textarea name="mess" class="textarea" style="width:100%; height:250px;"></textarea>
					<br>
					
					<input type="submit" value="Posalji newsletter" class="btn btn-success">
				</form>
		</div>
	  
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>