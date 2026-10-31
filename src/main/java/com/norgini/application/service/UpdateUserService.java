package com.norgini.application.service;

import com.norgini.application.ports.in.UpdateUserUseCase;
import com.norgini.application.ports.out.UserRepositoryPort;
import com.norgini.domain.exception.BusinessException;
import com.norgini.domain.model.User;

public class UpdateUserService implements UpdateUserUseCase {
	
	private final UserRepositoryPort userRepositoryPort;

	public UpdateUserService(UserRepositoryPort userRepositoryPort) {
		this.userRepositoryPort = userRepositoryPort;
	}

	@Override
	public User execute(Long id, User userAtualizado) {
		User userExistente = userRepositoryPort.findById(id)
				.orElseThrow(() -> new BusinessException("Usuário não encontrado com o ID: " + id));
		
		userExistente.setUsername(userAtualizado.getUsername());
		userExistente.setPassword(userAtualizado.getPassword());
		
		return userRepositoryPort.save(userExistente);
	}
}
