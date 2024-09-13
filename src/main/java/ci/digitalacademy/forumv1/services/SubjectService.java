package ci.digitalacademy.forumv1.services;

import ci.digitalacademy.forumv1.services.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    SubjectDTO createByIdForum(SubjectDTO subjectDTO,Long id);

    SubjectDTO createBySlugForum(SubjectDTO subjectDTO,String slug);

    List<SubjectDTO> findAll();

    Optional<SubjectDTO> findById(Long id);

    Optional<SubjectDTO> findBySlug(String slug);

    List<SubjectDTO> findByForumId(Long id);

    List<SubjectDTO> findByForumSlug(String slug);
}
