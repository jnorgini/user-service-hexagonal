package com.norgini.infrastructure.adapters.in.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
		@Email 
		@NotBlank(message = "O e-mail é obrigatório") 
		String email,
		@NotBlank(message = "O username é obrigatório") 
		String username,
		@NotBlank(message = "A senha é obrigatória") 
		String password) {
}
