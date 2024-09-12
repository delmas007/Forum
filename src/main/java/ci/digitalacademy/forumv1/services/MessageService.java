package ci.digitalacademy.forumv1.services;

import ci.digitalacademy.forumv1.services.dto.MessageDTO;

import java.util.List;

public interface MessageService {

    MessageDTO saveMessage(MessageDTO messageDTO);

    List<MessageDTO> findAll();

    List<MessageDTO> getAllMessageSubject(Long id);
}
