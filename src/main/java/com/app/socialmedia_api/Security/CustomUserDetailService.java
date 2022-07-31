package com.app.socialmedia_api.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.socialmedia_api.entities.User;
import com.app.socialmedia_api.exceptions.ResourceNotFoundException;
import com.app.socialmedia_api.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//load data from db using username
		
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(()-> new ResourceNotFoundException("User", "email"+username, 0));
		return user;
	}

}
