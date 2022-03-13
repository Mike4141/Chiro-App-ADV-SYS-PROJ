<%-- 
    Document   : clientUpdate
    Created on : Mar 13, 2022, 3:56:26 PM
    Author     : jeffe
--%>
<%@page import="business.ClientBO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <meta http-equiv="X-UA-Compatible" content="ie=edge">


  <title>Marietta Spine Clinic</title>

  <link rel="stylesheet" href="assets/css/maicons.css">

  <link rel="stylesheet" href="assets/css/bootstrap.css">

  <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.carousel.css">

  <link rel="stylesheet" href="assets/vendor/animate/animate.css">

  <link rel="stylesheet" href="assets/css/theme.css">
</head>
<body>

  <!-- Back to top button -->
  <div class="back-to-top"></div>

  <header>
    <div class="topbar">
      <div class="container">
        <div class="row">
          <div class="col-sm-8 text-sm">
            <div class="site-info">
              <a href="#"><span class="mai-call text-primary"></span> 777-333-4444</a>
              <span class="divider">|</span>
              <a href="#"><span class="mai-mail text-primary"></span> MariettaSpineClinic@gmail.com</a>
            </div>
          </div>
          <div class="col-sm-4 text-right text-sm">
            <div class="social-mini-button">
              <a href="#"><span class="mai-logo-facebook-f"></span></a>
              <a href="#"><span class="mai-logo-twitter"></span></a>
              <a href="#"><span class="mai-logo-dribbble"></span></a>
              <a href="#"><span class="mai-logo-instagram"></span></a>
            </div>
          </div>
        </div> <!-- .row -->
      </div> <!-- .container -->
    </div> <!-- .topbar -->

    <nav class="navbar navbar-expand-lg navbar-light shadow-sm">
      <div class="container">
        <a class="navbar-brand" href="#"><span class="text-primary">Marietta</span> Spine Clinic</a>


        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupport" aria-controls="navbarSupport" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupport">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.html">Home</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="about.html">About Us</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="doctors.html">Doctors</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">FAQ's</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Scheduling</a>
            </li>
            <li class="nav-item">
              <a class="btn btn-primary ml-lg-3" href="clientlogin.html">Login / Register</a>
            </li>
          </ul>
        </div> <!-- .navbar-collapse -->
      </div> <!-- .container -->
    </nav>
  </header>


  <form action="ClientUpdateServlet" method="post">

      <% ClientBO c1;
        c1=(ClientBO)session.getAttribute("c1");
        c1.display(); %>
      
    <br>
    </br>

      <center><img src="assets/img/logo.jpg" width="250" height="200" alt="logo" class="center"></center>
        <center><p>Update your personal information below.</p></center>

        <div class="container">
    <div class="title">Information</div>
    <div class="content">
      
        <div class="user-details">
          <div class="input-box">
            <span class="details">First Name</span>
            <input type="text" name="FN" value="<%=c1.getCustFN()%>"  required>
          </div>
          <div class="input-box">
            <span class="details">Last Name</span>
            <input type="text" name='LN' value="<%=c1.getCustLN()%>"  required>
          </div>
            
            <div class="input-box">
            <span class="details">Password</span>
            <input type="text" name='PW' value="<%=c1.getCustPW()%>"  required>
          </div>
            <div class="input-box">
            <span class="details">Address</span>
            <input type="text" name='AD' value="<%=c1.getCustAddr()%>"  required>
          </div> 
          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" name='EM' value="<%=c1.getCustEmail()%>"  required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="text" name='PH' value="<%=c1.getCustPhone()%>"  required>
          </div>
            

            
        <div class="button">
          <input type="submit" value="Update">
        </div>
      </form>
    </div>
  </div>
  <footer class="page-footer">
    <div class="container">
      <div class="row px-md-3">
        <div class="col-sm-6 col-lg-3 py-3">
          <h5>Our Practice</h5>
          <ul class="footer-menu">
            <li><a href="#">About Us</a></li>
            <li><a href="#">FAQ's</a></li>
            <li><a href="#">Our Doctors</a></li>
          </ul>
        </div>
        <div class="col-sm-6 col-lg-3 py-3">
          <h5>Portals</h5>
          <ul class="footer-menu">
            <li><a href="clientlogin.html">Client Login</a></li>
            <li><a href="doctorlogin.html">Doctor Login</a></li>
            <li><a href="adminlogin.html">Admin Login</a></li>
          </ul>
        </div>
        <div class="col-sm-6 col-lg-3 py-3">
          <h5>Our partners</h5>
          <ul class="footer-menu">
            <li><a href="#">Kirsten Thomas</a></li>
            <li><a href="#">Christopher Sywak</a></li>
            <li><a href="#">Victor Bula</a></li>
            <li><a href="#">Michael Childs</a></li>
            <li><a href="#">Jefferson Behrens</a></li>
          </ul>
        </div>
        <div class="col-sm-6 col-lg-3 py-3">
          <h5>Contact</h5>
          <p class="footer-link mt-2">980 South Cobb Dr Marietta, GA 30060</p>
          <a href="#" class="footer-link">770-333-4444</a>
          <a href="#" class="footer-link">MariettaSpineClinic@gmail.com</a>
        </div>
      </div>

      <hr>

      <p id="copyright">Copyright &copy; 2022 <a href="#" target="_blank">Marietta Spine Clinic</a>. All right reserved</p>
    </div>
  </footer>

<script src="assets/js/jquery-3.5.1.min.js"></script>

<script src="assets/js/bootstrap.bundle.min.js"></script>

<script src="assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>

<script src="assets/vendor/wow/wow.min.js"></script>

<script src="assets/js/theme.js"></script>

</body>
</html>

