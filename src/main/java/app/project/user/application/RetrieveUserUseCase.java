package app.project.user.application;

import app.project.user.domain.entity.User;

import java.util.List;

public interface RetrieveUserUseCase {

    User findByIdUser(Long idUser);

    List<User> findAll();
}
