package app.project.teacher.infrastructure.repository.impl;

import app.project.teacher.application.mapper.TeacherEntityMapper;
import app.project.teacher.domain.entity.User;
import app.project.teacher.domain.repository.CreateUserRepository;
import app.project.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.project.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateTeacherRepositoryImpl implements CreateUserRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public Long createUser(User user) {

        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(user);

        teacherRepositoryJpa.saveAndFlush(
                teacherJpa
        );
        return user.getIdUser();
    }
}
