package app.project.content.rate.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RateJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rate")
    private Long idRate;

    @Column(name = "price_hour")
    private Double pricePerHour;
}
