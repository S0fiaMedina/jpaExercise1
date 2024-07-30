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
@Table(name = "response_options")
public class ResponseOption {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionValue;

    private String commentResponse;

    private String optionText;

    private int questionParent;

    // relacion a question
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public ResponseOption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(String commentResponse) {
        this.commentResponse = commentResponse;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public int getQuestionParent() {
        return questionParent;
    }

    public void setQuestionParent(int questionParent) {
        this.questionParent = questionParent;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    
}
