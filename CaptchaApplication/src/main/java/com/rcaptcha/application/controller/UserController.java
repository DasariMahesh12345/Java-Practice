package com.rcaptcha.application.controller;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcaptcha.application.entity.User;
import com.rcaptcha.application.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(value = "/captcha/generation", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> generateCaptcha() {
		String captcha = generateRandomCaptcha(); // Implement your captcha generation logic here
		return ResponseEntity.ok(captcha);
	}

	@PostMapping("/user/regester/indb")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		// Check if the captcha is null or empty
		if (user.getCaptcha() == null || user.getCaptcha().isEmpty()) {
			return ResponseEntity.badRequest().body("Captcha cannot be empty");
		}

		// Validate captcha
		if (!validateCaptcha(user.getCaptcha())) {
			return ResponseEntity.badRequest().body("Invalid Captcha");
		}

		// Check if email already exists in the database
		User existingUserByEmail = userRepository.findByEmail(user.getEmail());
		if (existingUserByEmail != null) {
			return ResponseEntity.badRequest().body("Email already exists");
		}

		// Check if captcha already exists in the database
		User existingUserByCaptcha = userRepository.findByCaptcha(user.getCaptcha());
		if (existingUserByCaptcha != null) {
			return ResponseEntity.badRequest().body("Duplicate Captcha");
		}

		userRepository.save(user);
		return ResponseEntity.ok("User data saved successfully!");
	}

	@GetMapping("/get/all/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok(users);
	}

	private String generateRandomCaptcha() {
		// Implement your captcha generation logic here (e.g., using Random, UUID, etc.)
		// This is a simple example, and you can use a more complex captcha generation
		// algorithm.
		return UUID.randomUUID().toString().substring(0, 5);
	}

	private boolean validateCaptcha(String captcha) {
		// Implement your captcha validation logic here
		// For example, you can compare it with a stored captcha or use a third-party
		// captcha validation service.
		// For this example, we will validate by checking if the captcha is not empty.
		return captcha != null && !captcha.isEmpty();
	}

}
