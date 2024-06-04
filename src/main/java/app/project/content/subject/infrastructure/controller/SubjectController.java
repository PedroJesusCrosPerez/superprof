package app.project.content.subject.infrastructure.controller;

import app.project.content.subject.application.SubjectUseCase;
import app.project.content.subject.application.mapper.SubjectMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectUseCase subjectUseCase;


    @GetMapping("/{idSubject}")
    public ResponseEntity<?> findByIdSubject(
            @PathVariable Long idSubject
            ,@RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

        Subject subject = subjectUseCase.findByIdSubject(idSubject);

        if ("full".equalsIgnoreCase(outerType)) {

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
                            SubjectMapper.INSTANCE.toOutputDtoFull(
                                    subject
                            )
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        SubjectMapper.INSTANCE.toOutputDto(
                                subject
                        )
                );
    }

    @GetMapping
    public ResponseEntity<?> findAllSubjects(
            @RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

        List<Subject> subjectList = subjectUseCase.findAllSubjects();

        if ("full".equalsIgnoreCase(outerType)) {

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
                            SubjectMapper.INSTANCE.toOutputDtoFullList(
                                    subjectList
                            )
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        SubjectMapper.INSTANCE.toOutputDtoList(
                                subjectList
                        )
                );
    }

    @PostMapping
    public ResponseEntity<Long> saveSubject(
            @RequestBody SubjectInputDto subjectInputDto
    ) {

        Long idSubject = subjectUseCase.saveSubject(
                SubjectMapper.INSTANCE.toEntity(
                        subjectInputDto
                )
        );

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        idSubject
                );
    }
}
