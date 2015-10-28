package com.mtjwy.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtjwy.website.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
