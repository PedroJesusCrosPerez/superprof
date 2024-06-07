package app.project.content.user2.infrastructure.controller.dto.output;

import app.project.shared.enums.ERole;
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
    private List<ERole> ERoles;
}
