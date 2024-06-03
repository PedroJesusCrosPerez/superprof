package app.project.teacher.domain.repository;

import app.project.teacher.domain.entity.User;

import java.util.List;

public abstract interface RetrieveUserRepository {

    List<User> findAll();

    User findByIdUser(Long idUser);
}
