package com.example.javatask5.comtroller;



import com.example.javatask5.exception.InvalidRequestException;
import com.example.javatask5.model.Comment;
import com.example.javatask5.model.Tutorial;
import com.example.javatask5.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


    @GetMapping("/comments")
    public List<Comment> getAllTutorials() {
        return commentRepository.findAll();
    }

    @GetMapping(value = "/comment/{content}/{tutorial_id}")
    public List<Comment> getCommentsByTutorialId(@PathVariable(value="content") String content,@PathVariable(value="tutorial_id") Tutorial tutorial_id) {
        return commentRepository.findCommentByContentAndAndTutorial(content,tutorial_id);
    }

    @PostMapping("/add")
    public Comment createComment(@RequestBody @Valid Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment comment) throws NotFoundException {
        if (comment == null || comment.getId() == null) {
            throw new InvalidRequestException("PatientRecord or ID must not be null!");
        }
        Optional<Comment> optionalRecord = commentRepository.findById(comment.getId());
        if (optionalRecord.isEmpty()) {
            throw new NotFoundException("Patient with ID " + comment.getId() + " does not exist.");
        }
        Comment existingPatientRecord = optionalRecord.get();

        existingPatientRecord.setContent(comment.getContent());
        existingPatientRecord.setTutorial(comment.getTutorial());


        Comment save = commentRepository.save(existingPatientRecord);
        return save;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteComment(@PathVariable(value = "id") Integer id) throws NotFoundException {
        if (commentRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Patient with ID " + id + " does not exist.");
        }
        commentRepository.deleteById(id);
    }

}
