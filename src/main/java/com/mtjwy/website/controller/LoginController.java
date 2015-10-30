package com.mtjwy.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtjwy.website.service.ArticleCategoryService;

@Controller
public class LoginController {
	
	@Autowired
	private ArticleCategoryService articleCategoryService;

	@RequestMapping("/login")
	public String longin(Model model) {
		model.addAttribute("categs", articleCategoryService.findAll());
		return "login";
	}

}
