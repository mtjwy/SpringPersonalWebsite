package com.mtjwy.website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtjwy.website.entity.Blog;
import com.mtjwy.website.entity.WebUser;



/**
 * Each repository interface work with one entity
 * 
 * JpaRepository<Entity type, primary key type>
 */
public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByWebUser(WebUser user);
	
	
}
