package si.vratanar.newsapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDto {
    private Long id;

    @NotBlank
    private Integer title;

    @NotBlank
    private Integer titleEn;

    @Size(min = 5, max = 512)
    @NotBlank
    private String summary;

    @Size(min = 5, max = 512)
    @NotBlank
    private String summaryEn;

    @NotBlank
    private String mainContent;

    @NotBlank
    private String mainContentEn;

    @NotNull
    private LocalDateTime publishDate;
}
