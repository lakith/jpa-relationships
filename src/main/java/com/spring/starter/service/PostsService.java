package com.spring.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.starter.model.Comments;
import com.spring.starter.model.Posts;
import com.spring.starter.reposatory.CommentsReposotory;
import com.spring.starter.reposatory.PostsReposotory;

@Service
public class PostsService {
	
	@Autowired
	PostsReposotory postsReposotory;
	
	@Autowired
	CommentsReposotory commentsReposotory;
	
	public List<Posts> getAllPosts(){
		return postsReposotory.findAll();
	}
	
	public Optional<Posts> getOnePost(int id){
		return postsReposotory.findById(id);
	}
	
	public List<Comments> retriveAllCommments(int id){
		Optional<Posts> postOptional = postsReposotory.findById(id);
		return postOptional.get().getComments();
	} 
	
	public void savePost(Posts posts) {
		postsReposotory.save(posts);
	}
	
	public void saveComment(Comments comments) {
		commentsReposotory.save(comments);
	}

}
