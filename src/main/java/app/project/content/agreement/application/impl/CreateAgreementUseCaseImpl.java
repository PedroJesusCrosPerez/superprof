package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.CreateAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.CreateAgreementRepository;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.language.application.LanguageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAgreementUseCaseImpl implements CreateAgreementUseCase {

    private final CreateAgreementRepository createAgreementRepository;
    private final LanguageUseCase languageUseCase;


    @Override
    public Long save(AgreementInputDto agreementInputDto) {

        Agreement agreement = AgreementEntityMapper.INSTANCE.toEntity(agreementInputDto);

        for (Long idLanguage : agreementInputDto.getIdsLanguages()) {
            agreement.addLanguage(
                    languageUseCase.findById(idLanguage)
            );
        }

        return createAgreementRepository.save(agreement);
    }

    @Override
    public Long save(Agreement agreement) {

        return createAgreementRepository.save(agreement);
    }
}
