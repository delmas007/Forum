package ci.digitalacademy.forumv1.web.resources;

import ci.digitalacademy.forumv1.services.ForumService;
import ci.digitalacademy.forumv1.services.dto.ForumDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponse(responseCode = "201", description= "Request to save forum")
    @Operation(summary = "forum new save", description = "this endpoint allow to save forum")
    public ResponseEntity<ForumDTO> saveForum(@RequestBody ForumDTO forumDTO){
        return new ResponseEntity<>(forumService.save(forumDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get forum"),
            @ApiResponse(responseCode = "404", description = "forum not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get one by id", description = "this endpoint allow to get one id")
    public ResponseEntity<?> getOneById(@PathVariable Long id){

        Optional<ForumDTO> forumDTO = forumService.finOne(id);
        if (forumDTO.isPresent()){
            return new ResponseEntity<>(forumDTO.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(forumDTO.get(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "get all forum", description = "this endpoint allow to get all forum")
    public List<ForumDTO> getAll(){
        return forumService.finAll();
    }

}
