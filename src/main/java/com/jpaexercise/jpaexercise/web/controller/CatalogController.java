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

import com.jpaexercise.jpaexercise.domain.services.catalog.ICatalog;
import com.jpaexercise.jpaexercise.persistence.entities.Catalog;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {
    
    @Autowired
    private ICatalog service;

    // getAll
    @GetMapping
    public List<Catalog> listCatalogs(){
        return this.service.findAll();
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<Catalog> view(@PathVariable Long id){
        Optional<Catalog> optionalCatalog  = service.findById(id);
        
        if (optionalCatalog.isPresent()){
            return ResponseEntity.ok(optionalCatalog.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // post an object
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Catalog catalog, BindingResult result){
        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        
        Catalog catalogNew = this.service.save(catalog);
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Catalog catalog, BindingResult result){

        // revisa por errores
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        // actualizacion
        Optional<Catalog> catalogOptional = this.service.update(id, catalog);
        if (catalogOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(catalogOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Catalog> delete(@PathVariable Long id){
        Catalog catalog = new Catalog();
        catalog.setId(id);

        Optional<Catalog> optionalCatalog = this.service.delete(id);

        if (optionalCatalog.isPresent()){
            return ResponseEntity.ok(optionalCatalog.orElseThrow());
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
