package com.norgini.application.service;

import com.norgini.application.ports.in.CreateUserUseCase;
import com.norgini.application.ports.out.UserRepositoryPort;
import com.norgini.domain.model.User;

public class CreateUserService implements CreateUserUseCase {
	
	private final UserRepositoryPort userRepositoryPort;

	public CreateUserService(UserRepositoryPort userRepositoryPort) {
		this.userRepositoryPort = userRepositoryPort;
	}

	@Override
	public User execute(User user) {
		return userRepositoryPort.save(user);
	}
}
