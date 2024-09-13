package ci.digitalacademy.forumv1.services.mapper.impl;

import ci.digitalacademy.forumv1.models.Subject;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import ci.digitalacademy.forumv1.services.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SubjectMapperImp implements SubjectMapper {

    private final ModelMapper modelMapper;

    @Override
    public SubjectDTO fromEntity(Subject entity) {
        log.debug("Mapping Subject to SubjectDTO");
        return modelMapper.map(entity, SubjectDTO.class);
    }

    @Override
    public Subject toEntity(SubjectDTO dto) {
        log.debug("Mapping SubjectDTO to Subject");
        return modelMapper.map(dto, Subject.class);
    }
}
