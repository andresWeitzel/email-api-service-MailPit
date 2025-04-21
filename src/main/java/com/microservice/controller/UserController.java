package com.microservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.UserDTO;
import com.microservice.exception.DuplicateEmailException;
import com.microservice.exception.GlobalExceptionHandler;
import com.microservice.exception.ResourceNotFoundException;
import com.microservice.model.User;
import com.microservice.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "Operations related to users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Manejar excepciones específicas
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		return GlobalExceptionHandler.handleValidationExceptions(ex);
	}

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<Map<String, Object>> handleDuplicateEmailException(DuplicateEmailException ex) {
		return GlobalExceptionHandler.handleDuplicateEmail(ex);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return GlobalExceptionHandler.handleResourceNotFound(ex);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(
			DataIntegrityViolationException ex) {
		return GlobalExceptionHandler.handleDataIntegrityViolation(ex);
	}

	@PostMapping
	@Operation(summary = "Create a new user", description = "Creates a new user and sends a notification email.")
	public ResponseEntity<?> createUser(@Validated @RequestBody UserDTO userDTO) {
		User user = userService.saveUser(userDTO);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update an existing user", description = "Updates user information and sends a notification email.")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @Validated @RequestBody UserDTO userDTO) {
		User updatedUser = userService.updateUser(id, userDTO);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a user", description = "Deletes a user by their ID and sends a notification email.")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		User deletedUser = userService.deleteUser(id);
		return ResponseEntity.ok(deletedUser);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get user by ID", description = "Fetches a user by their ID.")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	@Operation(summary = "Get all paginated users", description = "Fetches all users with pagination support.")
	public ResponseEntity<?> getAllUsers(
			@Parameter(description = "Pagination and sorting options for the users list. Default sort by 'id'.", example = "{ \"page\": 0, \"size\": 30, \"sort\": [\"id\"] }") Pageable pageable) {
		return ResponseEntity.ok(userService.getAllUsers(pageable));
	}
}