package app.project.teacher.application.mapper;

import app.project.teacher.domain.entity.User;
import app.project.teacher.infrastructure.controller.dto.output.UserOutputDto;
import app.project.teacher.infrastructure.controller.dto.output.UserOutputDtoDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {PersonEntityMapper.class})
public interface TeacherDtoMapper {

    TeacherDtoMapper INSTANCE = Mappers.getMapper(TeacherDtoMapper.class);


    UserOutputDto toOutputDto(User user);

    UserOutputDtoDetails toOutputDtoDetails(User user);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
    })
    List<UserOutputDto> toOutputDtoList(List<User> userList);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
    })
    List<UserOutputDtoDetails> toOutputDtoDetailsList(List<User> userList);
}
