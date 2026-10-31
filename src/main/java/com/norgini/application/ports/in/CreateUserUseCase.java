package com.norgini.application.ports.in;

import com.norgini.domain.model.User;

public interface CreateUserUseCase {
	
	User execute(User user);

}
