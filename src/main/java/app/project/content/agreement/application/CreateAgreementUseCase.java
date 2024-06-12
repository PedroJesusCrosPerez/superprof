package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;

public interface CreateAgreementUseCase {

    Long save(Agreement agreement);

    Long save(AgreementInputDto agreementInputDto);
}
