package com.mtjwy.website.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtjwy.website.entity.ArticleCategory;
import com.mtjwy.website.entity.Blog;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.service.ArticleCategoryService;
import com.mtjwy.website.service.BlogService;
import com.mtjwy.website.service.WebUserService;

@Controller
public class WebUserController {
	@Autowired
	private WebUserService webUserService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private ArticleCategoryService articleCategoryService;
	
	
	
	@ModelAttribute("webuser")//bind the commandName="user" in user-register form to this method
	public WebUser constructUser() {
		return new WebUser();
	}
	
	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}
	
	@ModelAttribute("article-category")
	public ArticleCategory constructArticleCategory() {
		return new ArticleCategory();
	}
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", webUserService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", webUserService.findOneWithArticles(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegister() {
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("webuser") WebUser user) {
		webUserService.save(user);
		
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {//principal is an object in session, which contains the name of the user
		String name = principal.getName();
		model.addAttribute("user", webUserService.findOneWithBlogs(name));
		return "account-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal) {//use principal to get info about which user want to add a blog
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";	
	}
	
	@RequestMapping(value="/article-category", method=RequestMethod.POST)
	public String doAddArticleCategory(@ModelAttribute("article-category") ArticleCategory ac, Principal principal) {//use principal to get info about which user want to add
		String name = principal.getName();
		articleCategoryService.save(ac, name);
		return "redirect:/article-category.html";	
	}
	
	@RequestMapping(value="/article-category")
	public String articleCategory(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", webUserService.findOneWithArticles(name));
		return "article-category";	
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		
		return "redirect:/account.html";

	}
	
	@RequestMapping("/users/remove/{id}")
	public String removeUser(@PathVariable int id) {
		webUserService.delete(id);
		return "redirect:/users.html";
	}
	
	
	
}
