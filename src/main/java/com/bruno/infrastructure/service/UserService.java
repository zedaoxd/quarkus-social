package com.bruno.infrastructure.service;

import com.bruno.application.usecase.user.UserCreate;
import com.bruno.application.usecase.user.UserGet;
import com.bruno.application.usecase.user.UserGetById;
import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.model.User;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    private final UserGet userGet;
    private final UserCreate userCreate;
    private final UserGetById userGetById;

    public UserService(UserGet userGet, UserCreate userCreate, UserGetById userGetById) {
        this.userGet = userGet;
        this.userCreate = userCreate;
        this.userGetById = userGetById;
    }

    public Iterable<User> get() {
        return userGet.execute();
    }

    public User getById(Long id) {
        return userGetById.execute(id);
    }

    @Transactional
    public User create(UserCreateDTO dto) {
        return userCreate.execute(dto);
    }
}
