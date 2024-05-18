package app.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Subject")
public class Subject {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @lombok.NonNull
    @org.springframework.lang.NonNull
    private String name;
}
