package app.project.teacher.infrastructure.controller;

import app.project.teacher.application.CreateTeacherUseCase;
import app.project.teacher.application.mapper.TeacherEntityMapper;
import app.project.teacher.domain.entity.User;
import app.project.teacher.infrastructure.controller.dto.input.UserCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class CreateTeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;


    // POST |-> http://localhost:8080/users
    /**
     * [
     *   {
     *     "idUser": 1,
     *     "email": "user1@example.com",
     *     "password": "password123",
     *     "name": "Alice",
     *     "surname": "Smith",
     *     "roles": ["USER"]
     *   },
     *   {
     *     "idUser": 2,
     *     "email": "user2@example.com",
     *     "password": "password123",
     *     "name": "Bob",
     *     "surname": "Johnson",
     *     "roles": ["USER", "ADMIN"]
     *   },
     *   {
     *     "idUser": 3,
     *     "email": "user3@example.com",
     *     "password": "password123",
     *     "name": "Charlie",
     *     "surname": "Williams",
     *     "roles": ["USER", "STUDENT"]
     *   },
     *   {
     *     "idUser": 4,
     *     "email": "user4@example.com",
     *     "password": "password123",
     *     "name": "David",
     *     "surname": "Brown",
     *     "roles": ["USER"]
     *   },
     *   {
     *     "idUser": 5,
     *     "email": "user5@example.com",
     *     "password": "password123",
     *     "name": "Eve",
     *     "surname": "Jones",
     *     "roles": ["USER", "TEACHER"]
     *   },
     *   {
     *     "idUser": 6,
     *     "email": "user6@example.com",
     *     "password": "password123",
     *     "name": "Frank",
     *     "surname": "Garcia",
     *     "roles": ["USER"]
     *   },
     *   {
     *     "idUser": 7,
     *     "email": "user7@example.com",
     *     "password": "password123",
     *     "name": "Grace",
     *     "surname": "Martinez",
     *     "roles": ["USER", "ADMIN", "STUDENT"]
     *   },
     *   {
     *     "idUser": 8,
     *     "email": "user8@example.com",
     *     "password": "password123",
     *     "name": "Hank",
     *     "surname": "Rodriguez",
     *     "roles": ["USER"]
     *   },
     *   {
     *     "idUser": 9,
     *     "email": "user9@example.com",
     *     "password": "password123",
     *     "name": "Ivy",
     *     "surname": "Davis",
     *     "roles": ["USER", "TEACHER"]
     *   },
     *   {
     *     "idUser": 10,
     *     "email": "user10@example.com",
     *     "password": "password123",
     *     "name": "Jack",
     *     "surname": "Lopez",
     *     "roles": ["USER"]
     *   }
     * ]
     */
    @PostMapping
    public ResponseEntity<Long> saveUser(@RequestBody UserCreateInputDto userCreateInputDto) {

        User user = TeacherEntityMapper.INSTANCE.toEntity(userCreateInputDto);

        Long idUser = createTeacherUseCase.saveUser(user);

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        idUser
                );
    }
}
