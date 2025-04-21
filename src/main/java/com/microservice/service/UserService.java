package com.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.microservice.dto.UserDTO;
import com.microservice.exception.DuplicateEmailException;
import com.microservice.exception.ResourceNotFoundException;
import com.microservice.model.User;
import com.microservice.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final EmailService emailService;
	private final AuditLogService auditLogService;

	@Autowired
	public UserService(UserRepository userRepository, EmailService emailService, AuditLogService auditLogService) {
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.auditLogService = auditLogService;
	}

	// Método para guardar un nuevo usuario
	public User saveUser(UserDTO userDTO) {
		// Verificar si el correo ya existe
		if (userRepository.existsByEmail(userDTO.getEmail())) {
			throw new DuplicateEmailException("The email " + userDTO.getEmail() + " already exists.");
		}

		// Crear el usuario
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());

		// Guardar el usuario en la base de datos
		User savedUser = userRepository.save(user);

		auditLogService.saveLog("User", "CREATE", "system_admin", "Created user with email: " + savedUser.getEmail());

		// Enviar un correo de notificación de registro
		emailService.sendEmail(savedUser.getEmail(), "Account register Notification",
				"Hello " + savedUser.getName() + ",\n\nThank you for registering with us!");

		return savedUser;
	}

	// Método para actualizar un usuario existente
	public User updateUser(Long id, UserDTO userDTO) {
		Optional<User> existingUserOptional = userRepository.findById(id);

		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			existingUser.setName(userDTO.getName());
			existingUser.setEmail(userDTO.getEmail());

			// Guardar el usuario actualizado
			User updatedUser = userRepository.save(existingUser);

			auditLogService.saveLog("User", "UPDATE", "system_admin", "Updated user ID " + id);

			// Enviar un correo de notificación de actualización
			emailService.sendEmail(updatedUser.getEmail(), "Account Update Notification",
					"Hello " + updatedUser.getName() + ",\n\nYour account has been successfully updated.");

			return updatedUser;
		} else {
			// Lanzar la excepción si no se encuentra el usuario
			throw new ResourceNotFoundException("User with ID " + id + " not found");
		}
	}

	// Método para eliminar un usuario
	public User deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User deletedUser = user.get();

			// Eliminar el usuario de la base de datos
			userRepository.delete(deletedUser);

			auditLogService.saveLog("User", "DELETE", "system_admin", "Deleted user ID " + id);

			// Enviar un correo de notificación de eliminación
			emailService.sendEmail(deletedUser.getEmail(), "Account Deletion Notification",
					"Hello " + deletedUser.getName() + ",\n\nYour account has been successfully deleted.");

			return deletedUser;
		} else {
			// Lanzar la excepción si no se encuentra el usuario
			throw new ResourceNotFoundException("User with ID " + id + " not found");
		}
	}

	// Método para obtener todos los usuarios con paginación
	public Page<User> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	// Método para obtener un usuario por ID
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
	}

	// Método para obtener un usuario por correo electrónico
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
