package ci.digitalacademy.forumv1.services;

import ci.digitalacademy.forumv1.services.dto.MessageDTO;

import java.util.List;

public interface MessageService {

    MessageDTO saveMessageById(MessageDTO messageDTO, Long id);

    MessageDTO saveMessageBySlug(MessageDTO messageDTO, String slug);

    List<MessageDTO> findAll();

    List<MessageDTO> getAllMessageByIdSubject(Long id);

    List<MessageDTO> getAllMessageBySlugSubject(String slug);
}
