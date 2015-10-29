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

    
      <!-- Jumbotron -->
      <div class="jumbotron marketing">
        <h1>Marketing stuff!</h1>
        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">Get started today</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>Safari bug warning!</h2>
          <p class="text-danger">As of v8.0, Safari exhibits a bug in which resizing your browser horizontally causes rendering errors in the justified nav that are cleared upon refreshing.</p>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-lg-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>
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