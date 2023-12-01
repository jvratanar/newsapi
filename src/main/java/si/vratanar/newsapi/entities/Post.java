package si.vratanar.newsapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 128, nullable = false)
    @Size(min = 5, max = 128)
    @NotBlank
    private String title;

    @Column(length = 128, nullable = false)
    @Size(min = 5, max = 128)
    @NotBlank
    private String titleEn;

    @Column(length = 128, nullable = false)
    @Size(min = 5, max = 512)
    @NotBlank
    private String summary;

    @Column(length = 128, nullable = false)
    @Size(min = 5, max = 512)
    @NotBlank
    private String summaryEn;

    @Column(columnDefinition = "text", nullable = false)
    @NotBlank
    private String mainContent;

    @Column(columnDefinition = "text", nullable = false)
    @NotBlank
    private String mainContentEn;

    @Column(nullable = false)
    @NotNull
    private LocalDateTime publishDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @ManyToOne
    private PostStatus status;

    @ManyToOne
    private Topic topicLeaf;

    @OneToMany(mappedBy = "post")
    private Set<UserPost> postUsers;

    @OneToMany(mappedBy = "post")
    private Set<PostImage> postImages;
}
