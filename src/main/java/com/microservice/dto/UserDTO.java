package com.microservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	@NotBlank(message = "The name is mandatory")
	@Schema(description = "The name of user", example = "John Doe")
	private String name;

	@NotBlank(message = "The email is mandatory")
	@Email(message = "The email is invalid")
	@Schema(description = "The email of user", example = "john.doe@example.com")
	private String email;

}
