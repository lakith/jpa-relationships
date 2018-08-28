package com.spring.starter.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.starter.model.Comments;
import com.spring.starter.model.Posts;
import com.spring.starter.service.PostsService;

@RestController
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	PostsService postsService;
	
	@GetMapping
	public List<Posts> getAllComments(){
		return postsService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public Optional<Posts> getOnePost(@PathVariable int id){
		return postsService.getOnePost(id);
	}
	
	@GetMapping("{id}/comments")
	public List<Comments> getAllposts(@PathVariable int id){
		return postsService.retriveAllCommments(id);
	}
	
	@PostMapping("/saveComment/{id}")
	public Posts addPost(@PathVariable int id,@Valid @RequestBody Comments comment) {
		Optional<Posts> posts = postsService.getOnePost(id);
		Posts post = posts.get();
		comment.setPosts(post);
		postsService.saveComment(comment);
		return postsService.getOnePost(id).get();
	}
	
	@PostMapping
	public Posts savePostwithComment(@Valid @RequestBody Posts posts) {
		postsService.savePost(posts);
		return posts;
	}
	
}
