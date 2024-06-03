package app.project.teacher.infrastructure.repository.jpa.entity;

import app.project.shared.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"password", "name", "surname", "roles"})
public class TeacherJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idTeacher;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_teacher"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private List<Role> roles;


    @PrePersist
    public void setDefaultRole() {

        if (roles == null || roles.isEmpty()) {
            roles = new ArrayList<>(List.of(Role.USER));
        }
    }
}
