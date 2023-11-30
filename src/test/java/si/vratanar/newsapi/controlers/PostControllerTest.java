package si.vratanar.newsapi.controlers;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import si.vratanar.newsapi.factories.PostDtoFactory;
import si.vratanar.newsapi.services.PostServiceJpa;
import si.vratanar.newsapi.services.interfaces.PostService;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostService postService;

    PostDtoFactory postDtoFactory;

    @BeforeEach
    void setUp() {
        this.postDtoFactory = new PostDtoFactory(new Faker());
    }

    @Test
    void testListPosts() throws Exception {
        given(this.postService.listPosts(any(), any(), any()))
                .willReturn(new PageImpl<>(this.postDtoFactory.makeList(3)));

        this.mockMvc.perform(get(PostController.POST_PATH).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content.length()", is(3)));
    }
}