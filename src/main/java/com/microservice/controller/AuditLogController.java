package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.AuditLogDTO;
import com.microservice.model.AuditLog;
import com.microservice.service.AuditLogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/audit-log")
@Tag(name = "Audit Log Controller", description = "Operations related to audit logging")
public class AuditLogController {

	private final AuditLogService auditLogService;

	@Autowired
	public AuditLogController(AuditLogService auditLogService) {
		this.auditLogService = auditLogService;
	}

	// Método para registrar un log de auditoría manualmente
	@PostMapping
	@Operation(summary = "Manually create an audit log", description = "Creates a new audit log manually.")
	public ResponseEntity<?> createLog(@RequestBody AuditLogDTO auditLogDTO) {

		// Guardar log de auditoría
		auditLogService.saveLog(auditLogDTO.getEntity(), auditLogDTO.getAction(), auditLogDTO.getUsername(),
				auditLogDTO.getDetails());

		return ResponseEntity.ok("Audit log created successfully");
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update an audit log", description = "Updates an existing audit log.")
	public ResponseEntity<?> updateAuditLog(@PathVariable Long id, @RequestBody AuditLogDTO auditLogDTO) {
		return ResponseEntity.ok(auditLogService.updateLog(id, auditLogDTO));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete an audit log", description = "Deletes an audit log by its ID.")
	public ResponseEntity<?> deleteAuditLog(@PathVariable Long id) {
		auditLogService.deleteLog(id);
		return ResponseEntity.ok("Audit log deleted successfully");
	}

	@GetMapping
	@Operation(summary = "Get all paginated audit logs", description = "Fetches all audit logs with pagination support.")
	public ResponseEntity<?> getAllAuditLogs(
			@Parameter(description = "Pagination and sorting options for the audit log list. Default sort by 'id'.", example = "{ \"page\": 0, \"size\": 30, \"sort\": [\"id\"] }") Pageable pageable) {
		return ResponseEntity.ok(auditLogService.getAllLogs(pageable));
	}

	@GetMapping("/entity")
	@Operation(summary = "Get audit logs by entity", description = "Fetches audit logs by the entity name.")
	public ResponseEntity<?> getAuditLogsByEntity(@RequestParam String entity,
			@Parameter(description = "Pagination and sorting options for the audit log list. Default sort by 'id'.", example = "{ \"page\": 0, \"size\": 30, \"sort\": [\"id\"] }") Pageable pageable) {
		Page<AuditLog> logsPage = auditLogService.getLogsByEntity(entity, pageable);
		return ResponseEntity.ok(logsPage);
	}

	@GetMapping("/action")
	@Operation(summary = "Get audit logs by action", description = "Fetches audit logs by the action type (CREATE, UPDATE, DELETE).")
	public ResponseEntity<?> getAuditLogsByAction(@RequestParam String action,
			@Parameter(description = "Pagination and sorting options for the audit log list. Default sort by 'id'.", example = "{ \"page\": 0, \"size\": 30, \"sort\": [\"id\"] }") Pageable pageable) {
		Page<AuditLog> logsPage = auditLogService.getLogsByAction(action, pageable);
		return ResponseEntity.ok(logsPage);
	}

	@GetMapping("/username")
	@Operation(summary = "Get audit logs by username", description = "Fetches audit logs by the username of the person who performed the action.")
	public ResponseEntity<?> getAuditLogsByUsername(@RequestParam String username,
			@Parameter(description = "Pagination and sorting options for the audit log list. Default sort by 'id'.", example = "{ \"page\": 0, \"size\": 30, \"sort\": [\"id\"] }") Pageable pageable) {
		Page<AuditLog> logsPage = auditLogService.getLogsByUsername(username, pageable);
		return ResponseEntity.ok(logsPage);
	}

	@GetMapping("/details")
	@Operation(summary = "Get audit logs by details", description = "Fetches audit logs by the details of the action performed.")
	public ResponseEntity<?> getAuditLogsByDetails(@RequestParam String details,
			@Parameter(description = "Pagination and sorting options for the audit log list. Default sort by 'id'.", example = "{ \"page\": 0, \"size\": 30, \"sort\": [\"id\"] }") Pageable pageable) {
		Page<AuditLog> logsPage = auditLogService.getLogsByDetails(details, pageable);
		return ResponseEntity.ok(logsPage);
	}

}
