package ci.digitalacademy.forumv1.services.dto;


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
