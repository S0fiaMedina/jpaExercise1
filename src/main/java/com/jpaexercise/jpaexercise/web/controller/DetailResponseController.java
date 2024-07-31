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

import com.jpaexercise.jpaexercise.domain.services.detailResponse.IDetailResponse;
import com.jpaexercise.jpaexercise.persistence.entities.DetailResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detail-responses")
public class DetailResponseController {
    
    @Autowired
    private IDetailResponse service;

    // getAll
    @GetMapping
    public List<DetailResponse> listDetailResponses(){
        return this.service.findAll();
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<DetailResponse> view(@PathVariable Long id){
        Optional<DetailResponse> optionalDetailResponse  = service.findById(id);
        
        if (optionalDetailResponse.isPresent()){
            return ResponseEntity.ok(optionalDetailResponse.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // post an object
    @PostMapping
    public ResponseEntity<?> create( @Valid @RequestBody DetailResponse detailResponse, BindingResult result){

        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        DetailResponse detailResponseNew = this.service.save(detailResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(detailResponseNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody DetailResponse detailResponse, BindingResult result){

        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        Optional<DetailResponse> detailResponseOptional = this.service.update(id, detailResponse);
        if (detailResponseOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(detailResponseOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailResponse> delete(@PathVariable Long id){
        DetailResponse detailResponse = new DetailResponse();
        detailResponse.setId(id);

        Optional<DetailResponse> optionalDetailResponse = this.service.delete(id);

        if (optionalDetailResponse.isPresent()){
            return ResponseEntity.ok(optionalDetailResponse.orElseThrow());
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
