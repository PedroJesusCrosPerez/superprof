package app.project.content.user.infrastructure.controller.dto.output;

import app.project.shared.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserOutputDtoDetails {

    private Long idUser;
    private String email;
    private String name;
    private String surname;
    private List<Role> roles;
}
