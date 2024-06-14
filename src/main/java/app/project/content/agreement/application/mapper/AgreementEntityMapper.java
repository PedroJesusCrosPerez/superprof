package app.project.content.agreement.application.mapper;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementUpdateInputDto;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgreementEntityMapper {

    AgreementEntityMapper INSTANCE = Mappers.getMapper(AgreementEntityMapper.class);


    // Entity
    @Mappings({
            @Mapping(target = "idAgreement", ignore = true),
            @Mapping(target = "languages", ignore = true),
//            @Mapping(target = "places", ignore = true),
    })
    Agreement toEntity(AgreementInputDto agreementInputDto);

    Agreement toEntity(AgreementUpdateInputDto agreementUpdateInputDto);

    Agreement toEntity(AgreementJpa agreementJpa);


    // EntityJpa
    AgreementJpa toEntityJpa(Agreement agreement);
}
