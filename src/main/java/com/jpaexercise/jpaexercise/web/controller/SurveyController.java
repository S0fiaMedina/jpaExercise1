package com.jpaexercise.jpaexercise.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaexercise.jpaexercise.domain.services.survey.ISurvey;
import com.jpaexercise.jpaexercise.persistence.entities.Survey;



@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
     @Autowired
    private ISurvey service;

    // getAll
    @GetMapping
    public List<Survey> listSurveys(){
        return this.service.findAll();
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<Survey> view(@PathVariable Long id){
        Optional<Survey> optionalSurvey  = service.findById(id);
        
        if (optionalSurvey.isPresent()){
            return ResponseEntity.ok(optionalSurvey.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // post an object
    @PostMapping
    public ResponseEntity<Survey> create(@RequestBody Survey survey){
        Survey surveyNew = this.service.save(survey);
        return ResponseEntity.status(HttpStatus.CREATED).body(surveyNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> update(@PathVariable Long id, @RequestBody Survey survey){
        Optional<Survey> surveyOptional = this.service.update(id, survey);
        if (surveyOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(surveyOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Survey> delete(@PathVariable Long id){
        Survey survey = new Survey();
        survey.setId(id);

        Optional<Survey> optionalSurvey = this.service.delete(id);

        if (optionalSurvey.isPresent()){
            return ResponseEntity.ok(optionalSurvey.orElseThrow());
        }

        return ResponseEntity.notFound().build();

    }
}
