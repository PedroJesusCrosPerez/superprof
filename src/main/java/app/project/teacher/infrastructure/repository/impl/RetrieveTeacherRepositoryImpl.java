package app.project.teacher.infrastructure.repository.impl;

import app.project.teacher.application.mapper.TeacherEntityMapper;
import app.project.teacher.domain.entity.User;
import app.project.teacher.domain.repository.RetrieveUserRepository;
import app.project.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.project.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RetrieveTeacherRepositoryImpl implements RetrieveUserRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public List<User> findAll() {

//        return UserEntityMapper.INSTANCE.toEntityList(
//                userRepositoryJpa.findAll()
//        );

        List<TeacherJpa> usersJpa = teacherRepositoryJpa.findAll();
        List<User> users = TeacherEntityMapper.INSTANCE.toEntityList(usersJpa);

        return users;
    }

    @Override
    public User findByIdUser(Long idUser) {

        return teacherRepositoryJpa.findById(idUser)
                .map(TeacherEntityMapper.INSTANCE::toEntity)
                // TODO cambiar por excepcion personalizada
                .orElseThrow( () -> new EntityNotFoundException("User not found"));
    }
}
