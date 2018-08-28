package com.spring.starter.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.starter.model.Comments;

public interface CommentsReposotory extends JpaRepository<Comments, Integer> {

}
