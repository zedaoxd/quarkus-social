package com.bruno.infrastructure.service;

import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.model.User;
import com.bruno.domain.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> get() {
        var optional = userRepository.get();
        return optional.orElseThrow();
    }

    public User getById(Long id) {
        return userRepository.getById(id).orElseThrow();
    }

    @Transactional
    public User create(UserCreateDTO dto) {
        return userRepository.create(dto);
    }
}
