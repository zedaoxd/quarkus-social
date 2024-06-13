package com.bruno.domain.repository;

import java.util.Optional;

import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.dto.users.UserEditDTO;
import com.bruno.domain.model.User;

public interface UserRepository {
    Optional<Iterable<User>> get();

    Optional<User> getById(Long id);

    User create(UserCreateDTO user);

    User edit(UserEditDTO user, Long id);

    void remove(Long id);
}
