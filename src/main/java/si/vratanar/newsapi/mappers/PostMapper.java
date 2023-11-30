package si.vratanar.newsapi.mappers;

import org.mapstruct.Mapper;
import si.vratanar.newsapi.dtos.PostDto;
import si.vratanar.newsapi.entities.Post;

@Mapper
public interface PostMapper {
    Post postDtoToPost(PostDto postDto);

    PostDto postToPostDto(Post post);
}
