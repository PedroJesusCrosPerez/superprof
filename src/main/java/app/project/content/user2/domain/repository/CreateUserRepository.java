package app.project.content.user2.domain.repository;

import app.project.content.user2.domain.entity.User;

public abstract interface CreateUserRepository {

    Long createUser(User user);
}
