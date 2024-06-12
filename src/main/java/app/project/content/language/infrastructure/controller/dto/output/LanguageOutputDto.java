package app.project.content.language.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LanguageOutputDto {

    private Long idLanguage;
    private String name;
    private String code;
}
