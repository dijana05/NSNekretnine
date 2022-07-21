<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Moje nekretnine</title>

<script>
	function myF(selected){
		var selectedValue = selected.value;
		window.open("svePagination?sort="+ selectedValue, "_self");
	}

</script>

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
						<div class="pull-left result">Prikazano: ${curr+1} of ${ukupnoNekretnina}</div>
						<div class="pull-right">
							<form id="sort" action = "/nekretnine/svePagination">
							<select onchange="myF(this)" class="form-control" name="sort">
								<option>Sortiraj</option>
								<option value="asc">Povrsina: od manje ka vecoj</option>
								<option value="dsc">Povrsina: od vece ka manjoj</option>
							</select>
							</form>
						</div>

					</div>
				
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
								
								<sec:authorize access="isAuthenticated()">
									<c:set var="userID">
										<sec:authentication property="principal.korisnikID"/>
									</c:set>
								</sec:authorize>
								
								<c:if test="${userID eq n.dodao.korisnikID }">
									<a class="btn" href="/oglasi/unosOglasa?nekretnina=${n.nekretninaID}">Dodaj oglas za ovu nekretninu</a>
									<a class="btn" href="/nekretnine/prikazIzmenaNekretnine?nekretnina=${n.nekretninaID}">Izmeni</a>
									<a class="btn" href="/nekretnine/brisanje?nekretnina=${n.nekretninaID}">Izbrisi</a>
								</c:if>
							</c:forEach>
						</c:if>
					</div>
					<div class="row">
						<div class="col-sm">
							<div style="float: left">
								<c:if test="${currPage > 0}">
									<a class="btn-success" href="/nekretnine/svePagination?page=${currPage-1}&sort=${sort}">Prethodna</a>
								</c:if> 
								</div>
								<div style="float: right">
								<c:if test="${currPage < ukupnoStranica-1}">
									<a class="btn-success" href="/nekretnine/svePagination?page=${currPage+1}&sort=${sort}">Sledeca</a>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<%@ include file='../footer.jsp'%>
</body>
</html>