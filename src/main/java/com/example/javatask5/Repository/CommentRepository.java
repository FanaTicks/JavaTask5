package com.example.javatask5.repository;


import com.example.javatask5.model.Comment;
import com.example.javatask5.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

   List<Comment> findCommentByContentAndAndTutorial(String content, Tutorial tutorial);
}


