package app.project.teacher.domain.repository;

import app.project.teacher.domain.entity.User;

public abstract interface UpdateUserRepository {

    User updateUser(User user);
}
