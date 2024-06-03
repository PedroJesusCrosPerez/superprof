package app.project.teacher.domain.repository;

import app.project.teacher.domain.entity.User;

public abstract interface CreateUserRepository {

    Long createUser(User user);
}
