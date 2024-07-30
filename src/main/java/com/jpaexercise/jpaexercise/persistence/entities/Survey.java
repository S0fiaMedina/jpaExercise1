package com.jpaexercise.jpaexercise.persistence.entities;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table( name = "surveys")
public class Survey {
    
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String description;

    private String name;


    // relaciones




    // relacion con respuestas
    @OneToMany(mappedBy = "survey")
    private List<Response> responses;

    // relacion de preguntas
    @OneToMany(mappedBy = "survey")
    private List<Question> questions;

    // relacion con capitulos
    @OneToMany (mappedBy = "survey")
    private List<Chapter> chapters;

    public Survey() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    


}
