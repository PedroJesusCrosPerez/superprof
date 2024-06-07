package app.project.content.user2.application;

import app.project.content.user2.domain.entity.User;

public interface CreateUserUseCase {

    Long saveUser(User user);
}
