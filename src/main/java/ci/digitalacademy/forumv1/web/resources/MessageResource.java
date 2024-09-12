package ci.digitalacademy.forumv1.web.resources;

import ci.digitalacademy.forumv1.services.MessageService;
import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageResource {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDTO> saveMessage(@RequestBody MessageDTO messageDTO){
        log.debug("REST Request to save  {}", messageDTO);
        return new ResponseEntity<>(messageService.saveMessage(messageDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<MessageDTO> getAllMessage(){
        log.debug("REST Request to get all");
        return messageService.findAll();
    }
}
