package si.vratanar.newsapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;

    @Column(length = 50, unique = true, nullable = false)
    @NotNull
    private String authorityName;

    @OneToMany(mappedBy = "authority")
    private Set<UserAuthority> authorityUsers;

    public GrantedAuthority grantedAuthority() {
        return new SimpleGrantedAuthority(this.authorityType.toString());
    }
}
