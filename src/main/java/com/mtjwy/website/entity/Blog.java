package com.mtjwy.website.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Blog {
	@Id
	@GeneratedValue
	private Integer id;

	
	@Column(length = 1000)
	private String name;

	
	@Column(length = 1000)
	private String url;

	/*
	 * The annotation @JoinColumn indicates that this entity is the owner of the
	 * relationship (that is: the corresponding table has a column with a
	 * foreign key to the referenced table), whereas the attribute mappedBy
	 * indicates that the entity in this side is the inverse of the
	 * relationship, and the owner resides in the "other" entity.
	 */
	@ManyToOne
	@JoinColumn(name = "webuser_id") // set foreign key
	private WebUser webUser;

	@OneToMany(mappedBy = "blog", cascade=CascadeType.REMOVE)
	private List<Item> items;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
