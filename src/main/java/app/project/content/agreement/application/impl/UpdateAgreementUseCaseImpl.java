package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.UpdateAgreementUseCase;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.UpdateAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAgreementUseCaseImpl implements UpdateAgreementUseCase {

    private final UpdateAgreementRepository updateAgreementRepository;


    @Override
    public Agreement update(Agreement agreement) {

        return updateAgreementRepository.update(agreement);
    }
}
