package app.project.teacher.application.mapper;

import app.project.teacher.domain.entity.User;
import app.project.teacher.infrastructure.controller.dto.input.UserCreateInputDto;
import app.project.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {PersonEntityMapper.class})
public interface TeacherEntityMapper {

    TeacherEntityMapper INSTANCE = Mappers.getMapper(TeacherEntityMapper.class);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
    })
    User toEntity(TeacherJpa teacherJpa);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
    })
    User toEntity(UserCreateInputDto userCreateInputDto);

    List<User> toEntityList(List<TeacherJpa> teacherJpaList);

    TeacherJpa toEntityJpa(User user);
}
