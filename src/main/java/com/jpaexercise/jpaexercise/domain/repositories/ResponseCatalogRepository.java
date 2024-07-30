package com.jpaexercise.jpaexercise.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpaexercise.jpaexercise.persistence.entities.ResponseCatalog;

public interface ResponseCatalogRepository extends CrudRepository<ResponseCatalog, Long>{
    
}
