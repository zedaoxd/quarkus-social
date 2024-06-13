package com.bruno.application.usecase.user;

import com.bruno.domain.model.User;
import com.bruno.domain.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserGet {

    private final UserRepository userRepository;

    public UserGet(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> execute() {
        var optional = userRepository.get();
        return optional.orElseThrow();
    }
}
