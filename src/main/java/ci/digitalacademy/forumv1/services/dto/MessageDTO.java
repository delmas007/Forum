package ci.digitalacademy.forumv1.services.dto;

import ci.digitalacademy.forumv1.models.Subject;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MessageDTO {
    private Long id;
    private String slug;
    private String content;
    private LocalDate date;

    private SubjectDTO subject;
}
