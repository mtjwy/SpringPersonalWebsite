package com.mtjwy.website.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtjwy.website.entity.Article;
import com.mtjwy.website.service.ArticleCategoryService;
import com.mtjwy.website.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleCategoryService articleCategoryService;
	
	
	@ModelAttribute("article")
	public Article construct() {
		
		return new Article();
	}
	
	@RequestMapping("/{category_id}/new-article")
	public String showNewArticle(@PathVariable int category_id, Model model) {
		model.addAttribute("category_id", category_id);
		return "new-article";
	}
	
	@RequestMapping(value="/{category_id}/new-article", method=RequestMethod.POST)
	public String newArticle(@ModelAttribute("article") Article article, @PathVariable int category_id) {	
		articleService.save(article, category_id);
		return "redirect:/article-category.html";
	}
	
	@RequestMapping("/article-category/articles/remove/{id}")
	public String removeArticle(@PathVariable int id) {
		articleService.delete(id);
		return "redirect:/article-category.html";
	}
}
