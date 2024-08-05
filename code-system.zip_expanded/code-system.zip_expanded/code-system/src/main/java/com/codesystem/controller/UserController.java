package com.codesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesystem.dto.AuthRequest;
import com.codesystem.model.ApiResponse;
import com.codesystem.model.JwtAuthenticationResponse;
import com.codesystem.model.UserInfo;
import com.codesystem.service.JwtService;
import com.codesystem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}

	@PostMapping("/add")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsernameOrEmail(), authRequest.getPassword()));
		System.out.println("/>>>>>>>>>>>>>>>>>>>" + authentication.isAuthenticated());
		if (authentication.isAuthenticated()) {
			String token = jwtService.generateToken(authRequest.getUsernameOrEmail());
			return ResponseEntity.ok(new JwtAuthenticationResponse(token, "Bearer", authRequest.getUsernameOrEmail()));
		} else {
			System.out.println("hi");
			return new ResponseEntity<>(new ApiResponse(false, "Invalid user request !", null),
					HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@GetMapping("/list")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<UserInfo> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public UserInfo getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

}
