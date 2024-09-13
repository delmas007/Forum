package ci.digitalacademy.forumv1.repositories;

import ci.digitalacademy.forumv1.models.Forum;
import ci.digitalacademy.forumv1.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findBySlug(String slug);
}
