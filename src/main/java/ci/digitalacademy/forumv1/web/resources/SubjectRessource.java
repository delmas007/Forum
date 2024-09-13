package ci.digitalacademy.forumv1.web.resources;

import ci.digitalacademy.forumv1.services.SubjectService;
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
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/subject")
public class SubjectRessource {
    private final SubjectService subjectService;

    @PostMapping("/{id}")
    @ApiResponse(responseCode = "201", description= "Request to save subject")
    @Operation(summary = "subject new save", description = "this endpoint allow to save subject")
    public ResponseEntity<SubjectDTO> saveSubject(@RequestBody SubjectDTO subjectDTO,@PathVariable Long id){
        log.debug("REST Request to save Subject : {}", subjectDTO);
        return new  ResponseEntity<>(subjectService.create(subjectDTO,id), HttpStatus.CREATED);
    }

    @PostMapping("/slug/{slug}")
    @ApiResponse(responseCode = "201", description= "Request to save subject")
    @Operation(summary = "subject new save", description = "this endpoint allow to save subject")
    public ResponseEntity<SubjectDTO> saveSubjectBySlug(@RequestBody SubjectDTO subjectDTO,@PathVariable String slug){
        log.debug("REST Request to save Subject : {}", subjectDTO);
        return new  ResponseEntity<>(subjectService.create(subjectDTO,slug), HttpStatus.CREATED);
    }

//    @PostMapping("/{id}")
//    public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO){
//        log.debug("REST Request to update Subject by : {}", subjectDTO);
//        return new ResponseEntity<>(subjectService.update(subjectDTO), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    @Operation(summary = "subject delete", description = "this endpoint allow to delete subject")
    public void deleteSubject(@PathVariable Long id){
        log.debug("REST Request to delete Subject {}", id);
        subjectService.delete(id);
    }

    @GetMapping
    @Operation(summary = "get all subject", description = "this endpoint allow to get all subject")
    public List<SubjectDTO> findAllSubject(){
        log.debug("REST Request to get all Subjects");
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get subject"),
            @ApiResponse(responseCode = "404", description = "subject not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get subject by id", description = "this endpoint allow to get subject by id")
    public ResponseEntity<?> findByIdSubject(@PathVariable Long id){
        log.debug("REST Request to get Subject : {}", id);
        Optional<SubjectDTO> subjectDTO = subjectService.findById(id);
        if(subjectDTO.isPresent()){
            return new ResponseEntity<>(subjectDTO.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Subject not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get subject"),
            @ApiResponse(responseCode = "404", description = "subject not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get subject by slug", description = "this endpoint allow to get subject by slug")
    public ResponseEntity<?> findBySlugSubject(@PathVariable String slug){
        log.debug("REST Request to get Subject : {}", slug);
        Optional<SubjectDTO> subjectDTO = subjectService.findBySlug(slug);
        if(subjectDTO.isPresent()){
            return new ResponseEntity<>(subjectDTO.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Subject not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/forum/{id}")
    @Operation(summary = "find by id forum", description = "this endpoint allow to find by id forum")
    public List<SubjectDTO> findByForumId(@PathVariable Long id){
        log.debug("REST Request to get all Subjects by forum id : {}", id);
        return subjectService.findByForumId(id);
    }

    @GetMapping("/forum/slug/{slug}")
    @Operation(summary = "find by slug forum", description = "this endpoint allow to find by slug forum")
    public List<SubjectDTO> findByForumSlug(@PathVariable String slug){
        log.debug("REST Request to get all Subjects by forum slug : {}", slug);
        return subjectService.findByForumId(slug);
    }




}
