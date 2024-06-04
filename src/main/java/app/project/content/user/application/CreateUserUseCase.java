package app.project.content.user.application;

import app.project.content.user.domain.entity.User;

public interface CreateUserUseCase {

    Long saveUser(User user);
}
