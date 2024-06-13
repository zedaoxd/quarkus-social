package com.bruno.application.usecase.user;

import com.bruno.domain.model.User;
import com.bruno.domain.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserGetById {

    private UserRepository userRepository;

    public UserGetById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long id) {
        return userRepository.getById(id).orElseThrow();
    }
}
