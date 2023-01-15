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
    private Integer id;

    @Lob
    private  String content;

    @ManyToOne()
    @JoinColumn(name = "tutorial_id")
    private  Tutorial tutorial;
/*
    public Comment(String content, Tutorial tutorial) {
        this.content = content;
        this.tutorial = tutorial;
    }*/
}

