package com.app.socialmedia_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.socialmedia_api.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
