package ci.digitalacademy.forumv1.services.dto;

import ci.digitalacademy.forumv1.models.Subject;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ForumDTO {
    private Long id;
    private String name;
    private String description;
    private Set<SubjectDTO> subject;
}
