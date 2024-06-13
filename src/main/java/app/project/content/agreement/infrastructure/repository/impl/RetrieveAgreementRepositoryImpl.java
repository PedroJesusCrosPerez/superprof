package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.RetrieveAgreementRepository;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import app.project.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RetrieveAgreementRepositoryImpl implements RetrieveAgreementRepository {

    private final AgreementRepositoryJpa agreementRepositoryJpa;


    @Override
    public Agreement findById(Long idAgreement) {

        return agreementRepositoryJpa.findById(idAgreement)
                .map(AgreementEntityMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new NotFoundException(Agreement.class, idAgreement)
                );
    }

    @Override
    public List<Agreement> findAll() {

        return agreementRepositoryJpa.findAll().stream()
                .map(AgreementEntityMapper.INSTANCE::toEntity)
                .toList();
    }
}
