package si.vratanar.newsapi;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdPartyBeansConfig {
    @Bean
    Faker fakerObject() {
        return new Faker();
    }
}
