package app.project;

import app.project.entity.Agreement;
import app.project.entity.User;
import app.project.repository.AgreementRepository;
import app.project.repository.UserRepository;
import app.project.utils.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        // Obtener los repositorios
        UserRepository userRepository = context.getBean(UserRepository.class);
        AgreementRepository agreementRepository = context.getBean(AgreementRepository.class);

        // Crear y guardar usuarios
        User teacher1 = new User(null, "teacher1@gmail.com", "1234", new HashSet<>(Set.of(UserRole.TEACHER)), "John", "Doe");
        User teacher2 = new User(null, "teacher2@gmail.com", "1234", new HashSet<>(Set.of(UserRole.TEACHER)), "Emily", "Johnson");
        User student1 = new User(null, "student1@gmail.com", "1234", new HashSet<>(Set.of(UserRole.STUDENT)), "Jane", "Smith");
        User student2 = new User(null, "student2@gmail.com", "1234", new HashSet<>(Set.of(UserRole.STUDENT)), "Michael", "Brown");

        teacher1 = userRepository.save(teacher1);
        student1 = userRepository.save(student1);
        teacher2 = userRepository.save(teacher2);
        student2 = userRepository.save(student2);

        // Crear y guardar acuerdos
        Agreement agreement1 = new Agreement(
                null,
                LocalDateTime.of(2023, 9, 19, 10, 30, 11),
                LocalDateTime.of(2023, 9, 19, 11, 30, 11),
                1,
                teacher1,
                student1,
                null
        );

        Agreement agreement2 = new Agreement(
                null,
                LocalDateTime.of(2023, 10, 20, 9, 0, 0),
                LocalDateTime.of(2023, 10, 20, 10, 0, 0),
                2,
                teacher2,
                student1,
                null
        );

        Agreement agreement3 = new Agreement(
                null,
                LocalDateTime.of(2023, 11, 21, 14, 0, 0),
                LocalDateTime.of(2023, 11, 21, 15, 0, 0),
                3,
                teacher1,
                student2,
                null
        );

        List<Agreement> agreementList = Arrays.asList(agreement1, agreement2, agreement3);
        agreementRepository.saveAll(agreementList);

        System.out.println(agreementList);
    }
}
