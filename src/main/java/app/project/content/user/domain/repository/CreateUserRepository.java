package app.project.content.user.domain.repository;

import app.project.content.user.domain.entity.User;

public abstract interface CreateUserRepository {

    Long createUser(User user);
}
