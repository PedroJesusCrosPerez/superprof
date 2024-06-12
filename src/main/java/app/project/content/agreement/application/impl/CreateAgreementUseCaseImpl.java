package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.CreateAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.CreateAgreementRepository;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAgreementUseCaseImpl implements CreateAgreementUseCase {

    private final CreateAgreementRepository createAgreementRepository;


    @Override
    public Long save(Agreement agreement) {

        return createAgreementRepository.save(agreement);
    }

    @Override
    public Long save(AgreementInputDto agreementInputDto) {

        return createAgreementRepository.save(
                AgreementEntityMapper.INSTANCE.toEntity(agreementInputDto)
        );
    }
}
