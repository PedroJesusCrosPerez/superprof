package app.project.user.application;

import app.project.user.domain.entity.User;

public interface CreateUserUseCase {

    Long saveUser(User user);
}
