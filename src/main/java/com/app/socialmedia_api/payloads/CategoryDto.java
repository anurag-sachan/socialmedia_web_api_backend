package com.app.socialmedia_api.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotEmpty
	private String categoryTitle;
	
	@NotEmpty
	@Size(min=5, message="min size should be 5")
	private String categoryDescription;

}
