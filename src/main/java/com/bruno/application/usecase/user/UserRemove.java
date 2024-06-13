package com.bruno.application.usecase.user;

import com.bruno.domain.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRemove {

    private final UserRepository userRepository;

    public UserRemove(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long id) {
        userRepository.remove(id);
    }
}
