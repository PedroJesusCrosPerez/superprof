package app.project.teacher.application.impl;

import app.project.teacher.application.RetrieveTeacherUseCase;
import app.project.teacher.domain.entity.User;
import app.project.teacher.domain.repository.RetrieveUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveTeacherUseCaseImpl implements RetrieveTeacherUseCase {

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
