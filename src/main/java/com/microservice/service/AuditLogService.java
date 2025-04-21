package com.microservice.service;

import com.microservice.dto.AuditLogDTO;
import com.microservice.exception.ResourceNotFoundException;
import com.microservice.model.AuditLog;
import com.microservice.repository.AuditLogRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

	private final AuditLogRepository auditLogRepository;

	@Autowired
	public AuditLogService(AuditLogRepository auditLogRepository) {
		this.auditLogRepository = auditLogRepository;
	}

	public void saveLog(String entity, String action, String username, String details) {
		AuditLog log = new AuditLog();
		log.setEntity(entity);
		log.setAction(action);
		log.setUsername(username);
		log.setDetails(details);
		auditLogRepository.save(log);
	}

	// Método para eliminar un log
	public AuditLog deleteLog(Long id) {
		Optional<AuditLog> log = auditLogRepository.findById(id);
		if (log.isPresent()) {
			AuditLog deleteAuditLog = log.get();

			// Eliminar el log de la base de datos
			auditLogRepository.delete(deleteAuditLog);

			return deleteAuditLog;
		} else {
			// Lanzar la excepción si no se encuentra el usuario
			throw new ResourceNotFoundException("Audit Log with ID " + id + " not found");
		}
	}

	// Método para actualizar un log de auditoría
	public AuditLog updateLog(Long id, AuditLogDTO auditLogDTO) {
		AuditLog auditLog = auditLogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Audit Log not found with ID: " + id));

		auditLog.setEntity(auditLogDTO.getEntity());
		auditLog.setAction(auditLogDTO.getAction());
		auditLog.setUsername(auditLogDTO.getUsername());
		auditLog.setDetails(auditLogDTO.getDetails());

		return auditLogRepository.save(auditLog);
	}

	// Obtener todos los logs con paginación
	public Page<AuditLog> getAllLogs(Pageable pageable) {
		return auditLogRepository.findAll(pageable);
	}

	// Buscar logs por entidad
	public Page<AuditLog> getLogsByEntity(String entity, Pageable pageable) {
		return auditLogRepository.findByEntity(entity, pageable);
	}

	// Buscar logs por acción
	public Page<AuditLog> getLogsByAction(String action, Pageable pageable) {
		return auditLogRepository.findByAction(action, pageable);
	}

	// Buscar logs por usuario
	public Page<AuditLog> getLogsByUsername(String username, Pageable pageable) {
		return auditLogRepository.findByUsername(username, pageable);
	}

	// Buscar logs por detalles
	public Page<AuditLog> getLogsByDetails(String details, Pageable pageable) {
		return auditLogRepository.findByDetailsContaining(details, pageable);
	}

	// Crear un nuevo log de auditoría
	public AuditLog createAuditLog(AuditLog auditLog) {
		return auditLogRepository.save(auditLog);
	}

}
