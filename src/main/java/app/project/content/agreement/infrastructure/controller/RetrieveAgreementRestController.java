package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementDtoMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class RetrieveAgreementRestController {

    private final RetrieveAgreementUseCase retrieveAgreementUseCase;


    @GetMapping
    public ResponseEntity<List<?>> findAll(
            @RequestParam(value = "outerType", required = false, defaultValue = "simple") String outerType
    ) {

        if (outerType.equals("full")) {

            List<Agreement> agreementsList = retrieveAgreementUseCase.findAll();
            List<AgreementOutputDtoFull> agreementsDtoFullList = AgreementDtoMapper.INSTANCE.toOutputDtoListFull(agreementsList);

            return ResponseEntity
                    .status(
                            HttpStatus.OK
                    )
                    .body(
//                            AgreementDtoMapper.INSTANCE.toOutputDtoListFull(
//                                    retrieveAgreementUseCase.findAll()
//                            )
                            agreementsDtoFullList
                    );
        }


        return ResponseEntity
                .status(
                        HttpStatus.OK
                )
                .body(
                        AgreementDtoMapper.INSTANCE.toOutputDtoList(
                                retrieveAgreementUseCase.findAll()
                        )
                );
    }

    @GetMapping("/{idAgreement}")
    public ResponseEntity<AgreementOutputDto> findById(@PathVariable Long idAgreement) {

        return ResponseEntity
                .status(
                        HttpStatus.OK
                )
                .body(
                        AgreementDtoMapper.INSTANCE.toOutputDto(
                                retrieveAgreementUseCase.findById(idAgreement)
                        )
                );
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<AgreementOutputDtoFull>> findAllPageable(
            @PageableDefault(page = 0, size = 5) Pageable pageable
    ) {

        Page<Agreement> agreementsPage =  retrieveAgreementUseCase.findAll(pageable);

        Page<AgreementOutputDtoFull> agreementOutputDtoFullPage = agreementsPage.map(AgreementDtoMapper.INSTANCE::toOutputDtoFull);

        return ResponseEntity
                .status(
                        HttpStatus.OK
                )
                .body(
                        agreementOutputDtoFullPage
                );
    }
}
