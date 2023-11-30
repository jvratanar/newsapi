package si.vratanar.newsapi.factories;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.vratanar.newsapi.dtos.PostDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PostDtoFactory {
    public static final String ALTERNATE_LANG = "EN";

    private final Faker faker;

    public List<PostDto> makeList(int size) {
        List<PostDto> postDtoList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            postDtoList.add(this.make());
        }

        return postDtoList;
    }

    public PostDto make() {
        String title = this.faker.book().title();
        String summary = this.faker.lorem().paragraph();
        List<String> mainContentParagraphs = this.faker.lorem().paragraphs(this.faker.random().nextInt(4, 10));
        String mainContent = mainContentParagraphs.stream().reduce("", (lines, line) -> lines + "\n");
        Date publishDate = this.faker.date().between(this.faker.date().past(170, TimeUnit.DAYS),
                this.faker.date().future(170, TimeUnit.DAYS));
        LocalDateTime publishDateLDT = LocalDateTime.of(
                LocalDate.ofInstant(publishDate.toInstant(), ZoneId.systemDefault()), LocalTime.of(10, 30));
        return PostDto.builder()
                .id(new Random().nextLong())
                .title(title)
                .titleEn(ALTERNATE_LANG + title)
                .summary(summary)
                .summaryEn(ALTERNATE_LANG + title)
                .mainContent(mainContent)
                .mainContentEn(ALTERNATE_LANG + mainContent)
                .publishDate(publishDateLDT)
                .build();
    }
}
