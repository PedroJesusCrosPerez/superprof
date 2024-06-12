package app.project.content.agreement.infrastructure.repository.jpa.entity;

import app.project.shared.enums.EPlace;
import jakarta.persistence.*;
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

    @Column(name = "title")
    private String title;

    @ElementCollection(targetClass = EPlace.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "agreement_place")
    @Column(name = "places")
    private List<EPlace> places;
}
