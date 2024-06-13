package com.bruno.infrastructure.service;

import com.bruno.application.usecase.user.UserCreate;
import com.bruno.application.usecase.user.UserEdit;
import com.bruno.application.usecase.user.UserGet;
import com.bruno.application.usecase.user.UserGetById;
import com.bruno.application.usecase.user.UserRemove;
import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.dto.users.UserEditDTO;
import com.bruno.domain.model.User;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    private final UserGet userGet;
    private final UserCreate userCreate;
    private final UserGetById userGetById;
    private final UserEdit userEdit;
    private final UserRemove userRemove;

    public UserService(
            UserGet userGet,
            UserCreate userCreate,
            UserGetById userGetById,
            UserEdit userEdit,
            UserRemove userRemove) {
        this.userGet = userGet;
        this.userCreate = userCreate;
        this.userGetById = userGetById;
        this.userEdit = userEdit;
        this.userRemove = userRemove;
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

    @Transactional
    public User edit(UserEditDTO dto, Long id) {
        return userEdit.execute(dto, id);
    }

    @Transactional
    public void remove(Long id) {
        userRemove.execute(id);
    }
}
