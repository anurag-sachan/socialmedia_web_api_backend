package com.app.socialmedia_api.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;
	private String password;
}
