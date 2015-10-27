package com.mtjwy.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.repository.WebUserRepository;

@Service
public class WebUserService {

	@Autowired
	private WebUserRepository webUserRepository;
	
	
	public List<WebUser> findAll() {
		return webUserRepository.findAll();
	}

	
}
