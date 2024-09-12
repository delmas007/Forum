package ci.digitalacademy.forumv1.web.resources;

import ci.digitalacademy.forumv1.services.SubjectService;
import ci.digitalacademy.forumv1.services.dto.SubjectDTO;
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

    @PostMapping
    public ResponseEntity<SubjectDTO> saveSubject(@RequestBody SubjectDTO subjectDTO){
        log.debug("REST Request to save Subject : {}", subjectDTO);
        return new  ResponseEntity<>(subjectService.create(subjectDTO), HttpStatus.CREATED);
    }

//    @PostMapping("/{id}")
//    public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO){
//        log.debug("REST Request to update Subject by : {}", subjectDTO);
//        return new ResponseEntity<>(subjectService.update(subjectDTO), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id){
        log.debug("REST Request to delete Subject {}", id);
        subjectService.delete(id);
    }

    @GetMapping
    public List<SubjectDTO> findAllSubject(){
        log.debug("REST Request to get all Subjects");
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdSubject(@PathVariable Long id){
        log.debug("REST Request to get Subject : {}", id);
        Optional<SubjectDTO> subjectDTO = subjectService.findById(id);
        if(subjectDTO.isPresent()){
            return new ResponseEntity<>(subjectDTO.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Subject not found",HttpStatus.NOT_FOUND);
        }
    }




}
