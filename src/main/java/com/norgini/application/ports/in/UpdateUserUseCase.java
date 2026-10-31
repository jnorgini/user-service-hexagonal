package com.norgini.application.ports.in;

import com.norgini.domain.model.User;

public interface UpdateUserUseCase {

	User execute(Long id, User user);

}
