package com.jpaexercise.jpaexercise.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table  ( name = "detail_responses")
public class DetailResponse {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int responseOption;

    private String responseText;

    // relacion a question_id
    @ManyToOne( cascade =  CascadeType.ALL)
    @JoinColumn ( name = "question_id", nullable = false)
    private Question question;

    // relacion a response
    @ManyToOne ( cascade =  CascadeType.ALL)
    @JoinColumn ( name = "response_id", nullable =  false)
    private Response response;

    public DetailResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(int responseOption) {
        this.responseOption = responseOption;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    
}
