package com.bruno.application.usecase.user;

import com.bruno.domain.dto.users.UserEditDTO;
import com.bruno.domain.model.User;
import com.bruno.domain.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserEdit {
    private final UserRepository userRepository;

    public UserEdit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UserEditDTO dto, Long id) {
        return userRepository.edit(dto, id);
    }
}
