package app.project.user.domain.repository;

import app.project.user.domain.entity.User;

import java.util.List;

public abstract interface RetrieveUserRepository {

    List<User> findAll();

    User findByIdUser(Long idUser);
}
