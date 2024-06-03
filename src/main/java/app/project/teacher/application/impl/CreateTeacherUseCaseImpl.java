package app.project.teacher.application.impl;

import app.project.teacher.application.CreateTeacherUseCase;
import app.project.teacher.domain.entity.User;
import app.project.teacher.domain.repository.CreateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTeacherUseCaseImpl implements CreateTeacherUseCase {

    private final CreateUserRepository createUserRepository;


    @Override
    public Long saveUser(User user) {
        return createUserRepository.createUser(user);
    }
}
