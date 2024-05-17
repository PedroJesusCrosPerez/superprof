package app.project.entity;

import app.project.utils.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "app_user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private final String email;

    @NonNull
    @Column(nullable = false)
    private final String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

//    ###############################################################
//    ######################## INFORMATION ##########################
//    ###############################################################
    @NonNull
    @EqualsAndHashCode.Exclude
    private String first_name;

    @NonNull
    @EqualsAndHashCode.Exclude
    private String last_name;
}