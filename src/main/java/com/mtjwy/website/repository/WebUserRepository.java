package com.mtjwy.website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtjwy.website.entity.Role;
import com.mtjwy.website.entity.WebUser;

public interface WebUserRepository extends JpaRepository<WebUser, Integer>{

	WebUser findByName(String name);

	

	List<WebUser> findByRoles(List role);

}
