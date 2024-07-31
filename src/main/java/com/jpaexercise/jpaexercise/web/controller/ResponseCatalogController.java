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

import com.jpaexercise.jpaexercise.domain.services.ResponseCatalog.IResponseCatalog;
import com.jpaexercise.jpaexercise.persistence.entities.ResponseCatalog;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/api/response-catalogs")
public class ResponseCatalogController {
    
    @Autowired
    private IResponseCatalog service;

    // getAll
    @GetMapping
    public List<ResponseCatalog> listResponseCatalogs(){
        return this.service.findAll();
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseCatalog> view(@PathVariable Long id){
        Optional<ResponseCatalog> optionalResponseCatalog  = service.findById(id);
        
        if (optionalResponseCatalog.isPresent()){
            return ResponseEntity.ok(optionalResponseCatalog.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // post an object
    @PostMapping
    public ResponseEntity<?> create( @Valid @RequestBody ResponseCatalog responseCatalog, BindingResult result){

        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        ResponseCatalog responseCatalogNew = this.service.save(responseCatalog);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseCatalogNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ResponseCatalog responseCatalog , BindingResult result ){

        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        Optional<ResponseCatalog> responseCatalogOptional = this.service.update(id, responseCatalog);
        if (responseCatalogOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(responseCatalogOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCatalog> delete(@PathVariable Long id){
        ResponseCatalog responseCatalog = new ResponseCatalog();
        responseCatalog.setId(id);

        Optional<ResponseCatalog> optionalResponseCatalog = this.service.delete(id);

        if (optionalResponseCatalog.isPresent()){
            return ResponseEntity.ok(optionalResponseCatalog.orElseThrow());
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
