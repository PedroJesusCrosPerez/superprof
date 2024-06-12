package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.CreateAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateAgreementRepositoryImpl implements CreateAgreementRepository {

    private final CreateAgreementRepository createAgreementRepository;


    @Override
    public Long save(Agreement agreement) {

        return createAgreementRepository.save(agreement);
    }
}
