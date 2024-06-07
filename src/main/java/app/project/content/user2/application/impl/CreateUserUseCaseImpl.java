package app.project.content.user2.application.impl;

import app.project.content.user2.application.CreateUserUseCase;
import app.project.content.user2.domain.entity.User;
import app.project.content.user2.domain.repository.CreateUserRepository;
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
