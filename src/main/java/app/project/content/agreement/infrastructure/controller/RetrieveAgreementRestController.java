package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementDtoMapper;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class RetrieveAgreementRestController {

    private final RetrieveAgreementUseCase retrieveAgreementUseCase;


    @GetMapping
    public ResponseEntity<List<AgreementOutputDto>> findAll() {

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
}
