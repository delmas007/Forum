package ci.digitalacademy.forumv1.services.mapper.impl;

import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import ci.digitalacademy.forumv1.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageMapperImpl implements MessageMapper {

    private final ModelMapper modelMapper;


    @Override
    public MessageDTO fromEntity(Message entity) {
        return modelMapper.map(entity, MessageDTO.class);
    }

    @Override
    public Message toEntity(MessageDTO dto) {
        return modelMapper.map(dto, Message.class);
    }
}
