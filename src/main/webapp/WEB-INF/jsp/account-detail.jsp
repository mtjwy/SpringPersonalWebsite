<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>



<div class="blog-header">
			<h1 class="blog-title"><c:out value="${user.name}" />'s RSS Feed</h1>
			<p class="lead blog-description">Show <c:out value="${user.name}" />'s blogs</p>
</div>

<div class="col-sm-8 blog-main">

<form:form commandName="blog" cssClass="form-horizontal blogForm">
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New blog
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">New blog</h4>
      </div>
      <div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">Url:</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url" />
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



<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
  	<c:forEach items="${user.blogs}" var="blog">
  		<li ><a href="#blog_${blog.id}" data-toggle="tab"><c:out value="${blog.name}" /></a></li>	
  	</c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">

<c:forEach items="${user.blogs}" var="blog">
	<div role="tabpanel" class="tab-pane " id="blog_${blog.id}">
	
	<h1><c:out value="${blog.name}" /></h1>
	<p>
	<a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger triggerRemove">remove blog</a>
		<c:out value="${blog.url}" /> </p>
	
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Date</th>
				<th>Item</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					
					<td><c:out value="${item.publishDate}" /></td>
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

 <!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
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
			$('.nav-tabs a:first').tab('show'); // Select first tab
		});
		
		$('.triggerRemove').click(function(e) {
			e.preventDefault(); //prevent default action, which is going to a link
			$('#modalRemove .removeBtn').attr("href", $(this).attr("href"));
			$('#modalRemove').modal();
		});
		
		$(".blogForm").validate(
				{
					rules: {
						name: {
							required : true,
							minlength : 1
						},
				
						url: {
							required : true,
							url : true
						}
		
					},
					highlight: function(element) {
						$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
					},
					unhighlight: function(element) {
						$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
					}
					//refer to http://getbootstrap.com/css/  Validation states
					
				}
		);
</script>



