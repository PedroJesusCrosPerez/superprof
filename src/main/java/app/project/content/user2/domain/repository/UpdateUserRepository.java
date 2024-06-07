package app.project.content.user2.domain.repository;

import app.project.content.user2.domain.entity.User;

public abstract interface UpdateUserRepository {

    User updateUser(User user);
}
