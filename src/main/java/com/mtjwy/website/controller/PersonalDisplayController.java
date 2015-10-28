package com.mtjwy.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalDisplayController {

	
	@RequestMapping("/projects")
	public String projects() {
		return "projects";
	}
}
