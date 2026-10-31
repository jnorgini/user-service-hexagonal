package com.norgini.infrastructure.adapters.in.web;

import com.norgini.application.ports.in.CreateUserUseCase;
import com.norgini.application.ports.in.DeleteUserUseCase;
import com.norgini.application.ports.in.FindUserUseCase;
import com.norgini.application.ports.in.UpdateUserUseCase;
import com.norgini.domain.model.User;
import com.norgini.infrastructure.adapters.in.web.dto.UserRequest;
import com.norgini.infrastructure.adapters.in.web.dto.UserResponse;
import com.norgini.infrastructure.adapters.in.web.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final CreateUserUseCase createUserUseCase;
	private final FindUserUseCase findUserUseCase;
	private final UpdateUserUseCase updateUserUseCase;
	private final DeleteUserUseCase deleteUserUseCase;
	private final UserMapper userMapper;

	@PostMapping
	public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest request) {
		User userDomain = userMapper.toDomain(request);
		User savedUser = createUserUseCase.execute(userDomain);
		return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toResponse(savedUser));
	}

	@GetMapping
	public ResponseEntity<List<UserResponse>> findAll() {
		List<UserResponse> users = findUserUseCase.findAll().stream().map(userMapper::toResponse).toList();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
		return findUserUseCase.findById(id).map(userMapper::toResponse).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody @Valid UserRequest request) {
		User userDomain = userMapper.toDomain(request);
		User updatedUser = updateUserUseCase.execute(id, userDomain);
		return ResponseEntity.ok(userMapper.toResponse(updatedUser));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		deleteUserUseCase.execute(id);
		return ResponseEntity.noContent().build();
	}
	
}
