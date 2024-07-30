package com.jpaexercise.jpaexercise.persistence.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "responses")
public class Response {
    
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private Time responseTime;

    private Date responseDate;

    private String nameRespondant;

    // relacion a cuestionarrio
    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    // relacion de detailResponse
    @OneToMany ( mappedBy =  "response")
    private List<DetailResponse> detailResponses;

    // relacion de responsecatalog
    @OneToMany ( mappedBy =  "response")
    private List<ResponseCatalog> responseCatalogs;

    public Response() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Time responseTime) {
        this.responseTime = responseTime;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getNameRespondant() {
        return nameRespondant;
    }

    public void setNameRespondant(String nameRespondant) {
        this.nameRespondant = nameRespondant;
    }

    public List<DetailResponse> getDetailResponses() {
        return detailResponses;
    }

    public void setDetailResponses(List<DetailResponse> detailResponses) {
        this.detailResponses = detailResponses;
    }


    

    
}
