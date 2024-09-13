package ci.digitalacademy.forumv1.services;

import ci.digitalacademy.forumv1.services.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    SubjectDTO create(SubjectDTO subjectDTO,Long id);
    SubjectDTO create(SubjectDTO subjectDTO,String slug);
    SubjectDTO update(SubjectDTO subjectDTO);
    void delete(Long id);
    List<SubjectDTO> findAll();
    Optional<SubjectDTO> findById(Long id);
    Optional<SubjectDTO> findBySlug(String slug);

    List<SubjectDTO> findByForumId(Long id);
    List<SubjectDTO> findByForumId(String slug);
}
