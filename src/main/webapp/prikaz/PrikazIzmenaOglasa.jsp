<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Izmeni oglas</title>
</head>
<body>
	<!-- banner -->
	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="/">Pocetna stranica</a> / Moji oglasi / Izmena oglasa</span>
			<h2>Izmena oglasa</h2>
		</div>
	</div>
	<!-- banner -->
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="properties-listing spacer">
			<form action="/oglasi/update">
				<div class="row">
					<div class="col-lg-3 col-sm-4 hidden-xs"></div>

					<div class="col-lg-9 col-sm-8 ">
						<c:if test="${!empty oglas }">
							<c:set var="tekst" value="${oglas.tekst}" />
							<h2>${fn:substring(tekst,0,20)}</h2>
							<div class="row">
								<div class="col-lg-8">
									<div class="property-images">
										<!-- Slider Starts -->
										<div id="myCarousel" class="carousel slide"
											data-ride="carousel">
											<!-- Indicators -->
											<ol class="carousel-indicators hidden-xs">
												<li data-target="#myCarousel" data-slide-to="0"
													class="active"></li>
												<li data-target="#myCarousel" data-slide-to="1" class=""></li>
												<li data-target="#myCarousel" data-slide-to="2" class=""></li>
												<li data-target="#myCarousel" data-slide-to="3" class=""></li>
											</ol>
											<div class="carousel-inner">
												<c:set var="count" value="1" />
												<!-- Item 1 -->
												<div class="item active">
													<img src="/uploads/${oglas.nekretnina.slikeNazivi[0]}"
														class="properties" alt="properties" />
													<c:set var="count" value="${count + 1}" scope="page" />
												</div>
												<c:forEach var="slika"
													items="${oglas.nekretnina.slikeNazivi}">
													<!-- Item 1 -->
													<div class="item">
														<img src="/uploads/${slika}" class="properties"
															alt="properties" width="400px" height="400px" />
														<c:set var="count" value="${count + 1}" scope="page" />
													</div>
													<!-- #Item 1 -->
												</c:forEach>
											</div>
											<a class="left carousel-control" href="#myCarousel" data-slide="prev">
												<span class="glyphicon glyphicon-chevron-left">
												</span>
											</a> 
											<a class="right carousel-control" href="#myCarousel" data-slide="next">
												<span class="glyphicon glyphicon-chevron-right"></span>
											</a>
										</div>
										<!-- #Slider Ends -->

									</div>




									<div class="spacer">
										<h4>
											<span class="glyphicon glyphicon-th-list"></span> Detalji
											nekretnine
										</h4>
										<c:if test="${!empty oglas.nekretnina.tip}">Tip:${oglas.nekretnina.tip}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.povrsina}">Povrsina:${oglas.nekretnina.povrsina} m2<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.brojSoba}">Broj soba:${oglas.nekretnina.brojSoba}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.sprat}">Sprat: ${oglas.nekretnina.sprat}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.uknjizenost}">Uknjizenost: ${oglas.nekretnina.uknjizenost}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.namestenost}">Namestenost: ${oglas.nekretnina.namestenost}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.godinaIzgradnje}">Godina izgradnje: ${oglas.nekretnina.godinaIzgradnje}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.grejanje}">Godina izgradnje: ${oglas.nekretnina.grejanje}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.lift}">Lift: ${oglas.nekretnina.lift}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.parking}">Parking: ${oglas.nekretnina.parking}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.duplex}">Duplex: ${oglas.nekretnina.duplex}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.stanje}">Stanje: ${oglas.nekretnina.stanje}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.adresa}">Adresa: ${oglas.nekretnina.adresa}<br>
										</c:if>
										<c:if test="${!empty oglas.nekretnina.depozit}">Depozit: ${oglas.nekretnina.depozit}<br>
										</c:if>
									</div>
									<p>
										<textarea name="tekst" rows="10" cols="100" autofocus>${oglas.tekst}</textarea>
									</p>

									<div>
										<h4>
											<span class="glyphicon glyphicon-map-marker"></span> Lokacija
										</h4>
										<div class="well">
											<iframe width="100%" height="350"
												
												src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Pulchowk,+Patan,+Central+Region,+Nepal&amp;aq=0&amp;oq=pulch&amp;sll=37.0625,-95.677068&amp;sspn=39.371738,86.572266&amp;ie=UTF8&amp;hq=&amp;hnear=Pulchowk,+Patan+Dhoka,+Patan,+Bagmati,+Central+Region,+Nepal&amp;ll=27.678236,85.316853&amp;spn=0.001347,0.002642&amp;t=m&amp;z=14&amp;output=embed"></iframe>
										</div>
									</div>

								</div>
								<div class="col-lg-4">
									<div class="col-lg-12  col-sm-6">
										<div class="property-info">
											<p class="price">
												<input type="number" name="cena" value="${oglas.cena }">e
											</p>
											<p class="area">
												<span class="glyphicon glyphicon-map-marker"></span> Novi
												Sad
											</p>
											<div class="profile">
												<span class="glyphicon glyphicon-user"></span>Detalji o
												korisniku
												<p>
													${oglas.kreirao.ime} ${oglas.kreirao.prezime}<br>
												</p>
											</div>
										</div>

									</div>
									<div class="col-lg-12 col-sm-6 ">
									<input type="submit" class="btn btn-success" value="Potvrdite izmene">
									</div>
								</div>

							</div>
						</c:if>
					</div>
				</div>
				<input type="hidden" name="oglasid" value="${oglas.oglasID }">
			</form>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>