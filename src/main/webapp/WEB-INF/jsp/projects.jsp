<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>

<link rel="stylesheet" type="text/css" href="/resources/css/carousel.css"/>


<div class="blog-header">
			<h1 class="blog-title">Projects </h1>
			<p class="lead blog-description"> October 28, 2015 </p>
</div>



<div class="col-sm-8 blog-main">

<div class=" well">
<h2>SpringPersonalWebsite</h2>
<ul>
  <li>Source code: <a href="https://github.com/mtjwy/SpringPersonalWebsite" target="_blank">https://github.com/mtjwy/SpringPersonalWebsite</a></li>
  <li>It&rsquo;s also the source code of this website.</li>
  <li>Year: October, 2015</li>
  <li>SpringPersonalWebsite is a clean-design personal website implemented with Spring MVC. This website also provides a RSS Feed Aggregation service for registered users. <a href="https://yuwu.herokuapp.com" target="_blank">https://yuwu.herokuapp.com</a>.</li>
  <li>Technology: Spring MVC/JPA + Hibernate + HyperSQL DataBase + Bootstrap + JQuery + JAXB</li>
</ul>

</div>

<div class=" well">
<h2>Android game published on Google Play</h2>
<ul>
  <li><a href="https://play.google.com/store/apps/details?id=com.lamaryw.InsectSmasher" target="_blank">See it on Google Play</a></li>
  <li>Source code: <a href="https://github.com/mtjwy/InsectSmasher" target="_blank">https://github.com/mtjwy/InsectSmasher</a></li>
  <li>Year: July, 2015</li>
  <li>Insect Smasher is an entertaining 2D video game implemented with Android Graphics library. </li>
  <li>Tools: Android + Java + Eclipse</li>
</ul>

</div>

 <div class=" well">    
    <h2>Watts-Strogatz Small World Simulation</h2>
	<ul>
	  <li>Source code: <a href="https://github.com/mtjwy/WattsStrogatzSmallWorld" target="_blank">https://github.com/mtjwy/WattsStrogatzSmallWorld</a></li>
	  <li>Year: May, 2015</li>
	  <li>This project is to simulate a small-world graph according to Watts-Strogatz Model. The goal is to be able to observe the process of small-world graph formation, also to understand its properties through simulation.</li>
	  <li>Tools: Java + Eclipse</li>
	</ul>
	
</div>
	
<!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="/resources/images/game.png" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Android Game On Google Play</h1>
              <p><a class="btn btn-lg btn-primary" href="https://play.google.com/store/apps/details?id=com.lamaryw.InsectSmasher" target="_blank" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        
        
        <div class="item">
          <img class="second-slide" src="/resources/images/springwebsite.png" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Entity Diagram of This Website</h1>
              <p><a class="btn btn-lg btn-primary" href="https://yuwu.herokuapp.com" target="_blank" role="button">Home page</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="/resources/images/smallworld.png" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Small World Connection</h1>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->

<br>
</div>

