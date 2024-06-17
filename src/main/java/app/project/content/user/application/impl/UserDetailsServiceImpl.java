package app.project.content.user.application.impl;

import app.project.content.role.domain.entity.Role;
import app.project.content.role.domain.repository.RoleRepository;
import app.project.content.user.domain.entity.User;
import app.project.content.user.domain.repository.UserRepository;
import app.project.content.user.infrastructure.dto.input.SignupRequest;
import app.project.shared.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username)
        .orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with username: " + username)
        );

    return UserDetailsImpl.build(user);
  }

  public User findByEmail(String email) {
    return userRepository.findByEmail(email)
            .orElseThrow(
                    () -> new RuntimeException("User Not Found with email: " + email)
            );
  }

  public void saveUser(SignupRequest signupRequest) {
    User user = new User();
    user.setUsername(signupRequest.getUsername());
    user.setEmail(signupRequest.getEmail());
    user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

    System.out.println("ROLE_ADMIN");
    System.out.println(ERole.ROLE_ADMIN.toString());
    String strRole = ERole.ROLE_ADMIN.toString();
    System.out.println(strRole);
//    Role role = roleRepository.findByName(ERole.ROLE_ADMIN)
    Role role = roleRepository.findByName("ROLE_" + ERole.ROLE_ADMIN)
            .orElseThrow(
                    () -> new RuntimeException("Error: Role is not found.")
            );

    if (role == null) {
      role = new Role(ERole.ROLE_USER);
      role = roleRepository.save(role);
    }

    user.setRoles(Set.of(role));
    userRepository.save(user);
  }

}
