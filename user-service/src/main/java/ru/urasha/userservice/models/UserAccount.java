package ru.urasha.userservice.models;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_account", indexes = {
        @Index(name = "idx_username", columnList = "username")
})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        return (role == null) ? List.of() : List.of(role);
    }
}
