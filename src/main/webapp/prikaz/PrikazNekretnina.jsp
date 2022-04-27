<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Moje nekretnine</title>
</head>
<body>

	<!-- banner -->
	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="/">Pocetna stranica</a> / Moje nekretnine</span>
			<h2>Moje nekretnine</h2>
		</div>
	</div>
	<!-- banner -->
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="properties-listing spacer">
			<div class="row">

				<div class="col-lg-9 col-sm-8">
					<div class="sortby clearfix">
						<div class="pull-left result">Showing: 12 of 100</div>
						<div class="pull-right">
							<select class="form-control">
								<option>Sort by</option>
								<option>Price: Low to High</option>
								<option>Price: High to Low</option>
							</select>
						</div>

					</div>
					<!-- TO DO -->
					<div class="row">
						<c:if test="${!empty nekretnine }">
							<c:forEach var="n" items="${nekretnine}">
								<div class="row" style="border: thick double; #C0C0C0">
									<c:forEach var="slika" items="${n.slikeNazivi}">
										<img src="/images/uploads/${slika}" class="properties"
											alt="slike" width="100px" height="100px">
									</c:forEach>
									<div class="form-control">ID nekretnine:
										${n.nekretninaID}</div>
									<div class="form-control">${n.tip}</div>
									<div class="form-control">${n.povrsina}</div>
								</div>

								<a class="btn" href="/oglasi/unosOglasa?nekretnina=${n.nekretninaID}">Dodaj oglas za ovu nekretninu</a>
								<a class="btn" href="/nekretnine/prikazIzmenaNekretnine?nekretnina=${n.nekretninaID}">Izmeni</a>
								<a class="btn" href="/nekretnine/brisanje?nekretnina=${n.nekretninaID}">Izbrisi</a>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>



	<%@ include file='../footer.jsp'%>
</body>
</html>