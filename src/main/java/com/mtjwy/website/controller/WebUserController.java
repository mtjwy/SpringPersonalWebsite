package com.mtjwy.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtjwy.website.service.WebUserService;

@Controller
public class WebUserController {
	@Autowired
	private WebUserService webUserService;
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", webUserService.findAll());
		return "users";
	}
	
	@RequestMapping("users/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", webUserService.findOneWithArticles(id));
		return "user-detail";
	}
}
