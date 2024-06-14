package app.project.content.agreement.infrastructure.repository.jpa.entity;

import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import app.project.shared.enums.EPlace;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgreementJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agreement")
    private Long idAgreement;

    @Column(name = "title", nullable = false)
//    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
//    @Size(min = 10, message = "El título debe tener un mínimo de 10 caracteres")
    private String title;

//    @Column(name = "description", nullable = false)
//    @Size(max = 250, message = "El título no puede tener más de 250 caracteres")
//    @Size(min = 10, message = "El título debe tener un mínimo de 10 caracteres")
//    private String description;

    @Column(name = "description", nullable = false, length = 250)
    @Size(min = 10, max = 250, message = "La descripción debe tener entre 10 y 250 caracteres")
    private String description;

    @Column(name = "about_me")
    private String aboutMe;

    @ElementCollection(targetClass = EPlace.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "agreement_place")
    @Column(name = "places", nullable = false)
    private List<EPlace> places;

    @ManyToMany
    @JoinTable(
            name = "agreement_language",
            joinColumns = @JoinColumn(name = "agreement_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<LanguageJpa> languages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rate", referencedColumnName = "id_rate")
    private RateJpa rate;
}
