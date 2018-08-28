package com.spring.starter.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.starter.model.Posts;

public interface PostsReposotory extends JpaRepository<Posts, Integer>  {

}
