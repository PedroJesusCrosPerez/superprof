package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.RetrieveAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveAgreementUseCaseImpl implements RetrieveAgreementUseCase {

    private final RetrieveAgreementRepository retrieveAgreementRepository;


    @Override
    public Agreement findById(Long idAgreement) {

        return retrieveAgreementRepository.findById(idAgreement);
    }

    @Override
    public List<Agreement> findAll() {

        List<Agreement> agreementList = retrieveAgreementRepository.findAll();

        return agreementList;
//        return retrieveAgreementRepository.findAll();
    }

    @Override
    public Page<Agreement> findAll(Pageable pageable) {

        return retrieveAgreementRepository.findAll(pageable);
    }
}
