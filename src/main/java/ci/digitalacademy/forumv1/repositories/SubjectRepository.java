package ci.digitalacademy.forumv1.repositories;

import ci.digitalacademy.forumv1.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
