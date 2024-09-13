package ci.digitalacademy.forumv1.repositories;

import ci.digitalacademy.forumv1.models.Message;
import ci.digitalacademy.forumv1.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySlug(String slug);
}
