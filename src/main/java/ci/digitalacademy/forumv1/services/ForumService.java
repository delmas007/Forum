package ci.digitalacademy.forumv1.services;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;

import java.util.List;
import java.util.Optional;

public interface ForumService {

    ForumDTO save (ForumDTO forumDTO);


    Optional<ForumDTO> finOneById(Long id);
    Optional<ForumDTO> finOneBySlug(String slug);

    List<ForumDTO> finAll();



}
