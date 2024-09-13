package ci.digitalacademy.forumv1.web.resources;

import ci.digitalacademy.forumv1.services.MessageService;
import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.MessageDTO;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponse(responseCode = "201", description= "Request to save message")
    @Operation(summary = "message new save", description = "this endpoint allow to save message")
    public ResponseEntity<MessageDTO> saveMessage(@RequestBody MessageDTO messageDTO, @PathVariable Long id){
        log.debug("REST Request to save  {}", messageDTO);
        Optional<SubjectDTO> byId = subjectService.findById(id);
        messageDTO.setSubject(byId.get());
        return new ResponseEntity<>(messageService.saveMessage(messageDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "get all message", description = "this endpoint allow to get all message")
    public List<MessageDTO> getAllMessage(){
        log.debug("REST Request to get all");
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get message"),
            @ApiResponse(responseCode = "404", description = "message not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get all message subject", description = "this endpoint allow to get all message subject")
    public List<MessageDTO> getAllMessageSubject(@PathVariable Long id){
        log.debug("REST Request to get all message subject");
        return messageService.getAllMessageSubject(id);
    }
}
