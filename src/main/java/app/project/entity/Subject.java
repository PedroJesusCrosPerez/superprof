package app.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Subject")
public final class Subject {

    @Id @GeneratedValue
    private int id;
    private String name;
}
