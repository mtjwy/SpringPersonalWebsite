<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				<td>${user.name}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</div>
