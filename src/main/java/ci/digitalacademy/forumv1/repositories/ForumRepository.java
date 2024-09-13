package ci.digitalacademy.forumv1.repositories;

import ci.digitalacademy.forumv1.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ForumRepository extends JpaRepository<Forum, Long> {
    Optional<Forum> findBySlug(String slug);
}
