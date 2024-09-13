package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.models.Message;
import ci.digitalacademy.forumv1.repositories.MessageRepository;
import ci.digitalacademy.forumv1.services.MessageService;
import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import ci.digitalacademy.forumv1.services.mapper.MessageMapper;
import ci.digitalacademy.forumv1.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        message.setSlug(SlugifyUtils.generate(message.getDate().toString()));
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

    @Override
    public List<MessageDTO> getAllMessageSubject(Long id) {
        List<MessageDTO> listMessage = new ArrayList<>();
        List<MessageDTO> messages = findAll();
        for (MessageDTO message : messages){
            if (message.getSubject().getId().equals(id)){
                listMessage.add(message);
            }
        }
        System.out.println(listMessage);
        return listMessage;
    }

    @Override
    public List<MessageDTO> getAllMessageSubject(String slug) {
        List<MessageDTO> listMessage = new ArrayList<>();
        List<MessageDTO> messages = findAll();
        for (MessageDTO message : messages){
            if (Objects.equals(message.getSubject().getSlug(), slug)){
                listMessage.add(message);
            }
        }
        System.out.println(listMessage);
        return listMessage;
    }
}
