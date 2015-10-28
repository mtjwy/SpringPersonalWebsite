package com.mtjwy.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtjwy.website.entity.WebUser;

public interface WebUserRepository extends JpaRepository<WebUser, Integer>{

	WebUser findByName(String name);

}
