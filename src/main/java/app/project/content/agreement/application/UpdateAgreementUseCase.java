package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;

public interface UpdateAgreementUseCase {

    Agreement update(Agreement agreement);
}
