package app.project.content.agreement.domain.entity;

import app.project.content.language.domain.entity.Language;
import app.project.content.rate.domain.entity.Rate;
import app.project.shared.enums.EPlace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agreement {

    private Long idAgreement;
    private String title;
    private String description;
    private String aboutMe;
    private List<EPlace> places;
    private List<Language> languages;
    private Rate rate;
}
