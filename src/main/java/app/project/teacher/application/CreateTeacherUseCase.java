package app.project.teacher.application;

import app.project.teacher.domain.entity.User;

public interface CreateTeacherUseCase {

    Long saveUser(User user);
}
