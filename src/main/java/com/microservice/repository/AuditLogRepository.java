package com.microservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
	// Buscar logs por entidad
	Page<AuditLog> findByEntity(String entity, Pageable pageable);

	// Buscar logs por acción
	Page<AuditLog> findByAction(String action, Pageable pageable);

	// Buscar logs por nombre de usuario
	Page<AuditLog> findByUsername(String username, Pageable pageable);

	// Buscar logs que contengan detalles específicos
	Page<AuditLog> findByDetailsContaining(String details, Pageable pageable);
}
