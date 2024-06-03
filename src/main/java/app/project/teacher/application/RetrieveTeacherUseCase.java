package app.project.teacher.application;

import app.project.teacher.domain.entity.User;

import java.util.List;

public interface RetrieveTeacherUseCase {

    User findByIdUser(Long idUser);

    List<User> findAll();
}
