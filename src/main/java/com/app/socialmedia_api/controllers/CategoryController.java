package com.app.socialmedia_api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.socialmedia_api.payloads.ApiResponse;
import com.app.socialmedia_api.payloads.CategoryDto;
import com.app.socialmedia_api.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategory,HttpStatus.CREATED);
	}
		
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("catId") Integer catId){
		CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,catId);
		return ResponseEntity.ok(updatedCategory);
	}
	
	//delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted",true),HttpStatus.OK);
	}
	
	//get-all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories() {
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int catId){
		return ResponseEntity.ok(this.categoryService.getCategory(catId));
	}
}
