package com.app.socialmedia_api.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "username must be min of 4 characters.")
	private String name;
	
	@Email(message = "email is not valid")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message = "3 ≤ password size ≤ 10")
	//@Pattern(regexp = )
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles=new HashSet<>();

}
