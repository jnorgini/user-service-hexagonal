package com.norgini.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.norgini.domain.model.User;

public interface FindUserUseCase {
	
	List<User> findAll();
	Optional<User> findById(Long id);

}
