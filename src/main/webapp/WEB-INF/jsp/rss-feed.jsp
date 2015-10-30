<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>



<div class="blog-header">
			<h1 class="blog-title"><c:out value="${user.name}" />'s RSS Feed</h1>
			<p class="lead blog-description">Show <c:out value="${user.name}" />'s blogs</p>
</div>



<!-- Nav tabs -->
<ul class="nav nav-pills" role="tablist">
  	<c:forEach items="${user.blogs}" var="blog">
  		<li ><a href="#blog_${blog.id}" data-toggle="tab"><c:out value="${blog.name}" /></a></li>	
  	</c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">

<c:forEach items="${user.blogs}" var="blog">
	<div role="tabpanel" class="tab-pane " id="blog_${blog.id}">
	
	<table class="table table-bordered table-hover table-striped">
		<colgroup>
       		<col span="1" style="width: 12%;">
       		<col span="1" style="width: 88%;">	
    	</colgroup>
		<thead>
			<tr>
				<th>Date</th>
				<th>News</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					
					<td><fmt:formatDate type="both"  value="${item.publishDate}" /></td>
					
					<td>
						<strong>
							<a href="<c:out value="${item.link}" />" target="_blank">
								<c:out value="${item.title}" />
							</a>
						</strong>
						<br />
						${item.description}
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	
	</table>
	
	</div>
</c:forEach>

</div><!-- End Tab panes -->



<script type="text/javascript">
	
		$(document).ready(function(){
			$('.nav-pills a:first').tab('show'); // Select first tab
		});
		
</script>



