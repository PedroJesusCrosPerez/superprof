package app.project.teacher.application.impl;

import app.project.teacher.application.DeleteTeacherUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTeacherUseCaseImpl implements DeleteTeacherUseCase {

//    private final DeleteUserRepository deleteUserRepository;


    @Override
    public Boolean deleteByIdUser(Long idUser) {
//        return deleteUserRepository.deleteByIdUser(idUser);
        return false;
    }
}
