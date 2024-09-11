package ci.digitalacademy.forumv1.services.dto;

import ci.digitalacademy.forumv1.models.Forum;
import ci.digitalacademy.forumv1.models.Message;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SubjectDTO {

    private Long id;
    private String title;
    private String description;
    private Forum forum;

    private Set<MessageDTO> message;
}
