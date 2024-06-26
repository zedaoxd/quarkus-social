package com.bruno.infrastructure.db.panache;

import java.util.List;
import java.util.Optional;

import com.bruno.domain.dto.users.UserCreateDTO;
import com.bruno.domain.dto.users.UserEditDTO;
import com.bruno.domain.model.User;
import com.bruno.domain.repository.UserRepository;
import com.bruno.infrastructure.db.entity.UserEntity;
import com.bruno.util.Mapper;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheUserRepository implements UserRepository, PanacheRepositoryBase<UserEntity, Long> {

    @Override
    public Optional<Iterable<User>> get() {
        List<UserEntity> entities = this.listAll(Sort.by("name"));
        Iterable<User> users = entities
                .stream()
                .map(Mapper::toUser)
                .toList();

        return Optional.of(users);
    }

    @Override
    public Optional<User> getById(Long id) {
        UserEntity entity = this.findById(id);
        User user = Mapper.toUser(entity);

        return Optional.of(user);
    }

    @Override
    public User create(UserCreateDTO dto) {
        UserEntity entity = Mapper.toUserEntity(dto);
        this.persist(entity);
        return Mapper.toUser(entity);
    }

    @Override
    public User edit(UserEditDTO user, Long id) {
        UserEntity entity = this.findById(id);

        if (entity == null) {
            return null;
        }

        if (user.name() != null) {
            entity.setName(user.name());
        }

        if (user.age() != null) {
            entity.setAge(user.age());
        }

        this.persist(entity);

        return Mapper.toUser(entity);
    }

    @Override
    public void remove(Long id) {
        this.deleteById(id);
    }
}
