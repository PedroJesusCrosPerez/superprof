package app.project.content.agreement.application.mapper;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementUpdateInputDto;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgreementEntityMapper {

    AgreementEntityMapper INSTANCE = Mappers.getMapper(AgreementEntityMapper.class);


    // Entity
    Agreement toEntity(AgreementInputDto agreementInputDto);

    Agreement toEntity(AgreementUpdateInputDto agreementUpdateInputDto);

    Agreement toEntity(AgreementJpa agreementJpa);


    // EntityJpa
    AgreementJpa toEntityJpa(Agreement agreement);
}
