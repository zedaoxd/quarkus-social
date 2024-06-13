package com.bruno.util;

import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.model.User;
import com.bruno.infrastructure.db.entity.UserEntity;

public class Mapper {

    public static User toUser(UserEntity entity) {
        var user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setAge(entity.getAge());

        return user;
    }

    public static UserEntity toUserEntity(User user) {
        var entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setAge(user.getAge());

        return entity;
    }

    public static UserEntity toUserEntity(UserCreateDTO user) {
        var entity = new UserEntity();
        entity.setName(user.name());
        entity.setAge(user.age());

        return entity;
    }
}
