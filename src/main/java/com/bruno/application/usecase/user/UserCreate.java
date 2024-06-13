package com.bruno.application.usecase.user;

import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.model.User;
import com.bruno.domain.repository.UserRepository;

public class UserCreate {
    private final UserRepository userRepository;

    public UserCreate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UserCreateDTO dto) {
        return userRepository.create(dto);
    }
}
