package app.project.content.user2.infrastructure.repository.jpa.entity;
//
//import app.project.shared.enums.ERole;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "user2")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode(exclude = {"password", "name", "surname", "roles"})
//public class UserJpa {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_user")
//    private Long idUser;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "surname")
//    private String surname;
//
//    @ElementCollection(targetClass = ERole.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_user"))
//    @Enumerated(EnumType.STRING)
//    @Column(name = "role")
//    private List<ERole> ERoles;
//
//
//    @PrePersist
//    public void setDefaultRole() {
//
//        if (ERoles == null || ERoles.isEmpty()) {
//            ERoles = new ArrayList<>(List.of(ERole.ROLE_USER));
//        }
//    }
//}
