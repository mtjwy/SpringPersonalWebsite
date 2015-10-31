<!DOCTYPE html>
<%@ include file="../layout/taglib.jsp"%>

<div class="blog-header">
			<h1 class="blog-title">${article.title }</h1>
			<p class="lead blog-description"><fmt:formatDate value="${article.publishDate}" pattern="yyyy-MM-dd"/>
			&nbsp &nbsp &nbsp
			Category: <a href="/articleCategory/${article.articleCategory.id }.html"><c:out value="${article.articleCategory.name}" /></a>
			</p>
		</div>
<div class="col-sm-8 blog-main">
		
<div class="blog-post">
	<p >
		Description: &nbsp <c:out value="${article.description}" />
	</p>
	<hr>
	<div id="preview" class="preview-div" ></div>
	
	<textarea id="text-input" oninput="this.editor.update()" rows="30" style="display:none;"><c:out value="${article.content}" /></textarea>
	
	
	
</div>
<!-- /.blog-post -->

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

