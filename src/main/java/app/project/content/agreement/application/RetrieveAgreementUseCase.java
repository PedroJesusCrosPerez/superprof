package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;

import java.util.List;

public interface RetrieveAgreementUseCase {

    Agreement findById(Long idAgreement);

    List<Agreement> findAll();
}
