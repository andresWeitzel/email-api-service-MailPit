package com.microservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

	// Manejo de excepciones de validación (por ejemplo, @NotBlank, @Email)
	public static ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("errors", errors);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	// Manejo de excepciones de correo duplicado
	public static ResponseEntity<Map<String, Object>> handleDuplicateEmail(DuplicateEmailException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("errors", "Email is already in use: " + ex.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp", LocalDateTime.now());
		response.put("status", HttpStatus.CONFLICT.value());
		response.put("message", "A database constraint was violated: " + getRootCauseMessage(ex));

		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	private static String getRootCauseMessage(Throwable ex) {
		Throwable root = ex;
		while (root.getCause() != null) {
			root = root.getCause();
		}
		return root.getMessage();
	}

	// Manejo de ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public static ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		errorResponse.put("error", "Not Found");
		errorResponse.put("message", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
