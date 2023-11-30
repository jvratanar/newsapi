package si.vratanar.newsapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import si.vratanar.newsapi.dtos.PostDto;
import si.vratanar.newsapi.entities.Post;
import si.vratanar.newsapi.mappers.PostMapper;
import si.vratanar.newsapi.repositories.PostRepository;
import si.vratanar.newsapi.services.interfaces.PostService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostServiceJpa implements PostService {
    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public Page<PostDto> listPosts(LocalDateTime publishDate, Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = this.buildPageRequest(pageNumber, pageSize);

        Page<Post> postPage;
        if (publishDate != null) {
            postPage = this.postRepository.findAllByPublishDate(publishDate, pageRequest);
        } else {
            postPage = this.postRepository.findAll(pageRequest);
        }

        return postPage.map(this.postMapper::postToPostDto);
    }

    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize) {
        int queryPageNumber;
        int queryPageSize;

        if (pageNumber != null && pageNumber > 0) {
            queryPageNumber = pageNumber - 1;
        } else {
            queryPageNumber = DEFAULT_PAGE;
        }

        if (pageSize == null) {
            queryPageSize = DEFAULT_PAGE_SIZE;
        } else {
            if (pageSize > 1000) {
                queryPageSize = 1000;
            } else {
                queryPageSize = pageSize;
            }
        }

        Sort sort = Sort.by(Sort.Order.desc("publishDate"));

        return PageRequest.of(queryPageNumber, queryPageSize, sort);
    }
}
