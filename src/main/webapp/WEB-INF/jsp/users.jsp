<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">All Users</h1>
			<p class="lead blog-description">Show all the users in database</p>
		</div>

<div class="col-sm-8 blog-main">

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>user name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
		
				<td>
					<a href="<spring:url value="/users/${user.id}.html" />" >
						${user.name} 
					</a>
				</td>
				
				<td>
					<a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger triggerRemove">
						remove 
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove user</h4>
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
		
		$('.triggerRemove').click(function(e) {
			e.preventDefault(); //prevent default action, which is going to a link
			$('#modalRemove .removeBtn').attr("href", $(this).attr("href"));
			$('#modalRemove').modal();
		});
</script>
