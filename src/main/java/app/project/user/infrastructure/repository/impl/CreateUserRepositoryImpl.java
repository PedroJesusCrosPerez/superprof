package app.project.user.infrastructure.repository.impl;

import app.project.user.application.mapper.UserEntityMapper;
import app.project.user.domain.entity.User;
import app.project.user.domain.repository.CreateUserRepository;
import app.project.user.infrastructure.repository.jpa.UserRepositoryJpa;
import app.project.user.infrastructure.repository.jpa.entity.UserJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateUserRepositoryImpl implements CreateUserRepository {

    private final UserRepositoryJpa userRepositoryJpa;


    @Override
    public Long createUser(User user) {

        UserJpa userJpa = UserEntityMapper.INSTANCE.toEntityJpa(user);

        userRepositoryJpa.saveAndFlush(
                userJpa
        );
        return user.getIdUser();
    }
}
