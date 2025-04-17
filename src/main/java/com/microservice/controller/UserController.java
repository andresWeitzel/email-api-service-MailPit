package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.UserDTO;
import com.microservice.model.User;
import com.microservice.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
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

	@PostMapping
	@Operation(summary = "Create a new user", description = "Creates a new user and sends a notification email.")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {

		User user = userService.saveUser(userDTO);

		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update a user", description = "Updates an existing user and send a notification email.")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
		User updatedUser = userService.updateUser(id, userDTO);
		return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a user", description = "Deletes a user by their unique ID and send a notification email.")
	public ResponseEntity<Void> deleteUser(@Parameter(description = "ID of the user to delete") @PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}

	@GetMapping()
	@Operation(summary = "Get all users paginated list", description = "Get a pageable list of all registered users.")
	public ResponseEntity<Page<User>> getAllUsers(
			@Parameter(description = "Pagination and sorting options for the users list. Default sort by 'id'.", example = "{ \"page\": 0, \"size\": 1, \"sort\": [\"id\"] }") Pageable pageable) {
		return ResponseEntity.ok(userService.getAllUsers(pageable));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get user by ID", description = "Get a user based on their unique ID.")
	public ResponseEntity<User> getUserById(@Parameter(description = "ID of the user to get") @PathVariable Long id) {
		return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/email/{email}")
	@Operation(summary = "Get user by email", description = "Get a user using their email address.")
	public ResponseEntity<User> getUserByEmail(
			@Parameter(description = "Email of the user to get") @PathVariable String email) {
		return userService.getUserByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
