package com.mtjwy.website.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<WebUser> webUsers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WebUser> getWebUsers() {
		return webUsers;
	}

	public void setWebUsers(List<WebUser> webUsers) {
		this.webUsers = webUsers;
	}
	
	
}
