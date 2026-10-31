package com.norgini.application.service;

import com.norgini.application.ports.in.DeleteUserUseCase;
import com.norgini.application.ports.out.UserRepositoryPort;
import com.norgini.domain.exception.BusinessException;

public class DeleteUserService implements DeleteUserUseCase {
	
	private final UserRepositoryPort userRepositoryPort;

	public DeleteUserService(UserRepositoryPort userRepositoryPort) {
		this.userRepositoryPort = userRepositoryPort;
	}

	@Override
	public void execute(Long id) {
		userRepositoryPort.findById(id)
				.orElseThrow(() -> new BusinessException("Não é possível deletar. Usuário não encontrado."));
		userRepositoryPort.deleteById(id);
	}
}
