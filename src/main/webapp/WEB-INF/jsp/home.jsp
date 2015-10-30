<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->


<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Custom styles for this template -->
<!-- <link href="http://getbootstrap.com/examples/blog/blog.css" -->
<!-- 	rel="stylesheet"> -->

<!-- <link rel="stylesheet" type="text/css" href="css/blog.css"/> -->
<link rel="stylesheet" type="text/css" href="/resources/css/blog.css"/>

<link rel="stylesheet" type="text/css" href="/resources/css/justified-nav.css"/>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- Placed at the end of the document has caused conflict!!! so I move them to header -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript" 
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
	
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<tilesx:useAttribute name="current" scope="request" />

</head>

<body>
	<tilesx:useAttribute name="current" />
	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item  ${current == 'index' ? 'active' : '' }" href="/">Home</a> 
				<a class="blog-nav-item  ${current == 'home' ? 'active' : '' }" href="/home.html">Home new</a>
				
				<a class="blog-nav-item  ${current == 'projects' ? 'active' : '' }" href="/projects.html">Projects</a> 
				
				<a class="blog-nav-item  ${current == 'articles' ? 'active' : '' }" href="/articles.html">Articles</a>
				
				<security:authorize access="! isAuthenticated()">
					<a class="blog-nav-item ${current == 'login' ? 'active' : '' }" href='<spring:url value="/login.html"/>'>Login</a>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
					<a class="blog-nav-item ${current == 'account-detail' ? 'active' : '' }" href='<spring:url value="/account.html"/>'>My RSS Feed</a>
					<a class="blog-nav-item " href='<spring:url value="/logout.html"/>'>Logout</a>
				</security:authorize>
				<a class="blog-nav-item ${current == 'user-register' ? 'active' : '' }" href='<spring:url value="/register.html"/>'>Register</a>
				
				<security:authorize access="hasRole('ROLE_ADMIN')"> 
					<a class="blog-nav-item ${current == 'users' ? 'active' : '' }" href='<spring:url value="/users.html"/>'>Users</a>
					<a class="blog-nav-item ${current == 'article-category' ? 'active' : '' }" href='<spring:url value="/article-category.html"/>'>Add Article</a>
				</security:authorize>
				
				<a class="blog-nav-item" href="#">About</a>
			</nav>
		</div>
	</div>

	<div class="container">
	  <br>

      <!-- Jumbotron -->
      <div class="jumbotron marketing">
        <h1 id="need-you-white" class="white">Welcome !</h1>
        <h3 class="white"> Self-study project for exploring awesome features in SpringMVC web programming.Post articles, Manage RSS Feed. Review the past and look forward to the future.</h3>
        <p><a class="btn btn-lg btn-success" href='<spring:url value="/register.html"/>' role="button">Get started today</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>See Source Code Of This Website</h2>
          <p class="text-danger">This website is developed with Spring MVC/JPA + Hibernate + HyperSQL DataBase + Bootstrap + JQuery + JAXB. Source code of this website is post on Github. </p>
          <p>Click button to go to Github and see source code.</p>
          <p><a class="btn btn-primary" href="https://github.com/mtjwy/SpringPersonalWebsite" target="_blank" role="button">See source code &raquo;</a></p>
        </div>
        <div class="col-lg-4">
          <h2>What This Website Can Do </h2>
          <p>Registered users can write and manage articles on this website. It also offers a RSS Feed Aggregation service. Click button bellow to see demo.</p>
          <p><a class="btn btn-primary" href="#" role="button">See demo &raquo;</a></p>
       </div>
        <div class="col-lg-4">
          <h2>More Projects</h2>
          <p>See my other projects.</p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>
     </div> 
	<!-- /.container -->

	<footer class="blog-footer">
		<tiles:insertAttribute name="footer" />
	</footer>


</body>
</html>
