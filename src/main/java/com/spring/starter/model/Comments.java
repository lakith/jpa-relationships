package com.spring.starter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comments {

	@Id
	@GeneratedValue
	private int id;

	@NonNull
	@Column(name = "text", length = 200, nullable = false)
	private String text;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Posts posts;

	public Comments() {
		super();
	}

	public Comments(String text, Posts posts) {
		super();
		this.text = text;
		this.posts = posts;
	}

	public Comments(int id, String text, Posts posts) {
		super();
		this.id = id;
		this.text = text;
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", text=" + text + "]";
	}

}
