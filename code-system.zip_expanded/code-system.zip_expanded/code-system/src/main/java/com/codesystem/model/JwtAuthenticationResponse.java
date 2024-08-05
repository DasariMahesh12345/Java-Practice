package com.codesystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationResponse {

	
	private String accessToken;
	private String tokenType = "Bearer";
	private String userName;
	
}
