package ci.digitalacademy.forumv1.repositories;

import ci.digitalacademy.forumv1.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Long> {
}
