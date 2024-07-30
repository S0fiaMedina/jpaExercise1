package com.jpaexercise.jpaexercise.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaexercise.jpaexercise.domain.services.catalog.ICatalog;
import com.jpaexercise.jpaexercise.persistence.entities.Catalog;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {
    
    @Autowired
    private ICatalog service;

    @GetMapping
    public List<Catalog> listCatalogs(){
        return this.service.findAll();
    }
}
