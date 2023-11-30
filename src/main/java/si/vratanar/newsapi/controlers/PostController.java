package si.vratanar.newsapi.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import si.vratanar.newsapi.dtos.PostDto;
import si.vratanar.newsapi.services.interfaces.PostService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PostController {
    public static final String POST_PATH = "/api/v1/post";

    private final PostService postService;

    @GetMapping(POST_PATH)
    public Page<PostDto> listPosts(@RequestParam LocalDateTime fromDate,
                                   @RequestParam Integer pageNumber,
                                   @RequestParam Integer pageSize) {
        return this.postService.listPosts(fromDate, pageNumber, pageSize);
    }
}
