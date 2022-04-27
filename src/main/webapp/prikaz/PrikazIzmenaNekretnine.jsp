<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Izmena nekretnine</title>
</head>
<body>
	
<div class="inside-banner">
	<div class="container">
		<span class="pull-right"><a href="/">Pocetna strana</a> / Moje Nekretnine / Izmena nekretnine </span>
		<h2>Izmena nekretnine</h2>		
	</div>
</div>
	<!-- banner -->
	<%@ include file="../header.jsp"%>
	
<div class="container">
	<div class="spacer">
		<div class="row register">
			<c:if test="${!empty nekretnina }">
				<form action="/nekretnine/izmena" method="post" enctype="multipart/form-data">
					<c:forEach var="slika" items="${nekretnina.slikeNazivi}">
							<img src="/uploads/${slika}" class="properties" alt="properties"
								width="200px" height="200px" />
						

					</c:forEach>
					<input type="hidden" name="slikeNazivi" value=""/>
					<input type="hidden" name="nekretninaID" value="${nekretnina.nekretninaID}">
					Tip:<input value="${nekretnina.tip}" name="tip"	class="form-control" readonly /><br> 
					Povrsina:<input value="${nekretnina.povrsina}" type="number" name="povrsina" class="form-control" placeholder="Povrsina u m2">
					Broj soba:<input value="${nekretnina.brojSoba}" name="brojSoba" class="form-control" placeholder="Broj soba" />
					Sprat: <input value="${nekretnina.sprat}" name="sprat" class="form-control" placeholder="Sprat" />
					Uknjizenost: <input value="${nekretnina.uknjizenost}" name="uknjizenost" class="form-control" placeholder="Uknjizenost" /> 
					Namestenost: <input value="${nekretnina.namestenost}" name="namestenost" class="form-control" placeholder="Namestenost" />
					Godina izgradnje: <input value="${nekretnina.godinaIzgradnje}" name="godinaIzgradnje" class="form-control" placeholder="Godina izgradnje" /> 
					Grejanje: <input value="${nekretnina.grejanje}" name="grejanje" class="form-control" placeholder="Grejanje" /> 
					Lift: <input value="${nekretnina.lift}" name="lift" class="form-control" placeholder="Lift" /> 
					Parking: <input value="${nekretnina.parking}" name="parking" class="form-control"  placeholder="Parking" /> 
					Duplex: <input value="${nekretnina.duplex}" name="duplex" class="form-control" placeholder="Duplex" /> 
					Stanje: <input value="${nekretnina.stanje}" type="number" name="stanje" class="form-control" placeholder="Stanje" />
					Adresa: <input value="${nekretnina.adresa}" name="adresa" class="form-control" placeholder="Adresa" /> 
					Depozit:<input value="${nekretnina.depozit}" name="depozit" class="form-control" placeholder="Depozit"> 
					<input type="hidden" name="dodao" value="${nekretnina.dodao}">
						
						<input type="submit" class="btn btn-success" value="Izmeni nekretninu">
				</form>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp"%>
</body>
</html>