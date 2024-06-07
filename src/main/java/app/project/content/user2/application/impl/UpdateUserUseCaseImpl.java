package app.project.content.user2.application.impl;

import app.project.content.user2.application.UpdateUserUseCase;
import app.project.content.user2.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

//    private final UpdateUserRepository updateUserRepository;


    @Override
    public User updateUser(User user) {
//        return updateUserRepository.updateUser(user2);
        return new User();
    }
}
