package app.project.teacher.infrastructure.controller;

import app.project.teacher.application.RetrieveTeacherUseCase;
import app.project.teacher.application.mapper.TeacherDtoMapper;
import app.project.teacher.domain.entity.User;
import app.project.teacher.infrastructure.controller.dto.output.UserOutputDto;
import app.project.teacher.infrastructure.controller.dto.output.UserOutputDtoDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class RetrieveTeacherController {

    private final RetrieveTeacherUseCase retrieveTeacherUseCase;


    // GET |-> http://localhost:8080/users?outerType=full | ?outerType=full
    @GetMapping
    public ResponseEntity<List<?>> findAllUser(
            @RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

//        List<UserOutputDto> userOutputDtoList = UserDtoMapper.INSTANCE.toOutputDtoList(
//                retrieveUserUseCase.findAll()
//        );

        if ("full".equalsIgnoreCase(outerType)) {

            List<User> userList = retrieveTeacherUseCase.findAll();
            ArrayList<UserOutputDto> userOutputDtoList = new ArrayList<>();
            for (User user : userList) {

                UserOutputDto userOutputDto = new UserOutputDto();
                userOutputDto.setIdUser(user.getIdUser());
                userOutputDto.setEmail(user.getEmail());
                userOutputDto.setFullName(user.getName() + " " + user.getSurname());

                userOutputDtoList.add(userOutputDto);
            }

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
//                            UserDtoMapper.INSTANCE.toOutputDtoDetailsList(
//                                    retrieveUserUseCase.findAll()
//                            )
                            userOutputDtoList
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        TeacherDtoMapper.INSTANCE.toOutputDtoList(
                                retrieveTeacherUseCase.findAll()
                        )
                );
    }

    // GET |-> http://localhost:8080/users/3
    @GetMapping("/{idUser}")
    public ResponseEntity<UserOutputDtoDetails> findUserByIdUser(@PathVariable Long idUser) {

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        TeacherDtoMapper.INSTANCE.toOutputDtoDetails(
                                retrieveTeacherUseCase.findByIdUser(idUser)
                        )
                );
    }
}
