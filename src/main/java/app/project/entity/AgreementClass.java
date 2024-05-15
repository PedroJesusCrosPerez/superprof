package app.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@Table(name = "AgreementClass")
public class AgreementClass {

    @Id @GeneratedValue
    private Long id;
    private LocalDateTime datetime;
    private boolean available;

//    @ManyToOne() // TODO
    private Long agreementId;
}
