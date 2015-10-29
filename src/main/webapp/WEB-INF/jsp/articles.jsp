<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">Latest Articles</h1>
			<p class="lead blog-description">Sorted by published date.</p>
		</div>

<div class="col-sm-8 blog-main">

<c:forEach items="${articles}" var="article">
  		
<div class="blog-post">
	<h2 class="blog-post-title"><a href="#">${article.title}</a></h2>
	<p class="blog-post-meta">
		 
		<fmt:formatDate value="${article.publishDate}" pattern="yyyy-MM-dd"/>
		&nbsp &nbsp &nbsp
		Category: <a href="#">${article.articleCategory.name}</a>
	</p>
	

	<p>${article.description}</p>
	<hr>
	
</div>
<!-- /.blog-post -->

</c:forEach>

</div>
