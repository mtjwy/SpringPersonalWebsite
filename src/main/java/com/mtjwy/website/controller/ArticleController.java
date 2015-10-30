package com.mtjwy.website.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.service.ArticleCategoryService;
import com.mtjwy.website.service.ArticleService;
import com.mtjwy.website.service.RoleService;
import com.mtjwy.website.service.WebUserService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleCategoryService articleCategoryService;
	
	@Autowired
	private WebUserService webUserService;
	
	@Autowired
	private RoleService roleService;
	
	
	@ModelAttribute("new-article")
	public Article construct() {
		
		return new Article();
	}
	
	@ModelAttribute("article")
	public Article constructEditedArticle() {
		
		return new Article();
	}
	
	
	
	@RequestMapping("/{category_id}/new-article")
	public String showNewArticle(@PathVariable int category_id, Model model) {
		model.addAttribute("category_id", category_id);
//		return "new-article";
		
		return "new-article-markdown";
	}
	
	@RequestMapping(value="/{category_id}/new-article", method=RequestMethod.POST)
	public String newArticle(@ModelAttribute("new-article") Article article, @PathVariable int category_id) {	
		articleService.save(article, category_id);
		return "redirect:/article-category.html";
	}
	
	@RequestMapping("/article-category/articles/remove/{id}")
	public String removeArticle(@PathVariable int id) {
		articleService.delete(id);
		return "redirect:/article-category.html";
	}
	
//	@RequestMapping("/articles")
//	public String articles(Model model) {
//		model.addAttribute("articles", articleService.findLatestArticles());
//		model.addAttribute("categs", articleCategoryService.findAll());
//		return "articles";
//	}
	
	@RequestMapping("/articles")
	public String articles(Model model) {
		String adminName = roleService.findAdminName();
		WebUser user = webUserService.findOneWithArticles(adminName);
		model.addAttribute("user", user);
		model.addAttribute("categs", user.getArticleCategories());
		return "articles";
	}
	
	@RequestMapping("/my-articles")
	public String articlesByUserId(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", webUserService.findOneWithArticles(name));
		return "my-articles";
	}
	

	@RequestMapping("/article/{id}")
	public String showArticle(Model model, @PathVariable int id) {
		model.addAttribute("article", articleService.findOne(id));
		model.addAttribute("categs", articleCategoryService.findAll());
		return "article";
	}
	
	
	@RequestMapping("/articleCategory/{id}")
	public String showArticlesByCategory(Model model, @PathVariable int id) {
		model.addAttribute("category", articleCategoryService.findOneWithArticles(id));
		model.addAttribute("categs", articleCategoryService.findAll());
		return "category-articles";
	}
	
	//To populate spring <form:textarea> with value, need to populate, or bind Model to form
	@RequestMapping("/edit/{id}")
	public String showEditArticlePage(Model model, @PathVariable int id) {
		model.addAttribute("article", articleService.findOne(id));
//		return "edit-article";
		return "edit-article-markdown";
	}
	
	/*
	 * http://stackoverflow.com/questions/23201229/initial-value-to-textarea-field-in-form-tld?rq=1
	 There is no value property in textarea when form tags are used. 
	 Path property is used for data binding. For eg., just before rendering 
	 the view in which you are using this textarea, populate the model object 
	 with the data in your controller as:

    @RequestMapping(value="/prepareArticleForm")
    public ModelAndView prepareArticle(Model model) {
        Article article = new Article();
        article.setDescription("Your text");
        return new ModelAndView("articleView","article",article);
    }
    
	In your articleView jsp:

    <form:form action="someAction" commandName="article" method="post">         
         <form:textarea path="description" />
    </form:form>
	 */
	
	
//	@RequestMapping("/edit/{id}")
//    public ModelAndView showEditArticlePage(Model model, @PathVariable int id) {
//		
//        return new ModelAndView("edit-article", "article", articleService.findOne(id));
//    }
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String editArticle(@ModelAttribute("article") Article article, @PathVariable int id) {
		Article a = articleService.findOne(id);
		a.setContent(article.getContent());
		a.setTitle(article.getTitle());
		a.setDescription(article.getDescription());
		articleService.save(a);
		return "redirect:/article/{id}.html";
	}
	
	
}
