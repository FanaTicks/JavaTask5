package com.example.javatask5.repository;


import com.example.javatask5.model.Comment;
import com.example.javatask5.model.Tutorial;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

   List<Comment> findCommentByContentAndAndTutorial(String content, Tutorial tutorial);
}


