package ci.digitalacademy.forumv1.services.mapper.impl;

import ci.digitalacademy.forumv1.models.Forum;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import ci.digitalacademy.forumv1.services.mapper.ForumMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ForumMapperImpl implements ForumMapper {

    private final ModelMapper modelMapper;

    @Override
    public ForumDTO fromEntity(Forum entity) {
        return modelMapper.map(entity, ForumDTO.class);
    }

    @Override
    public Forum toEntity(ForumDTO dto) {
        return modelMapper.map(dto, Forum.class);
    }
}
