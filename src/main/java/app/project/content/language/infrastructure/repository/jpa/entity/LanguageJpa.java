package app.project.content.language.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "language")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LanguageJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLanguage;
    private String name;
    private String code;
}
