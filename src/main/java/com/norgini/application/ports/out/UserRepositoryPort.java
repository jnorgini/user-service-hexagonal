package com.norgini.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.norgini.domain.model.User;

public interface UserRepositoryPort {

	User save(User user);
	List<User> findAll();
	Optional<User> findById(Long id);
	void deleteById(Long id);
}
