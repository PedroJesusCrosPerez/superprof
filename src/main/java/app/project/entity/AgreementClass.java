package app.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AgreementClass")
public class AgreementClass {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime datetime;

    @NonNull
    @Column(nullable = false)
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "agreement_id", nullable = false)
    private Agreement agreement;
}
