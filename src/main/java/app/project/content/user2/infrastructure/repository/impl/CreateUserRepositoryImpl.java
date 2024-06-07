package app.project.content.user2.infrastructure.repository.impl;

import app.project.content.user2.application.mapper.UserEntityMapper;
import app.project.content.user2.domain.entity.User;
import app.project.content.user2.domain.repository.CreateUserRepository;
import app.project.content.user2.infrastructure.repository.jpa.UserRepositoryJpa;
import app.project.content.user2.infrastructure.repository.jpa.entity.UserJpa;
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
