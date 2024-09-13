package ci.digitalacademy.forumv1.repositories;


import ci.digitalacademy.forumv1.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySlug(String slug);
}
