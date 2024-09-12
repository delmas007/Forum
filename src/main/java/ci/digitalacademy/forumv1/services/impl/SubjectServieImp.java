package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.repositories.SubjectRepository;
import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import ci.digitalacademy.forumv1.services.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServieImp implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;


    @Override
    public SubjectDTO create(SubjectDTO subjectDTO) {
        return subjectMapper.fromEntity(subjectRepository.save(subjectMapper.toEntity(subjectDTO)));
    }

    @Override
    public SubjectDTO update(SubjectDTO subjectDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll().stream().map(subjectMapper::fromEntity).toList();
    }

    @Override
    public Optional<SubjectDTO> findById(Long id) {
        return subjectRepository.findById(id).map(subjectMapper::fromEntity);
    }
}
