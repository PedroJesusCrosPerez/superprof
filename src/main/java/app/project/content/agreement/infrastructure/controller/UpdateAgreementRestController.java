package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.UpdateAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementDtoMapper;
import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class UpdateAgreementRestController {

    private final UpdateAgreementUseCase agreementUseCase;


    @PutMapping
    public ResponseEntity<AgreementOutputDto> updateAgreement(@RequestBody AgreementInputDto agreementInputDto) {

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        AgreementDtoMapper.INSTANCE.toOutputDto(
                                agreementUseCase.update(
                                        AgreementEntityMapper.INSTANCE.toEntity(
                                                agreementInputDto
                                        )
                                )
                        )
                );
    }
}
