package com.mtjwy.website.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class ArticleCategory {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=1, message="Name must be at least 1 character!")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="webuser_id")
	private WebUser webUser;
	
	@OneToMany(mappedBy="articleCategory", cascade=CascadeType.REMOVE)
	private List<Article> articles;

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

	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
	

	
	
	
}
