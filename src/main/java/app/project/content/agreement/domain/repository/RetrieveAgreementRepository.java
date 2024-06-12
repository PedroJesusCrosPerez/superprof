package app.project.content.agreement.domain.repository;

import app.project.content.agreement.domain.entity.Agreement;

import java.util.List;

public interface RetrieveAgreementRepository {

    Agreement findById(Long idAgreement);

    List<Agreement> findAll();
}
