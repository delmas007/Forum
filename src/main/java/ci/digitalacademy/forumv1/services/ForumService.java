package ci.digitalacademy.forumv1.services;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ForumService {

    ForumDTO save (ForumDTO forumDTO);

    ForumDTO update (ForumDTO forumDTO);

    Optional<ForumDTO> finOne(Long id);

    List<ForumDTO> finAll();

    void delete(ForumDTO forumDTO);


}
