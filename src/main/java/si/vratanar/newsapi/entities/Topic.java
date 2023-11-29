package si.vratanar.newsapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer level;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String nameEn;

    @OneToMany(mappedBy = "child")
    private Set<TopicHierarchy> parents;

    @OneToMany(mappedBy = "parent")
    private Set<TopicHierarchy> children;

    @OneToMany(mappedBy = "topicLeaf")
    Set<Post> topicPosts;
}
