package com.spring.starter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Posts {
	
	@Id
	@GeneratedValue
	private int p_id;
	
	@Column
	@NonNull
	private String title;
	
	@OneToMany(mappedBy="posts")
	private List<Comments> comments;

	public Posts() {
		super();
	}

	public Posts(String title, List<Comments> comments) {
		super();
		this.title = title;
		this.comments = comments;
	}

	public Posts(int p_id, String title, List<Comments> comments) {
		super();
		this.p_id = p_id;
		this.title = title;
		this.comments = comments;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
}
