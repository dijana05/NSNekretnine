<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Izaberite agenciju za koju radite</title>
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
	<div class="spacer">
		<div class="row register">
		  <div class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
			<form action="/korisnik/registracija" method="post">
				Izaberite agenciju za koju radite:<br>
				<c:if test="${!empty agencije }">
					<select class="form-control" name="agencija">
						<c:forEach var="a" items="${agencije }">
							<option value="${a.id }">${a.naziv}</option>
						</c:forEach>
					</select>
				</c:if>
				<input type="submit" class="btn btn-success" value="Dalje">
			</form>
			              
		  </div>
		 </div>
	</div>
</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>