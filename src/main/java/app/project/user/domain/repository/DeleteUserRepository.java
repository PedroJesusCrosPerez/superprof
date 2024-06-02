package app.project.user.domain.repository;

import app.project.user.domain.entity.User;

public abstract interface DeleteUserRepository {

    Boolean deleteByIdUser(Long idUser);
}
