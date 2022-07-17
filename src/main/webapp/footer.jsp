<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="footer">
	<div class="container">
		<div class="row">
            <div class="col-lg-3 col-sm-3">
                   <h4>Informacije</h4>
               		Izdavanje nekretnina Novi Sad
            </div>
            
            <div class="col-lg-3 col-sm-3">
                    <h4>Newsletter</h4>
                    <p>Prijavi se kako bi primao najnovije informacije o nekretninama!</p>
                    <form class="form-inline" role="form" action="newsletter/saveEmail" method="POST">
                            <input name="email" type="email" placeholder="Unesi email adresu" class="form-control">
                                <button class="btn btn-success" type="submit">Prijavi me!</button>
                    </form>
                    <a href="newsletter/new"> Send newsletter </a>
            </div>
            
            <div class="col-lg-3 col-sm-3">
                    <h4>Follow us</h4>
                    <a href="#"><img src="/images/facebook.png" alt="facebook"></a>
                    <a href="#"><img src="/images/twitter.png" alt="twitter"></a>
                    <a href="#"><img src="/images/linkedin.png" alt="linkedin"></a>
                    <a href="#"><img src="/images/instagram.png" alt="instagram"></a>
            </div>

            <div class="col-lg-3 col-sm-3">
                    <h4>Kontaktirajte nas</h4>
         		<p>
				<span class="glyphicon glyphicon-map-marker"></span> Novi Sad <br>
				<span class="glyphicon glyphicon-envelope"></span> nsnekretnine.com<br>
				<span class="glyphicon glyphicon-earphone"></span> (123) 456-7890</p>
            </div>
        </div>
	</div>
</div>

 <!-- Modal -->
	<div id="loginpop" class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="row">
	        <div class="col-sm-6 login">
	        <h4>Login</h4>
	        <div>
	                  <c:if test="${not empty message }">
	                    ${message }<br>
	                  </c:if>
	        </div>
			    <form action="/login" role="form" method="post">
			        <div class="form-group">
			          <label class="sr-only" >Username</label>
			          <input type="text" class="form-control" placeholder="Username" name="username">
			        </div>
			        <div class="form-group">
			          <label class="sr-only">Password</label>
			          <input type="password" class="form-control" placeholder="Password" name="password">
			        </div>
			        <input type="submit" class="btn btn-success" value="Uloguj se">
			    </form>          
	        </div>
	        <div class="col-sm-6">
		          <h4>Novi korisnik?</h4>
		          <div class="form-control">
		                      <p>Nemate nalog? <a href="/korisnik/registracijaPage">Registrujte se!</a></p>
		          </div>
	        </div>
	
	      </div>
	    </div>
	  </div>
	</div>
  

</body>
</html>



