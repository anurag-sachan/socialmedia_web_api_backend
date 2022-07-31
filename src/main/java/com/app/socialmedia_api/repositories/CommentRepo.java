package com.app.socialmedia_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.socialmedia_api.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
	
}
