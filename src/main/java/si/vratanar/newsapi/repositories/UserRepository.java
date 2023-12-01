package si.vratanar.newsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import si.vratanar.newsapi.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String s);
}
