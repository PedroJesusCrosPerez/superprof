package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.RetrieveAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RetrieveAgreementRepositoryImpl implements RetrieveAgreementRepository {

    private final RetrieveAgreementRepository retrieveAgreementRepository;


    @Override
    public Agreement findById(Long idAgreement) {

        return retrieveAgreementRepository.findById(idAgreement);
    }

    @Override
    public List<Agreement> findAll() {

        return retrieveAgreementRepository.findAll();
    }
}
