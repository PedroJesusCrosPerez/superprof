package app.project.content.user2.infrastructure.repository.impl;

import app.project.content.user2.application.mapper.UserEntityMapper;
import app.project.content.user2.domain.entity.User;
import app.project.content.user2.domain.repository.RetrieveUserRepository;
import app.project.content.user2.infrastructure.repository.jpa.UserRepositoryJpa;
import app.project.content.user2.infrastructure.repository.jpa.entity.UserJpa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RetrieveUserRepositoryImpl implements RetrieveUserRepository {

    private final UserRepositoryJpa userRepositoryJpa;


    @Override
    public List<User> findAll() {

//        return UserEntityMapper.INSTANCE.toEntityList(
//                userRepositoryJpa.findAll()
//        );

        List<UserJpa> usersJpa = userRepositoryJpa.findAll();
        List<User> users = UserEntityMapper.INSTANCE.toEntityList(usersJpa);

        return users;
    }

    @Override
    public User findByIdUser(Long idUser) {

        return userRepositoryJpa.findById(idUser)
                .map(UserEntityMapper.INSTANCE::toEntity)
                // TODO cambiar por excepcion personalizada
                .orElseThrow( () -> new EntityNotFoundException("User not found"));
    }
}
