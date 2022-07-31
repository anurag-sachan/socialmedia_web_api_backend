package com.app.socialmedia_api.services;

import java.util.List;

import com.app.socialmedia_api.payloads.CategoryDto;

public interface CategoryService {
	
	//POST
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//PUT
	CategoryDto updateCategory(CategoryDto categoryDto, int categoryId);
	
	//GET
	CategoryDto getCategory(int categoryId);
	
	//GETALL
	List<CategoryDto> getCategories();
	
	//DELETE
	void deleteCategory(int categoryId);
	
}
