package app.project.content.role.domain.entity;

import app.project.shared.enums.ERole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_role")
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = "name", length = 20)
  private ERole name;

  public Role(ERole name) {
    this.name = name;
  }
}