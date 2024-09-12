package ci.digitalacademy.forumv1.web.resources;

import ci.digitalacademy.forumv1.services.ForumService;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/forums")
public class ForumRessource {
    private final ForumService forumService;

    @PostMapping
    public ResponseEntity<ForumDTO> saveForum(@RequestBody ForumDTO forumDTO){
        return new ResponseEntity<>(forumService.save(forumDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){

        Optional<ForumDTO> forumDTO = forumService.finOne(id);
        if (forumDTO.isPresent()){
            return new ResponseEntity<>(forumDTO.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(forumDTO.get(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<ForumDTO> getAll(){
        return forumService.finAll();
    }

}
