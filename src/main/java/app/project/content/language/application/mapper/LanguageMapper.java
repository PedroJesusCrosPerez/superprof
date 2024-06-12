package app.project.content.language.application.mapper;

import app.project.content.language.domain.entity.Language;
import app.project.content.language.infrastructure.controller.dto.input.LanguageInputDto;
import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDto;
import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);


    // Entity
    Language toEntity(LanguageInputDto languageInputDto);

    Language toEntity(LanguageJpa languageJpa);


    // Entity Jpa
    LanguageJpa toEntityJpa(Language language);


    // OutputDto
    LanguageOutputDto toOutputDto(Language language);

    List<LanguageOutputDto> toOutputDtoList(List<Language> languageList);
}
