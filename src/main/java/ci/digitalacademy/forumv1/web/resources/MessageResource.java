package ci.digitalacademy.forumv1.web.resources;

import ci.digitalacademy.forumv1.services.MessageService;
import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageResource {

    private final MessageService messageService;
    private final SubjectService subjectService;

    @PostMapping("/{id}")
    public ResponseEntity<MessageDTO> saveMessage(@RequestBody MessageDTO messageDTO, @PathVariable Long id){
        log.debug("REST Request to save  {}", messageDTO);
        //Déclaration d'un optionnal pour récuperer l'objet
        Optional<SubjectDTO> byId = subjectService.findById(id);
        //Récupération de l'objet subject pour pourvoir relier à notre objet message
        messageDTO.setSubject(byId.get());
        //Enregistrement d'un message
        return new ResponseEntity<>(messageService.saveMessage(messageDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<MessageDTO> getAllMessage(){
        log.debug("REST Request to get all");
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    public List<MessageDTO> getAllMessageSubject(@PathVariable Long id){
        log.debug("REST Request to get all message subject");
        return messageService.getAllMessageSubject(id);
    }
}
