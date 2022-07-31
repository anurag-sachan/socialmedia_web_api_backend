package com.app.socialmedia_api.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data 
@Getter @Setter @NoArgsConstructor
public class Role {

	@Id 
	private int id;
	
	private String name;

	
}
