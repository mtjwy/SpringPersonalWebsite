package com.mtjwy.website.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 1000)
	private String title;

	@Column(length = 1000)
	private String link;

	
	@Column(length = Integer.MAX_VALUE)
	private String description;

	@Column(name = "publish_date")
	private Date publishDate;

	/*
	 * The annotation @JoinColumn indicates that this entity is the owner of the
	 * relationship (that is: the corresponding table has a column with a
	 * foreign key to the referenced table), whereas the attribute mappedBy
	 * indicates that the entity in this side is the inverse of the
	 * relationship, and the owner resides in the "other" entity.
	 */
	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishedDate) {
		this.publishDate = publishedDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
