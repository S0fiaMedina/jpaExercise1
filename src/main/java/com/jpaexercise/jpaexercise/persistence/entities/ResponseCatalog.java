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
@Table(name = "response_catalogs")
public class ResponseCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responseText;

    private int responseOption;

    // relacion hacia atalog
    @ManyToOne( cascade =  CascadeType.ALL)
    @JoinColumn ( name = "catalog_id", nullable = false)
    private Catalog catalog;

    // relacion hacia resouesta
    @ManyToOne( cascade =  CascadeType.ALL)
    @JoinColumn ( name = "response_id", nullable = false)
    private Response response;  

    // relacion hacia pregunta
    @ManyToOne( cascade =  CascadeType.ALL)
    @JoinColumn ( name = "question_id", nullable = false)
    private Question question;
    
    public ResponseCatalog() {
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

    public Catalog getCatalogId() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    
}
