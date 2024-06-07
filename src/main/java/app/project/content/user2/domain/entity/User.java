package app.project.content.user2.domain.entity;

import app.project.shared.enums.ERole;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"password", "name", "surname", "roles"})
public class User {

    private Long idUser;
    private String email;
    private String password;
    private String name;
    private String surname;
    private List<ERole> ERoles;
}
