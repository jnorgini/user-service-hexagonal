package com.norgini.infrastructure.adapters.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.norgini.infrastructure.adapters.out.persistence.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
	
}
