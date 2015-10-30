<!DOCTYPE html>

<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">Write a new article</h1>
			<p class="lead blog-description">Good good study, day day up!</p>
</div>

<div class="col-xs-7">
<form:form commandName="new-article" cssClass="form-horizontal" action="/${category_id}/new-article.html">
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label">Title:</label>
		<div class="col-sm-10">
			<form:input path="title" cssClass="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Description:</label>
		<div class="col-sm-10">
			<form:input path="description" cssClass="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="content" class="col-sm-2 control-label">Content:</label>
		<div class="col-sm-10">
			<form:textarea id="text-input" oninput="this.editor.update()" path="content" cssClass="form-control" rows="20"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-6"> </div>
		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary"/>
		</div>
	</div>
	
	
</form:form>
</div>

<div class="col-xs-5">
 <p>Article preview:</p>
 <div id="preview" class="preview-div" ></div>
    
</div>

 <script src="/resources/js/lib/markdown.js"></script>
    <script>
      function Editor(input, preview) {
        this.update = function () {
          preview.innerHTML = markdown.toHTML(input.value);
        };
        input.editor = this;
        this.update();
      }
      var $ = function (id) { return document.getElementById(id); };
      new Editor($("text-input"), $("preview"));
 	</script>
