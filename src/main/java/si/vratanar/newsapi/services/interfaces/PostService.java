package si.vratanar.newsapi.services.interfaces;

import org.springframework.data.domain.Page;
import si.vratanar.newsapi.dtos.PostDto;

import java.time.LocalDateTime;

public interface PostService {
    Page<PostDto> listPosts(LocalDateTime publishDate, Integer pageNumber, Integer pageSize);
}
