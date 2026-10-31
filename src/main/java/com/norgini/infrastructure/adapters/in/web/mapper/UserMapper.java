package com.norgini.infrastructure.adapters.in.web.mapper;

import com.norgini.domain.model.User;
import com.norgini.infrastructure.adapters.in.web.dto.UserRequest;
import com.norgini.infrastructure.adapters.in.web.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public User toDomain(UserRequest request) {
		if (request == null) {
			return null;
		}
		return new User(null, request.email(), request.username(), request.password());
	}

	public UserResponse toResponse(User user) {
		if (user == null) {
			return null;
		}
		return new UserResponse(user.getId(), user.getEmail(), user.getUsername());
	}
}
