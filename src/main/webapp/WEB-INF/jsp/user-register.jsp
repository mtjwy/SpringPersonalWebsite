<!DOCTYPE html >

<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">Create a new account</h1>
			<p class="lead blog-description">register</p>
</div>

<div class="col-sm-8 blog-main">

<form:form commandName="webuser" cssClass="form-horizontal registrationForm">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successful!</div>
	</c:if>
	
	<div class="form-group">
		<div class="col-sm-4 "></div>
	
		<div class="col-sm-6 ">
			<form:input path="name" cssClass="form-control" placeholder="Name"/>
			<form:errors path="name" />
		</div>
		
	</div>
	
	<div class="form-group">
		<div class="col-sm-4 "></div>
		<div class="col-sm-6">
			<form:input path="email" cssClass="form-control" placeholder="Email"/>
			<form:errors path="email" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-4 "></div>
		<div class="col-sm-6">
			<form:password path="password" cssClass="form-control" placeholder="Password"/>
			<form:errors path="password" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-4 "></div>
		<div class="col-sm-6">
			<input type="password" name="password_confirm" id="password_confirm" class="form-control" placeholder="Retype password"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-6 "></div>
		<div >
			<input type="submit" value="Submit" class="btn btn-lg btn-primary"/>
		</div>
	</div>
	
	
</form:form>

</div>

<script type="text/javascript">
	$(document).ready(function() {
		$(".registrationForm").validate(//http://jqueryvalidation.org/
				{
					rules: {
						name: {
							required : true,
							minlength : 3,
							remote : {
								url:"<spring:url value='/register/available.html' />",
								type: "get",
								data: {
									username: function() {
										return $("#name").val();
									}
								}
							}
						},
						
						email: {
							required : true,
							email : true
						},
		
						password: {
							required : true,
							minlength : 6
						},
						
						password_confirm: {
							required : true,
							minlength : 6,
							equalTo: "#password"
						}
					},
					highlight: function(element) {
						$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
					},
					unhighlight: function(element) {
						$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
					},
					//refer to http://getbootstrap.com/css/  Validation states
					
					messages: {
						name: {
							remote: "Username already exists!"
						}
					}
					
				}
				
		);
	});
</script>