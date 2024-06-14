package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.CreateAgreementRepository;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateAgreementRepositoryImpl implements CreateAgreementRepository {

    private final AgreementRepositoryJpa agreementRepositoryJpa;


    @Override
    public Long save(Agreement agreement) {

        AgreementJpa agreementJpa = AgreementEntityMapper.INSTANCE.toEntityJpa(agreement);

        return agreementRepositoryJpa.save(
//                AgreementEntityMapper.INSTANCE.toEntityJpa(agreement)
                agreementJpa
        ).getIdAgreement();
    }
}
