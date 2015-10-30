package com.mtjwy.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtjwy.website.entity.Role;
import com.mtjwy.website.entity.WebUser;
import com.mtjwy.website.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private WebUserService webUserService;
	
	public String findAdminName() {
		Role role = roleRepository.findByName("ROLE_ADMIN");
		List<Role> roles = new ArrayList<Role>(); 
		roles.add(role);
		List<WebUser> users = webUserService.findUsersByRoles(roles);
		
		return users.get(0).getName();
	}

}
