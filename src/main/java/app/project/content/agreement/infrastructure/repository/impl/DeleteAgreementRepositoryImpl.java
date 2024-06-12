package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.domain.repository.DeleteAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteAgreementRepositoryImpl implements DeleteAgreementRepository {

    private final DeleteAgreementRepository deleteAgreementRepository;


    @Override
    public Boolean delete(Long idAgreement) {

        return deleteAgreementRepository.delete(idAgreement);
    }
}
