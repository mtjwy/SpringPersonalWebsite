package com.mtjwy.website.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.mtjwy.website.annotation.UniqueUsername;



@Entity
public class WebUser {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message="Name must be at least 3 characters!")
	@Column(unique=true)
	@UniqueUsername(message="User name already exists!")
	private String name;
	
	@Size(min=6, message="Password must be at least 6 characters!")
	private String password;
	
	@Size(min=1, message="Invalid email address!")
	@Email(message="Invalid email address!")
	private String email;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy="webUser", cascade=CascadeType.REMOVE)
	private List<ArticleCategory> articleCategories;
	
	private boolean enabled;
	
	/*
	 * mappedBy is set to be the User field in Blog entity
	 * 
	 * The annotation @JoinColumn indicates that this entity is the owner of the
	 * relationship (that is: the corresponding table has a column with a
	 * foreign key to the referenced table), whereas the attribute mappedBy
	 * indicates that the entity in this side is the inverse of the
	 * relationship, and the owner resides in the "other" entity.
	 */
	@OneToMany(mappedBy = "webUser", cascade=CascadeType.REMOVE)
	private List<Blog> blogs;

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<ArticleCategory> getArticleCategories() {
		return articleCategories;
	}

	public void setArticleCategories(List<ArticleCategory> articleCategories) {
		this.articleCategories = articleCategories;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	
}
