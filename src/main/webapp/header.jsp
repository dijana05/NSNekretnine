<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<html lang="en"  xmlns:th="http://www.thymeleaf.org"
    				xmlns:sec="http://www.thymeleaf.org">
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
						
							<li><a href="/oglasi/sviPagination">Oglasi</a>
							 
							<sec:authorize access="isAuthenticated()">
								<li><a href="/nekretnine/unosNekretnine">Unos nekretnine</a></li>
								<li><a href="/oglasi/sviPagination?user=id">Moji Oglasi</a> </li><!-- TO DO -->
								<li><a href="/nekretnine/svePagination?">Moje nekretnine</a> </li><!-- TO DO -->
							</sec:authorize>
							
							<li><a href="/agenti">Agenti</a>
							
							<sec:authorize access="hasAuthority('ADMIN')">
               					 <li><a href="/agencija/dodajAgencijuPage">Unos agencije</a></li>
               					 <li><a href="/">Izvestaji</a></li>
              				</sec:authorize>
							
							<sec:authorize access="!isAuthenticated()">
               			 		<li><button class="btn btn-info" data-toggle="modal" data-target="#loginpop">Login</button></li>
              				</sec:authorize>
							<sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
								<li><a href="/">Moj profil</a></li>
               		 			<li><a href="/logout">Log out</a></li>
              				</sec:authorize>
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
			<c:if test="${!empty message} ">
				<div class="form-control">${message}</div>
			</c:if>
			<c:if test="${!empty message} ">
				<div class="form-control">${message}</div>
			</c:if>
		</div>
		<!-- #Header Starts -->
	</div>
</body>
</html>