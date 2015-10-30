<!DOCTYPE html>

<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">Article Category</h1>
			<p class="lead blog-description">Good good study, day day up!</p>
</div>

<div class="col-sm-8 blog-main">

<form:form commandName="article-category" cssClass="form-horizontal">
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New Article Category
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"> New Article Category</h4>
      </div>
      <div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
						</div>
					</div>
							
	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save"/>
      </div>
    </div>
  </div>
</div>

</form:form>

<br> <br>
<!-- Nav tabs -->
<ul class="nav nav-pills" role="tablist">
  	<c:forEach items="${user.articleCategories}" var="category">
  		<li ><a href="#category_${category.id}" data-toggle="tab">${category.name}</a></li>	
  	</c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">

<c:forEach items="${user.articleCategories}" var="category">
	<div role="tabpanel" class="tab-pane " id="category_${category.id}">
	<br>
	<h3><a href='<spring:url value="/${category.id}/new-article.html"/>' class="btn btn-success"> new article</a></h3>
	<p></p>
	
	<table class="table table-bordered table-hover table-striped">
		<colgroup>
       		<col span="1" style="width: 55%;">
       		<col span="1" style="width: 20%;">	
       		<col span="1" style="width: 10%;">
       		<col span="1" style="width: 15%;">
    	</colgroup>
		
		<tbody>
			<c:forEach items="${category.articles}" var="article">
				<tr>
					<td><a href="/article/${article.id }.html">${article.title}</a></td>
					<td><fmt:formatDate type="both"  value="${article.publishDate}" /></td>
					
					<td>
					<a href='<spring:url value="/edit/${article.id }.html"/>' class="btn btn-warning"> edit</a>
					</td>
					
					<td>
					<a href="<spring:url value="/article-category/articles/remove/${article.id}.html" />" class="btn btn-danger triggerRemove">
						remove 
					</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	
	</table>
	
	</div>
</c:forEach>

</div><!-- End Tab panes -->

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove article</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>

</div>

<script type="text/javascript">
	
		$(document).ready(function(){
			$('.nav-pills a:first').tab('show'); // Select first tab
		});
		
		$('.triggerRemove').click(function(e) {
			e.preventDefault(); //prevent default action, which is going to a link
			$('#modalRemove .removeBtn').attr("href", $(this).attr("href"));
			$('#modalRemove').modal();
		});
</script>


