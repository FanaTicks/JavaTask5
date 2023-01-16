package com.example.javatask5.comtroller;

import com.example.javatask5.model.Comment;
import com.example.javatask5.model.Tutorial;
import com.example.javatask5.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping(value = "/comment/{content}/{tutorial_id}/{page}")
    public List<Comment> getCommentsByTutorialId(@PathVariable(value="content") String content,@PathVariable(value="tutorial_id") Tutorial tutorial_id,@PathVariable(value="page") Integer page) {
        List<Comment> list = commentRepository.findCommentByContentAndAndTutorial(content,tutorial_id);
        List<Comment> listFinish = new ArrayList<>();
        double  limit = page*5;
        double  l = (page-((list.size()+1)/5.0)) ;
        if(l > 0){limit =limit-(l*5)-1 ;}
        for(int i = ((5*(page-1))); i < limit ; i++){
            if (i>list.size()){return listFinish;}
            int index = i-6;
            if(index<0){index = 0;}
            listFinish.add(index,list.get(i));
        }
        return listFinish;
    }

    @PostMapping("/add")
    public Comment createComment(@RequestBody @Valid Comment comment) {
        return commentRepository.save(comment);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public
    class InvalidRequestException extends RuntimeException {
        public InvalidRequestException(String s) {
            super(s);
        }
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment comment) throws NotFoundException {
        if (comment == null || comment.getId() == null) {
            throw new InvalidRequestException("Comment or ID must not be null!");
        }
        Optional<Comment> optionalRecord = commentRepository.findById(comment.getId());
        if (optionalRecord.isEmpty()) {
            throw new NotFoundException("Comment with ID " + comment.getId() + " does not exist.");
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
            throw new NotFoundException("Comment with ID " + id + " does not exist.");
        }
        commentRepository.deleteById(id);
    }

}
