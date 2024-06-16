package app.project.content.agreement.application.mapper;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFull;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgreementDtoMapper {

    AgreementDtoMapper INSTANCE = Mappers.getMapper(AgreementDtoMapper.class);


    // OutputDto
    AgreementOutputDto toOutputDto(Agreement agreement);

    List<AgreementOutputDto> toOutputDtoList(List<Agreement> agreementList);

    AgreementOutputDtoFull toOutputDtoFull(Agreement agreement);

    List<AgreementOutputDtoFull> toOutputDtoListFull(List<Agreement> agreement);
}
