package com.jpaexercise.jpaexercise.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

import jakarta.validation.Valid;



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
    public ResponseEntity<?> create(@Valid @RequestBody Survey survey, BindingResult result){
        

        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }   
        
        Survey surveyNew = this.service.save(survey);
        return ResponseEntity.status(HttpStatus.CREATED).body(surveyNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Survey survey,
        BindingResult result){

        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }   

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
        // metodo de validacion
    private ResponseEntity<Map<String, String>> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
