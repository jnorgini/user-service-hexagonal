package com.norgini.infrastructure.config;

import com.norgini.application.ports.out.UserRepositoryPort;
import com.norgini.application.service.CreateUserService;
import com.norgini.application.service.DeleteUserService;
import com.norgini.application.service.FindUserService;
import com.norgini.application.service.UpdateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public CreateUserService createUserService(UserRepositoryPort port) {
		return new CreateUserService(port);
	}

	@Bean
	public FindUserService findUserService(UserRepositoryPort port) {
		return new FindUserService(port);
	}

	@Bean
	public UpdateUserService updateUserService(UserRepositoryPort port) {
		return new UpdateUserService(port);
	}

	@Bean
	public DeleteUserService deleteUserService(UserRepositoryPort port) {
		return new DeleteUserService(port);
	}
	
}
