package si.vratanar.newsapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostImage {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 64)
    @Size(min = 5, max = 64)
    private String caption;

    @Column(length = 128, nullable = false)
    @Size(max = 128)
    @NotBlank
    private String filePath;

    @ManyToOne
    private Post post;

}
