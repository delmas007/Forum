package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.models.Message;
import ci.digitalacademy.forumv1.repositories.MessageRepository;
import ci.digitalacademy.forumv1.services.MessageService;
import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import ci.digitalacademy.forumv1.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    @Override
    public MessageDTO saveMessage(MessageDTO messageDTO) {
        log.debug("Request to save: {}", messageDTO);

        Message message = messageMapper.toEntity(messageDTO);
        message = messageRepository.save(message);
        return messageMapper.fromEntity(message);
    }

    @Override
    public List<MessageDTO> findAll() {
        log.debug("Request to found all");
        return messageRepository.findAll().stream().map(message -> {
            return messageMapper.fromEntity(message);
        }).toList();
    }
}
