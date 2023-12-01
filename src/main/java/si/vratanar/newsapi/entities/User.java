package si.vratanar.newsapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Column(length = 128, nullable = false)
    private String password;

    private Boolean enabled;

    private Integer tokenVersion;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserAuthority> userAuthorities;

    @OneToMany(mappedBy = "user")
    private Set<UserPost> userPosts;
}
