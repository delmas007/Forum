package ci.digitalacademy.forumv1.services.mapper.impl;

import ci.digitalacademy.forumv1.models.Message;
import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import ci.digitalacademy.forumv1.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class MessageMapperImpl implements MessageMapper {

    private final ModelMapper modelMapper;


    @Override
    public MessageDTO fromEntity(Message entity) {
        log.debug("Mapping Message to MessageDTO");
        return modelMapper.map(entity, MessageDTO.class);
    }
    @Override
    public Message toEntity(MessageDTO dto) {
        log.debug("Mapping MessageDTO to Message");
        return modelMapper.map(dto, Message.class);
    }
}
