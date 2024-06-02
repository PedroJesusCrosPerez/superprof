package app.project.user.application.impl;

import app.project.user.application.CreateUserUseCase;
import app.project.user.domain.entity.User;
import app.project.user.domain.repository.CreateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserRepository createUserRepository;


    @Override
    public Long saveUser(User user) {
        return createUserRepository.createUser(user);
    }
}
