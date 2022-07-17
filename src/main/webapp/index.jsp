<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aplikacija za oglasavanje nekretnina</title>
</head>
<body>

<%@ include file="header.jsp" %>

<div class="">
      <div id="slider" class="sl-slider-wrapper">

        <div class="sl-slider">
        
          <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">
            <div class="sl-slide-inner">
              <div class="bg-img bg-img-1" style="background-image: url(/images/uploads/${hit[0].nekretnina.slikeNazivi[0]});"></div>
              <c:set var = "tekst" value = "${hit[0].tekst}"/>
	        	<h4>${fn:substring(tekst,0,20)}</h4>
              <blockquote>              
              <p class="location"><span class="glyphicon glyphicon-map-marker"></span> Novi Sad, Serbia</p>
              <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
              <cite>${hit[0].cena}&#8364;</cite>
              </blockquote>
            </div>
          </div>
          
          <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
            <div class="sl-slide-inner">
              <div style="background-image: url(/images/uploads/${hit[1].nekretnina.slikeNazivi[0]});"></div>
              <c:set var = "tekst" value = "${hit[1].tekst}"/>
	        	<h4>${fn:substring(tekst,0,20)}</h4>
              <blockquote>              
              <p class="location"><span class="glyphicon glyphicon-map-marker"></span> Novi Sad, Serbia</p>
              <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
              <cite>${hit[1].cena}&#8364;</cite>
              </blockquote>
            </div>
          </div>
          
          <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
            <div class="sl-slide-inner">
             <div class="bg-img bg-img-1" style="background-image: url(/images/uploads/${hit[2].nekretnina.slikeNazivi[0]});"></div>
              <c:set var = "tekst" value = "${hit[2].tekst}"/>
	        	<h4>${fn:substring(tekst,0,20)}</h4>
              <blockquote>              
              <p class="location"><span class="glyphicon glyphicon-map-marker"></span> Novi Sad, Serbia</p>
              <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
              <cite>${hit[2].cena}&#8364;</cite>
              </blockquote>
            </div>
          </div>
          
          <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="-5" data-slice2-rotation="25" data-slice1-scale="2" data-slice2-scale="1">
            <div class="sl-slide-inner">
              <div class="bg-img bg-img-1" style="background-image: url(/images/uploads/${hit[3].nekretnina.slikeNazivi[0]});"></div>
              <c:set var = "tekst" value = "${hit[3].tekst}"/>
	        	<h4>${fn:substring(tekst,0,20)}</h4>
              <blockquote>              
              <p class="location"><span class="glyphicon glyphicon-map-marker"></span> Novi Sad, Serbia</p>
              <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
              <cite>${hit[3].cena}&#8364;</cite>
              </blockquote>
            </div>
          </div>
          
          <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-5" data-slice2-rotation="10" data-slice1-scale="2" data-slice2-scale="1">
            <div class="sl-slide-inner">
               <div class="bg-img bg-img-1" style="background-image: url(/images/uploads/${hit[4].nekretnina.slikeNazivi[0]});"></div>
              <c:set var = "tekst" value = "${hit[4].tekst}"/>
	        	<h4>${fn:substring(tekst,0,20)}</h4>
              <blockquote>              
              <p class="location"><span class="glyphicon glyphicon-map-marker"></span> Novi Sad, Serbia</p>
              <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
              <cite>${hit[4].cena}&#8364;</cite>
              </blockquote>
            </div>
          </div>
        </div><!-- /sl-slider -->



        <nav id="nav-dots" class="nav-dots">
          <span class="nav-dot-current"></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </nav>

      </div><!-- /slider-wrapper -->
</div>



<div class="banner-search">
  <div class="container"> 
    <!-- banner -->
    <h3>Pretrazi oglase</h3>
    <div class="searchbar">
      <div class="row">
        <div class="col-lg-6 col-sm-6">
          <form action="/oglasi/sviPagination" method="get">
            <div class="row">
              <div class="col-lg-3 col-sm-3 ">
                <select class="form-control">
                  <option>Izdavanje</option>
                </select>
              </div>
              <div class="col-lg-3 col-sm-4">
                <select name="cena" class="form-control">
                  <option value="10">vise od 1000e</option>
                  <option value="4">500e-1000e</option>
                  <option value="2">250e-500e</option>
                  <option value="1"> manje od 250e </option>
                </select>
              </div>
              <div class="col-lg-3 col-sm-4">
              <select name="tip" class="form-control">
                  <option value="Stan">Stan</option>
                  <option value="Kuca">Kuca</option>
                  <option value="Plac">Plac</option>
                  <option value="Lokal">Lokal</option>
                </select>
              </div>
              <div class="col-lg-3 col-sm-4">
                <input class="btn btn-success"  type="submit" value="Pretrazi"> 
              </div>
            </div>
          </form>
          
        </div>
        <div class="col-lg-5 col-lg-offset-1 col-sm-6 ">
        	<c:if test="${empty user}">
          		<p>Prijavi se kako bi postavljao oglase i dobijao najnovije ponude</p>
          		<button class="btn btn-info" data-toggle="modal" data-target="#loginpop">Login</button>        
          	</c:if>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- banner -->
<div class="container">
  <div class="properties-listing spacer"> <a href="/oglasi/sviAktivniOglasi" class="pull-right viewall">View All Listing</a>
    <h2>Svi oglasi</h2>
    <div id="owl-example" class="owl-carousel">
      <c:if test="${!empty sviOglasi}">
        <c:forEach var="oglas" items="${sviOglasi}">

          <div class="properties">
            <div class="image-holder"><img src="/images/uploads/${oglas.nekretnina.slikeNazivi[0]}" class="img-responsive" alt="properties"/>
             	<c:if test="${oglas.status eq 'aktivan'}"> <div class="status sold">${oglas.status }</div></c:if>
				<c:if test="${oglas.status eq 'izdat'}"><div class="status new">${oglas.status }</div></c:if>
            </div>
             <c:set var = "tekst" value = "${oglas.tekst}"/>
            <h4><a href="/oglasi/prikazOglasa?id=${oglas.oglasID}">${fn:substring(tekst,0,20)}</a></h4>
            <p class="price">${oglas.cena}e</p>
            <p>${oglas.nekretnina.tip }</p>
            <a class="btn btn-primary" href="/oglasi/prikazOglasa?id=${oglas.oglasID}">Vise</a>
          </div>

        </c:forEach>
      </c:if>
    </div>
  </div>
 
 </div>
  <c:if test="${!empty mapa }">
 	<h3>Koriste�i nasu aplikaciju korisnici su do sada izdali:</h3> 
	  <c:forEach var="item" items="${mapa }">
	  	<div class="form-control">${item.key} : ${item.value}</div>
	  
	  </c:forEach>
  </c:if>
  
<%@ include file="footer.jsp" %>



</body>
</html>