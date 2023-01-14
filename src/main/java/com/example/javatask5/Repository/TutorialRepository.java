package com.example.javatask5.repository;

import com.example.javatask5.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
}

