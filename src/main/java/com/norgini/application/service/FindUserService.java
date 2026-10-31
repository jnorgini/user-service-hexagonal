package com.norgini.application.service;

import com.norgini.application.ports.in.FindUserUseCase;
import com.norgini.application.ports.out.UserRepositoryPort;
import com.norgini.domain.model.User;
import java.util.List;
import java.util.Optional;

public class FindUserService implements FindUserUseCase {
	
	private final UserRepositoryPort userRepositoryPort;

	public FindUserService(UserRepositoryPort userRepositoryPort) {
		this.userRepositoryPort = userRepositoryPort;
	}

	@Override
	public List<User> findAll() {
		return userRepositoryPort.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepositoryPort.findById(id);
	}
}
