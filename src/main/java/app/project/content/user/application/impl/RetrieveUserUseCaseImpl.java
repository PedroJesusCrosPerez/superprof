package app.project.content.user.application.impl;

import app.project.content.user.application.RetrieveUserUseCase;
import app.project.content.user.domain.entity.User;
import app.project.content.user.domain.repository.RetrieveUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveUserUseCaseImpl implements RetrieveUserUseCase {

    private final RetrieveUserRepository retrieveUserRepository;


    @Override
    public User findByIdUser(Long idUser) {
        return retrieveUserRepository.findByIdUser(idUser);
    }

    @Override
    public List<User> findAll() {
        return retrieveUserRepository.findAll();
    }
}
