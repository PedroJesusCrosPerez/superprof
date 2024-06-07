package app.project.content.user2.application.mapper;

import app.project.content.user2.domain.entity.User;
import app.project.content.user2.infrastructure.controller.dto.output.UserOutputDto;
import app.project.content.user2.infrastructure.controller.dto.output.UserOutputDtoDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {PersonEntityMapper.class})
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);


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
