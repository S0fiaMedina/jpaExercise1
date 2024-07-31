package com.jpaexercise.jpaexercise.persistence.entities;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table (name = "questions")
public class Question {
    
    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message =  "el texto de la pregunta {NotEmpty.error}")
    private String questionNumber;

    @NotEmpty(message =  "el texto de la pregunta {NotEmpty.error}")
    private String questionText;

    @NotEmpty(message =  "el tipo de respuesta {NotEmpty.error}")
    private String responseType;

    private String commentQuestion;

    @Embedded
    Audit audit = new Audit();  

    // rlacion a chapter id
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id", nullable =  false)
    private Chapter chapter;

    // relacion a parentQuestion
    @ManyToOne (cascade =  CascadeType.ALL)
    @JoinColumn(name = "parent_question_id", nullable = true)
    private Question questionParent;

    // relacion a survey
    @ManyToOne (cascade =  CascadeType.ALL)
    @JoinColumn (name = "survey_id", nullable = false)
    private Survey survey;

    // relacion de recursiva
    @OneToMany( mappedBy = "questionParent")
    private List<Question> childQuestions;

    // relacion de response_options
    @OneToMany( mappedBy =  "question")
    private List<ResponseOption> responseOptions;
    
    // relacion de detailResponse
    @OneToMany ( mappedBy =  "question")
    private List<DetailResponse> detailResponses;

    // relacion de respoonse catalog
    @OneToMany ( mappedBy =  "question")
    private List<ResponseCatalog> responseCatalogs;



    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getCommentQuestion() {
        return commentQuestion;
    }

    public void setCommentQuestion(String commentQuestion) {
        this.commentQuestion = commentQuestion;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<ResponseOption> getResponseOptions() {
        return responseOptions;
    }

    public void setResponseOptions(List<ResponseOption> responseOptions) {
        this.responseOptions = responseOptions;
    }

    public List<DetailResponse> getDetailResponses() {
        return detailResponses;
    }

    public void setDetailResponses(List<DetailResponse> detailResponses) {
        this.detailResponses = detailResponses;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Question getQuestionParent() {
        return questionParent;
    }

    public void setQuestionParent(Question questionParent) {
        this.questionParent = questionParent;
    }

    public List<Question> getChildQuestions() {
        return childQuestions;
    }

    public void setChildQuestions(List<Question> childQuestions) {
        this.childQuestions = childQuestions;
    }

    


}
