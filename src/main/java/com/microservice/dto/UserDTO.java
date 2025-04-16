package com.microservice.dto;

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
	
	@NotBlank(message="The name is mandatory")
	private String name;
	

	@NotBlank(message="The email is mandatory")
	@Email(message="The email is invalid")
	private String email;

}
