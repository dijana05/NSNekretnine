<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Aplikacija za oglasavanje nekretnina</title>
</head>
<body>
<!-- banner -->
<div class="inside-banner">
	<div class="container">
		<span class="pull-right"><a href="/">Pocetna strana</a> / Moje Nekretnine / Izmena nekretnine </span>
		<h2>Unos nekretnine</h2>
	</div>
</div>
<!-- banner -->

<sec:authorize access="isAuthenticated()">
	<c:set var="userID">
		<sec:authentication property="principal.korisnikID"/>
	</c:set>
</sec:authorize>


<%@ include file="../header.jsp"%>
<div class="container">
	<div class="spacer">
		<div class="row register">
			<form action="/nekretnine/save" enctype="multipart/form-data" method="post">
				<div class="container">	
					<input type="file" name="slike" multiple class="form-control"/>
					<input type="hidden" name="slikeNazivi" value=""/>
					Tip nekretnine: <select name="tip" class="form-control">
										<option value="Stan">Stan</option>
										<option value="Kuca">Kuca</option>
										<option value="Garaza">Garaza</option>
										<option value="Drugo">Drugo</option>
									</select><br>
					Povrsina: <input type="number" class="form-control" name="povrsina" placeholder="Povrsina u m2" min="0"><br>
					Broj soba: <select name="brojSoba" class="form-control" >
									<option value="0.5">0.5</option>
									<option value="1">1</option>
									<option value="1.5">1.5</option>
									<option value="2">2</option>
									<option value="2.5">2.5</option>
									<option value="3">3</option>
									<option value="3+">3+</option>
								</select><br>
					Sprat: <input type="number" class="form-control" name="sprat" placeholder="Sprat" min="0">
					Uknjizenost: <input type="text" class="form-control" name="uknjizenost" placeholder="Ukljizenost">
					Namestenost: <input type="text" class="form-control" name="namestenost" placeholder="Namestenost">
					Godina Izgradnje: <input type="number" class="form-control"  name="godinaIzgradnje" placeholder="Godina izgradnje" min="1800" max="2022">
					Grejanje: <input type="text" class="form-control" name="grejanje" placeholder="Grejanje">
					Lift: <input type="text" class="form-control" name="lift" placeholder="Lift">
					Parking:<input type="text" class="form-control" name="parking" placeholder="Parking">
					Duplex: <input type="text" class="form-control" name="duplex" placeholder="Duplex">
					Stanje: <input type="number" class="form-control" name="stanje" placeholder="Stanje 1-10" min="1" max = 10>
					Adresa: <input type="text" class="form-control" name="adresa" placeholder="Adresa">
					Depozit: <input type="text" class="form-control" name="depozit" placeholder="Depozit">
					<input type="hidden" class="form-control" name="dodao" value="userID">
					
					<input type="submit" class="btn btn-success" value="Unesi"/>
				</div>
			</form>		
		</div>
		  
	</div>
</div>

	<%@ include file='../footer.jsp' %>
</body>		
</html>