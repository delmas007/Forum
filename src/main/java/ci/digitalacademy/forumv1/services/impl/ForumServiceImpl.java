package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.models.Forum;
import ci.digitalacademy.forumv1.repositories.ForumRepository;
import ci.digitalacademy.forumv1.services.ForumService;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import ci.digitalacademy.forumv1.services.mapper.ForumMapper;
import ci.digitalacademy.forumv1.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        log.debug("Request to save Forum : {}", forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO);
        forum.setSlug(SlugifyUtils.generate(forum.getName()));
        Forum saveForum = forumRepository.save(forum);
        return forumMapper.fromEntity(saveForum);
    }


    @Override
    public Optional<ForumDTO> finOneById(Long id) {
        log.debug("Request to get Forum by id : {}", id);
       return forumRepository.findById(id).map(forum -> {
            return forumMapper.fromEntity(forum);
        });

    }

    @Override
    public Optional<ForumDTO> finOneBySlug(String slug) {
        log.debug("Request to get Forum by slug : {}", slug);
        return forumRepository.findBySlug(slug).map(forum -> {
            return forumMapper.fromEntity(forum);
        });
    }

    @Override
    public List<ForumDTO> finAll() {
        log.debug("Request to get all Forum");
        return forumRepository.findAll().stream().map(forum -> {
            return forumMapper.fromEntity(forum);
        }).toList();
    }

}
