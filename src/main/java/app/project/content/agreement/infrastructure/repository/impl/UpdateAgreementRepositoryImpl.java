package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.UpdateAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateAgreementRepositoryImpl implements UpdateAgreementRepository {

    private final UpdateAgreementRepository updateAgreementRepository;


    @Override
    public Agreement update(Agreement agreement) {

        return updateAgreementRepository.update(agreement);
    }
}
