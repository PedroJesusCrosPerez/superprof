package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RetrieveAgreementUseCase {

    Agreement findById(Long idAgreement);

    List<Agreement> findAll();

    Page<Agreement> findAll(Pageable pageable);
}
