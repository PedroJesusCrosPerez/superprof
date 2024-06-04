package app.project.content.user.domain.repository;

import app.project.content.user.domain.entity.User;

public abstract interface UpdateUserRepository {

    User updateUser(User user);
}
