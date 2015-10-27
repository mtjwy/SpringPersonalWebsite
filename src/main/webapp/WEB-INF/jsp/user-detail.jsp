<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">${user.name} Detail</h1>
			<p class="lead blog-description">Show ${user.name}'s detail information</p>
</div>

<div class="col-sm-8 blog-main">


<c:forEach items="${user.articleCategories}" var="articleCategory">
	<c:forEach items="${articleCategory.articles}" var="article">

	<div class="blog-post">
	<h2 class="blog-post-title">${article.title}</h2>
	<p class="blog-post-meta">
		${article.publishDate} by <a href="#">${articleCategory.webUser.name}</a>
	</p>

	<p>
		${article.content}
	</p>
	
	</div>
	<!-- /.blog-post -->

	</c:forEach>
</c:forEach>


</div>
