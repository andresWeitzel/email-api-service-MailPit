package com.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.microservice.dto.UserDTO;
import com.microservice.exception.DuplicateEmailException;
import com.microservice.model.User;
import com.microservice.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final EmailService emailService;

	@Autowired
	public UserService(UserRepository userRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.emailService = emailService;
	}

	public User saveUser(UserDTO userDTO) {

		if (userRepository.existsByEmail(userDTO.getEmail())) {
			throw new DuplicateEmailException("The email " + userDTO.getEmail() + " already exists.");
		}
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());

		User savedUser = userRepository.save(user);

		emailService.sendEmail(savedUser.getEmail(), "Account register Notification",
				"Hello " + savedUser.getName() + ",\n\nThank you for registering with us!");

		return savedUser;
	}

	public User updateUser(Long id, UserDTO userDTO) {
		Optional<User> existingUserOptional = userRepository.findById(id);

		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			existingUser.setName(userDTO.getName());
			existingUser.setEmail(userDTO.getEmail());

			User updatedUser = userRepository.save(existingUser);

			emailService.sendEmail(updatedUser.getEmail(), "Account Update Notification",
					"Hello " + updatedUser.getName() + ",\n\nYour account has been successfully updated.");

			return updatedUser;
		} else {
			throw new RuntimeException("User not found with id: " + id); // O manejarlo como desees
		}
	}

	public boolean deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User deletedUser = user.get();

			// Eliminar el usuario de la base de datos
			userRepository.delete(deletedUser);

			// Enviar un correo al usuario informándole sobre la eliminación
			emailService.sendEmail(deletedUser.getEmail(), "Account Deletion Notification",
					"Hello " + deletedUser.getName() + ",\n\nYour account has been successfully deleted.");

			return true;
		}
		return false;
	}

	public Page<User> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
