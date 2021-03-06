<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oglasi</title>
</head>
<body>

	
<!-- banner -->
<div class="inside-banner">
  <div class="container"> 
    <span class="pull-right"><a href="/">Home</a> / Oglasi</span>
    <h2>Prikaz oglasa</h2>
</div>
</div>
<!-- banner -->
<%@ include file="../header.jsp" %>

<sec:authorize access="isAuthenticated()">
	<c:set var="userID">
		<sec:authentication property="principal.korisnikID"/>
	</c:set>
</sec:authorize>


<div class="container">
<div class="properties-listing spacer">

<div class="row">
<div class="col-lg-3 col-sm-4 ">

  <div class="search-form"><h4><span class="glyphicon glyphicon-search"></span> Pretraga oglasa</h4>
       <form action="/oglasi/sviPagination" method="get">
          <div class="row">
            <div class="col-lg-5">
              <select class="form-control">
                <option>Izdavanje</option>
              </select>
            </div>
            <div class="col-lg-7">
              <select name="cena" class="form-control">
                  <option value="10">vise od 1000e</option>
                  <option value="4">500e-1000e</option>
                  <option value="2">250e-500e</option>
                  <option value="1"> manje od 250e </option>
              </select>
                
            </div>
          </div>

          <div class="row">
	          <div class="col-lg-12">
	             <select name="tip" class="form-control">
	                  <option value="Stan">Stan</option>
	                  <option value="Kuca">Kuca</option>
	                  <option value="Plac">Plac</option>
	                  <option value="Lokal">Lokal</option>
	                </select>
	          </div>
          </div>
          
          <input type="hidden" name="id" value=${userID }>
          
          <input class="btn btn-success"  type="submit" value="Pretrazi">
      </form>
  </div>

</div>
<div class="col-lg-9 col-sm-8">

<div class="message">
	${message}
</div>

<div class="row">
	<div class="row">
    <c:if test="${!empty sviOglasi}">
      <c:forEach var="oglas" items="${sviOglasi}">
	     <!-- properties -->
	      <div class="col-lg-4 col-sm-6">
	      <div class="properties">		
			        <div class="image-holder">
					<img src="/images/uploads/${oglas.nekretnina.slikeNazivi[0]}" class="img-responsive" /> 	         
							<c:if test="${oglas.status eq 'aktivan'}"> <div class="status sold">${oglas.status }</div></c:if>
							<c:if test="${oglas.status eq 'izdat'}"><div class="status new">${oglas.status }</div></c:if>
			        </div>
	        <c:set var = "tekst" value = "${oglas.tekst}"/>
	        <h4><a href="/oglasi/prikazOglasa?id=${oglas.oglasID}">${fn:substring(tekst,0,30)}</a></h4>
	        <p class="price">${oglas.cena}e</p>
	        <p>${oglas.nekretnina.tip }</p>
	        <a class="btn btn-primary" href="/oglasi/prikazOglasa?id=${oglas.oglasID}">Vise</a>
	      </div>
	      </div>
	      <!-- properties -->
	  </c:forEach>
	</c:if>
	</div>
	<div class="row">
		<div class="col-sm">
		Stranica broj ${currPage+1}
		od ${ukupnoStranica }<br>
		Broj oglasa ${ukupnoOglasa }
		</div>
		
		<div class="col-sm">
			<div style="float: left">
			<c:if test="${currPage > 0}">
				<a class="btn-success" href="/oglasi/sviPagination?page=${currPage-1}&tip=${tip}&cena=${cena}&id=${userID}">Prethodna</a>
			</c:if> 
			</div>
			<div style="float: right">
			<c:if test="${currPage < ukupnoStranica-1}">
				<a class="btn-success" href="/oglasi/sviPagination?page=${currPage+1}&tip=${tip}&cena=${cena}&id=${userID}">Sledeca</a>
			</c:if>
			</div>
		</div>
	</div>
	
	
	<c:if test="${empty sviOglasi}">
		<div class="form-control">
			Nema oglasa po trazenim parametrima
		</div>
	
	</c:if>

    </div>
  </div>
</div>
</div>
</div>

<%@ include file="../footer.jsp" %>

</body>
</html>