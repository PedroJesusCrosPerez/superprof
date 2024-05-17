package app.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "Agreement")
public class Agreement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Exclude
    @NonNull
    @Column(nullable = false)
    private LocalDateTime datetimeStart;

    @EqualsAndHashCode.Exclude
    @NonNull
    @Column(nullable = false)
    private LocalDateTime datetimeEnd;

    @EqualsAndHashCode.Exclude
    @NonNull
    @Column(nullable = false)
    private Integer period;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @NonNull
    private User teacher;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @NonNull
    private User student;

//    OPTIONAL
    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgreementClass> agreementClasses;
}
