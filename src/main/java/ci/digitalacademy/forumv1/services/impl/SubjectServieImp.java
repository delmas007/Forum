package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.repositories.SubjectRepository;
import ci.digitalacademy.forumv1.services.ForumService;
import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import ci.digitalacademy.forumv1.services.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServieImp implements SubjectService {
    private final SubjectRepository subjectRepository;
    private  final ForumService forumService;
    private final SubjectMapper subjectMapper;


    @Override
    public SubjectDTO create(SubjectDTO subjectDTO,Long id) {
        Optional<ForumDTO> forumDTO = forumService.finOne(id);
        subjectDTO.setForum(forumDTO.get());
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

    @Override
    public List<SubjectDTO> findByForumId(Long id) {
        List<SubjectDTO> subjectDTOList = new  ArrayList<>();
        findAll().forEach(subjectDTO -> {
            if(subjectDTO.getForum().getId().equals(id)){
                subjectDTOList.add(subjectDTO);
            }
        });
        return subjectDTOList;
    }
}
