package com.mtjwy.website.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.service.WebUserService;

@Controller
public class WebUserController {
	@Autowired
	private WebUserService webUserService;
	
	@ModelAttribute("webuser")//bind the commandName="user" in user-register form to this method
	public WebUser construct() {
		return new WebUser();
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
}
