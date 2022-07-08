<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registruj nalog</title>
</head>
<body>
<div class="inside-banner">
  <div class="container"> 
    <span class="pull-right"><a href="/">Pocetna strana</a> / Registracija</span>
    <h2>Registracija</h2>
</div>
</div>
<!-- banner -->
<%@ include file="header.jsp" %>

<div class="container">
	<div class="spacer">
		<div class="row register">
		  <div class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
		
		  			<form action="/korisnik/registracija" method="post">
		  				
		  				<div class="form-control">
									<c:if test="${!empty message }">
										${message }<br>
									</c:if>
						</div>		
		  				
		  			
		                <input type="text" class="form-control" placeholder="Ime" name="firstName">
		                <input type="text" class="form-control" placeholder="Prezime" name="lastName">
		                <input type="password" class="form-control" placeholder="Sifra" name="password">
		                <input type="text" class="form-control" placeholder="Email" name="email">
		               	<!--  Uloga: 
		               	 	<select name="uloga" class="form-control">
								<!-- <option value="admin">Admin</option>
								<option value="agencija">Oglasivac - Agencija</option>
								<option value="oglasivac">Oglasivac</option>	
							</select>
						--> 
		    			 <input type="submit" class="btn btn-success" value="Dalje"/>
		         </form>               
		  </div>
		  
		</div>
	</div>

</div>
<%@ include file="footer.jsp" %>

</body>
</html>