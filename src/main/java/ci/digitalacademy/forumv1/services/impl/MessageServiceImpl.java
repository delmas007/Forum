package ci.digitalacademy.forumv1.services.impl;

import ci.digitalacademy.forumv1.models.Message;
import ci.digitalacademy.forumv1.repositories.MessageRepository;
import ci.digitalacademy.forumv1.services.MessageService;
import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import ci.digitalacademy.forumv1.services.mapper.MessageMapper;
import ci.digitalacademy.forumv1.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final SubjectService subjectService;

    @Override
    public MessageDTO saveMessageById(MessageDTO messageDTO, Long id) {
        log.debug("Request to save by id: {}", messageDTO);

        Optional<SubjectDTO> subjectDTO = subjectService.findById(id);
        if (subjectDTO.isEmpty()){
            return null;
        }
        messageDTO.setSubject(subjectDTO.get());
        messageDTO.setDate(LocalDate.now());
        Message message = messageMapper.toEntity(messageDTO);
        message.setSlug(SlugifyUtils.generate(message.getDate().toString()));
        message = messageRepository.save(message);
        return messageMapper.fromEntity(message);
    }


    @Override
    public MessageDTO saveMessageBySlug(MessageDTO messageDTO, String slug) {
        log.debug("Request to save by slug: {}", messageDTO);
        Optional<SubjectDTO> subjectDTO = subjectService.findBySlug(slug);
        if (subjectDTO.isEmpty()){
            return null;
        }
        messageDTO.setSubject(subjectDTO.get());
        messageDTO.setDate(LocalDate.now());
        Message message = messageMapper.toEntity(messageDTO);
        message.setSlug(SlugifyUtils.generate(message.getDate().toString()));
        message = messageRepository.save(message);
        return messageMapper.fromEntity(message);
    }
    @Override
    public List<MessageDTO> findAll() {
        log.debug("Request to found all message");
        return messageRepository.findAll().stream().map(message -> {
            return messageMapper.fromEntity(message);
        }).toList();
    }

    @Override
    public List<MessageDTO> getAllMessageByIdSubject(Long id) {
        log.debug("Request to get all message by subject id : {}", id);
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
    public List<MessageDTO> getAllMessageBySlugSubject(String slug) {
        log.debug("Request to get all message by subject slug : {}", slug);
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
