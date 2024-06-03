package app.project.teacher.application.impl;

import app.project.teacher.application.UpdateTeacherUseCase;
import app.project.teacher.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTeacherUseCaseImpl implements UpdateTeacherUseCase {

//    private final UpdateUserRepository updateUserRepository;


    @Override
    public User updateUser(User user) {
//        return updateUserRepository.updateUser(user);
        return new User();
    }
}
