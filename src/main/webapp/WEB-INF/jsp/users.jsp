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
					<a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger">
						remove 
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</div>
