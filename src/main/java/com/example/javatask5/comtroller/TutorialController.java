package com.example.javatask5.comtroller;


import java.util.List;


import com.example.javatask5.model.Tutorial;
import com.example.javatask5.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public List<Tutorial> getAllTutorials() {
        return tutorialRepository.findAll();
    }

}
