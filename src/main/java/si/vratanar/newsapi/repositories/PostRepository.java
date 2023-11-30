package si.vratanar.newsapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import si.vratanar.newsapi.entities.Post;

import java.time.LocalDateTime;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByPublishDate(LocalDateTime publishDate, Pageable pageable);
}
