package com.jpaexercise.jpaexercise.persistence.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogs")
public class Catalog {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy =  "catalog")
    private List<ResponseCatalog> responseCatalog;

    public Catalog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResponseCatalog> getResponseCatalogs() {
        return responseCatalog;
    }

    public void setResponseCatalogs(List<ResponseCatalog> responseCatalog) {
        this.responseCatalog = responseCatalog;
    }

    


}
