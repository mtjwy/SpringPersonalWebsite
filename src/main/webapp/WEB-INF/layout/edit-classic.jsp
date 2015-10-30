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
<link rel="stylesheet" type="text/css" href="/resources/css/css-markdown.css"/>

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
				<a class="blog-nav-item  ${current == 'rss-feed' ? 'active' : '' }" href="/rss-feed.html">Rss Feed</a>
				
				<security:authorize access="! isAuthenticated()">
					<a class="blog-nav-item ${current == 'login' ? 'active' : '' }" href='<spring:url value="/login.html"/>'>Login</a>
					<a class="blog-nav-item ${current == 'user-register' ? 'active' : '' }" href='<spring:url value="/register.html"/>'>Register</a>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
					<a class="blog-nav-item " href='<spring:url value="/logout.html"/>'>Logout</a>
					
				</security:authorize>
				
				
				<security:authorize access="isAuthenticated()">
				<a class="blog-nav-item ${current == 'account-detail' ? 'active' : '' }" href='<spring:url value="/account.html"/>'>My RSS Feed</a>	
				<a class="blog-nav-item ${current == 'my-articles' ? 'active' : '' }" href='<spring:url value="/my-articles.html"/>'>My Articles</a>
				<a class="blog-nav-item ${current == 'article-category' ? 'active' : '' }" href='<spring:url value="/article-category.html"/>'>Write Articles</a>
				</security:authorize>
				
				<security:authorize access="hasRole('ROLE_ADMIN')"> 
					<a class="blog-nav-item ${current == 'users' ? 'active' : '' }" href='<spring:url value="/users.html"/>'>Users</a>
				</security:authorize>
				
				<a class="blog-nav-item" href="#">About</a>
			</nav>
		</div>
	</div>

	<div class="container">

		<tiles:insertAttribute name="body" />

	</div>
	<!-- /.container -->

	<footer class="blog-footer">
		<tiles:insertAttribute name="footer" />
	</footer>

	
</body>
</html>




