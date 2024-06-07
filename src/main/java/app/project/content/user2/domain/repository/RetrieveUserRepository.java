package app.project.content.user2.domain.repository;

import app.project.content.user2.domain.entity.User;

import java.util.List;

public abstract interface RetrieveUserRepository {

    List<User> findAll();

    User findByIdUser(Long idUser);
}