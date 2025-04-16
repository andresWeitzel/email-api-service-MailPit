package com.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dto.UserDTO;
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
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());

		User savedUser = userRepository.save(user);

		emailService.sendEmail(savedUser.getEmail(), "Welcome to Notification Service!!",
				"Hello" + savedUser.getName() + ",\n\nThank you for registering with us!");

		return savedUser;
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
