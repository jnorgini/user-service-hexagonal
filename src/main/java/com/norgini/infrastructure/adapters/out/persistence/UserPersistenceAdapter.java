package com.norgini.infrastructure.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.norgini.application.ports.out.UserRepositoryPort;
import com.norgini.domain.model.User;
import com.norgini.infrastructure.adapters.out.persistence.entity.UserEntity;
import com.norgini.infrastructure.adapters.out.persistence.repository.JpaUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

	private final JpaUserRepository jpaUserRepository;

	@Override
	public User save(User user) {
		UserEntity entity = new UserEntity(user.getId(), user.getEmail(), user.getUsername(), user.getPassword());
		UserEntity savedEntity = jpaUserRepository.save(entity);
		return new User(
				savedEntity.getId(), 
				savedEntity.getEmail(), 
				savedEntity.getUsername(), 
				savedEntity.getPassword());
	}

	@Override
	public List<User> findAll() {
		return jpaUserRepository.findAll().stream()
				.map(entity -> new User(
						entity.getId(), 
						entity.getEmail(), 
						entity.getUsername(), 
						entity.getPassword()))
				.toList();
	}

	@Override
	public Optional<User> findById(Long id) {
		return jpaUserRepository.findById(id)
				.map(entity -> new User(
						entity.getId(), 
						entity.getEmail(), 
						entity.getUsername(), 
						entity.getPassword()));
	}

	@Override
	public void deleteById(Long id) {
		jpaUserRepository.deleteById(id);
	}
}
