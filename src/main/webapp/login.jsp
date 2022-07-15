<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html class="no-js" lang="zxx">


<head>

    <title> Login</title>

</head>

<body>

<div class="inside-banner">
  <div class="container"> 
    <span class="pull-right"><a href="/">Pocetna strana</a> / Login</span>
    <h2>Login</h2>
  </div>
</div>
<%@ include file="header.jsp" %>
<div class="container">
	<div class="spacer">
		<div class="row register">
  			<div class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
	
							<form action="login" method="post">
								<div class="form-control">
									<c:if test="${!empty message }">
										${message }<br>
									</c:if>
								</div>						
							
								<input type="text" class="form-control" name="username" placeholder="Email" required>
							
							
								<input type="password" class="form-control" name="password" placeholder="Password" required>
								
							
								<input type="submit" class="btn btn-success" value="Uloguj se">
								
								
							</form>
                		           
                		<div class="form-control">
                			<p>Nemate nalog? <a href="/korisnik/registracijaPage">Registrujte se</a></p>
                		</div>
 			</div>
		</div>
	</div>
</div>    
	 
</body>

</html>