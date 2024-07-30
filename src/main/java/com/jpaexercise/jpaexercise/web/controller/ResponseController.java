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

import com.jpaexercise.jpaexercise.domain.services.response.IResponse;
import com.jpaexercise.jpaexercise.persistence.entities.Response;



@RestController
@RequestMapping("/api/responses")
public class ResponseController {
    @Autowired
    private IResponse service;

    // getAll
    @GetMapping
    public List<Response> listResponses(){
        return this.service.findAll();
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<Response> view(@PathVariable Long id){
        Optional<Response> optionalResponse  = service.findById(id);
        
        if (optionalResponse.isPresent()){
            return ResponseEntity.ok(optionalResponse.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // post an object
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Response response){
        Response responseNew = this.service.save(response);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody Response response){
        Optional<Response> responseOptional = this.service.update(id, response);
        if (responseOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(responseOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        Response response = new Response();
        response.setId(id);

        Optional<Response> optionalResponse = this.service.delete(id);

        if (optionalResponse.isPresent()){
            return ResponseEntity.ok(optionalResponse.orElseThrow());
        }

        return ResponseEntity.notFound().build();

    }
}
