package app.project.user.domain.repository;

import app.project.user.domain.entity.User;

import java.util.List;

public abstract interface UpdateUserRepository {

    User updateUser(User user);
}
