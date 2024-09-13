package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.repositories.SubjectRepository;
import ci.digitalacademy.forumv1.services.ForumService;
import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import ci.digitalacademy.forumv1.services.mapper.SubjectMapper;
import ci.digitalacademy.forumv1.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServieImp implements SubjectService {
    private final SubjectRepository subjectRepository;
    private  final ForumService forumService;
    private final SubjectMapper subjectMapper;


    @Override
    public SubjectDTO createByIdForum(SubjectDTO subjectDTO,Long id) {
        log.debug("Request to create by id forum  : {}", subjectDTO);
        Optional<ForumDTO> forumDTO = forumService.finOneById(id);
        subjectDTO.setSlug(SlugifyUtils.generate(subjectDTO.getTitle()));
        subjectDTO.setForum(forumDTO.get());
        return subjectMapper.fromEntity(subjectRepository.save(subjectMapper.toEntity(subjectDTO)));
    }

    @Override
    public SubjectDTO createBySlugForum(SubjectDTO subjectDTO, String slug) {
        log.debug("Request to create by slug : {}", subjectDTO);
        Optional<ForumDTO> forumDTO = forumService.finOneBySlug(slug);
        subjectDTO.setSlug(SlugifyUtils.generate(subjectDTO.getTitle()));
        subjectDTO.setForum(forumDTO.get());
        return subjectMapper.fromEntity(subjectRepository.save(subjectMapper.toEntity(subjectDTO)));
    }


    @Override
    public List<SubjectDTO> findAll() {
        log.debug("Request to get all Subject");
        return subjectRepository.findAll().stream().map(subjectMapper::fromEntity).toList();
    }

    @Override
    public Optional<SubjectDTO> findById(Long id) {
        log.debug("Request to get Subject by id : {}", id);
        return subjectRepository.findById(id).map(subjectMapper::fromEntity);
    }

    @Override
    public Optional<SubjectDTO> findBySlug(String slug) {
        log.debug("Request to get Subject by slug : {}", slug);
        return subjectRepository.findBySlug(slug).map(subjectMapper::fromEntity);
    }

    @Override
    public List<SubjectDTO> findByForumId(Long id) {
        log.debug("Request to get Subject by forum id : {}", id);
        List<SubjectDTO> subjectDTOList = new  ArrayList<>();
        findAll().forEach(subjectDTO -> {
            if(subjectDTO.getForum().getId().equals(id)){
                subjectDTOList.add(subjectDTO);
            }
        });
        return subjectDTOList;
    }

    @Override
    public List<SubjectDTO> findByForumSlug(String slug) {
        log.debug("Request to get Subject by forum slug : {}", slug);
        List<SubjectDTO> subjectDTOList = new  ArrayList<>();
        findAll().forEach(subjectDTO -> {
            if(subjectDTO.getForum().getSlug().equals(slug)){
                subjectDTOList.add(subjectDTO);
            }
        });
        return subjectDTOList;
    }
}
