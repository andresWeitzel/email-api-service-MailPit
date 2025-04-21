package com.microservice.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogDTO {
	@Schema(description = "The entity of a log", example = "User")
	private String entity;
	@Schema(description = "The action or type of operation", example = "CREATE")
	private String action;
	@Schema(description = "The username that generated the log", example = "admin_user")
	private String username;
	@Schema(description = "The details of a log", example = "Create user with ID...")
	private String details;
	@Schema(description = "The timestamp of a log", example = "2025-04-21 10:00:00")
	private LocalDateTime timestamp;

}
