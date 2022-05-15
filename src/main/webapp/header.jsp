<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Realestate Bootstrap Theme</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="/assets/style.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.js"></script>
<script src="/assets/script.js"></script>



<!-- Owl stylesheet -->
<link rel="stylesheet" href="/assets/owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="/assets/owl-carousel/owl.theme.css">
<script src="/assets/owl-carousel/owl.carousel.js"></script>
<!-- Owl stylesheet -->


<!-- slitslider -->
<link rel="stylesheet" type="text/css"
	href="/assets/slitslider/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="/assets/slitslider/css/custom.css" />
<script type="text/javascript"
	src="/assets/slitslider/js/modernizr.custom.79639.js"></script>
<script type="text/javascript"
	src="/assets/slitslider/js/jquery.ba-cond.min.js"></script>
<script type="text/javascript"
	src="/assets/slitslider/js/jquery.slitslider.js"></script>
<!-- slitslider -->


</head>
<body>
	<!-- Header Starts -->
	<div class="navbar-wrapper">

		<div class="navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">


					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>


				<!-- Nav Starts -->
				<div class="navbar-collapse  collapse">
					<ul class="nav navbar-nav navbar-right">
							<li><a href="/">Pocetna stranica</a>
							<li><a href="/nekretnine/unosNekretnine">Unos nekretnine</a> 
							<li><a href="/oglasi/sviPagination">Moji oglasi</a> 
							<li><a href="/nekretnine/svePagination">Moje nekretnine</a> 
							<li><a href="/korisnik/agenti">Agenti</a>
							
							<c:if test="${ user.uloga == \"admin\"}">
               					 <li><a href="/agencija/dodajAgencijuPage">Unos agencije</a></li>
              				</c:if>
							
							<c:if test="${empty user}">
               			 		<li><button class="btn btn-info" data-toggle="modal" data-target="#loginpop">Login</button></li>
              				</c:if>
							<c:if test="${!empty user}">
               		 			<li><a href="/korisnik/logout">Log out</a></li>
              				</c:if>
					</ul>
				</div>
				<!-- #Nav Ends -->

			</div>
		</div>

	</div>

	<div class="container">

		<!-- Header Starts -->
		<div class="header">
			<a href="/"><img src="/images/logo.png" alt="For Rent"
				width="100px" height="100px"></a>
			<c:if test="${!empty poruka} ">
				<div class="form-control">${poruka}</div>
			</c:if>
			<c:if test="${!empty message} ">
				<div class="form-control">${poruka}</div>
			</c:if>
		</div>
		<!-- #Header Starts -->
	</div>
</body>
</html>