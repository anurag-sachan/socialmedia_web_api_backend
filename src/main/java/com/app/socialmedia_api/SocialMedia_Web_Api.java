package com.app.socialmedia_api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.socialmedia_api.config.AppConstants;
import com.app.socialmedia_api.entities.Role;
import com.app.socialmedia_api.repositories.RoleRepo;

import java.util.List;

@SpringBootApplication //main-> .run
public class SocialMedia_Web_Api implements CommandLineRunner  {
	//CLRunner for auto-config
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(SocialMedia_Web_Api.class, args);
	}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("BKL"));//password encoder
		try {
			Role role=new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ADMIN_USER");
			
			Role role1=new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("NORMAL_USER");
			
			List<Role> roles= List.of(role,role1);

			List<Role> result= this.roleRepo.saveAll(roles);
			
			result.forEach(r-> System.out.println(r.getName())
					); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
