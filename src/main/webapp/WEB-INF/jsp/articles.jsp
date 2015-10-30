<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">All Articles</h1>
			<p class="lead blog-description">Sorted by published date.</p>
		</div>

<div class="col-sm-8 blog-main">


	   

<c:forEach items="${articles}" var="article">

	
<div class=" well">
	<h2 ><a href="/article/${article.id }.html">${article.title}</a></h2>
	<p class="blog-post-meta"> 
		<fmt:formatDate value="${article.publishDate}" pattern="yyyy-MM-dd"/>
		&nbsp &nbsp &nbsp
		Category: <a href="/articleCategory/${article.articleCategory.id }.html">${article.articleCategory.name}</a>
	</p>
	Summary: &nbsp ${article.description}	
</div>
<!-- /.blog-post -->

</c:forEach>




</div>

