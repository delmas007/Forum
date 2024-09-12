package ci.digitalacademy.forumv1.services.mapper.impl;

import ci.digitalacademy.forumv1.models.Subject;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import ci.digitalacademy.forumv1.services.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMapperImp implements SubjectMapper {

    private final ModelMapper modelMapper;

    @Override
    public SubjectDTO fromEntity(Subject entity) {
        return modelMapper.map(entity, SubjectDTO.class);
    }

    @Override
    public Subject toEntity(SubjectDTO dto) {
        return modelMapper.map(dto, Subject.class);
    }
}
