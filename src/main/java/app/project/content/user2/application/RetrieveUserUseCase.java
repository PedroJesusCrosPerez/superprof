package app.project.content.user2.application;

import app.project.content.user2.domain.entity.User;

import java.util.List;

public interface RetrieveUserUseCase {

    User findByIdUser(Long idUser);

    List<User> findAll();
}
