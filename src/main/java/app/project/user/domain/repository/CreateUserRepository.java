package app.project.user.domain.repository;

import app.project.user.domain.entity.User;

public abstract interface CreateUserRepository {

    Long createUser(User user);
}
