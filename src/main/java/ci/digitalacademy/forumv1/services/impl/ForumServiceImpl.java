package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.models.Forum;
import ci.digitalacademy.forumv1.repositories.ForumRepository;
import ci.digitalacademy.forumv1.services.ForumService;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import ci.digitalacademy.forumv1.services.mapper.ForumMapper;
import ci.digitalacademy.forumv1.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        Forum forum = forumMapper.toEntity(forumDTO);
        forum.setSlug(SlugifyUtils.generate(forum.getName()));
        Forum saveForum = forumRepository.save(forum);
        return forumMapper.fromEntity(saveForum);
    }

    @Override
    public ForumDTO update(ForumDTO forumDTO) {
        return null;
    }

    @Override
    public Optional<ForumDTO> finOne(Long id) {
       return forumRepository.findById(id).map(forum -> {
            return forumMapper.fromEntity(forum);
        });

    }

    @Override
    public Optional<ForumDTO> finOne(String slug) {
        return forumRepository.findBySlug(slug).map(forum -> {
            return forumMapper.fromEntity(forum);
        });
    }

    @Override
    public List<ForumDTO> finAll() {
        return forumRepository.findAll().stream().map(forum -> {
            return forumMapper.fromEntity(forum);
        }).toList();
    }

    @Override
    public void delete(ForumDTO forumDTO) {

    }
}
