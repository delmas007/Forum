package ci.digitalacademy.forumv1.services.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SubjectDTO {

    private Long id;
    private String slug;
    private String title;
    private String description;

    @JsonIgnore
    private ForumDTO forum;

    @JsonIgnore
    private Set<MessageDTO> message;
}
