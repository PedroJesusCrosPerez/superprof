package app.project.content.user.infrastructure.controller;

import app.project.config.security.jwt.JwtUtils;
import app.project.content.role.domain.repository.RoleRepository;
import app.project.content.user.application.impl.UserDetailsImpl;
import app.project.content.user.domain.entity.User;
import app.project.content.user.domain.repository.UserRepository;
import app.project.content.user.infrastructure.dto.input.LoginRequest;
import app.project.content.user.infrastructure.dto.input.SignupRequest;
import app.project.content.user.infrastructure.dto.output.JwtResponse;
import app.project.content.user.infrastructure.dto.output.MessageResponse;
import app.project.shared.enums.ERole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(
            @Valid @RequestBody LoginRequest loginRequest
    ) {

        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername()
                                ,loginRequest.getPassword()
                        )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        new JwtResponse(
                                jwt,
                                userDetails.getId(),
                                userDetails.getUsername(),
                                userDetails.getEmail(),
                                roles
                        )
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(
            @Valid @RequestBody SignupRequest signUpRequest
    ) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(
                            new MessageResponse("Error: Username is already taken!")
                    );
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(
                            new MessageResponse("Error: Email is already in use!")
                    );
        }

        // Create new user's account
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword())
        );

        user.setId(userRepository.save(user).getId()); // Generate ID


        user.addRole(
                roleRepository.findByName(ERole.ROLE_UNASSIGNED)
                        .orElseThrow(
                                () -> new RuntimeException("Error: there aren't default roles assigned in Role table.")
                        )
        );

        User newUser = userRepository.save(user);

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
//                        newUser
                        new MessageResponse("User registered successfully!" + newUser.toString())
                );
    }
}
