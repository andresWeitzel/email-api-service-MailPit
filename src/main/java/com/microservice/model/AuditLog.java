package com.microservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "audit_log")
@Data
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String entity;
	private String action;
	private String username;
	private String details;

	private LocalDateTime timestamp;

	@PrePersist
	public void prePersist() {
		this.timestamp = LocalDateTime.now();
	}

}
