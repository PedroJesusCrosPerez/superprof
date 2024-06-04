package app.project.content.user.application;

import app.project.content.user.domain.entity.User;

import java.util.List;

public interface RetrieveUserUseCase {

    User findByIdUser(Long idUser);

    List<User> findAll();
}
