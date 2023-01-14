package com.example.javatask5.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    private String id;

    @Lob
    private  String content;

    @ManyToOne()
    @JoinColumn(name = "tutorial_id")
    private  Tutorial tutorial;

}

