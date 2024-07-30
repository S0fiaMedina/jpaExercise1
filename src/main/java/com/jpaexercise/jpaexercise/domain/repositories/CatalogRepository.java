package com.jpaexercise.jpaexercise.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpaexercise.jpaexercise.persistence.entities.Catalog;

public interface CatalogRepository extends CrudRepository<Catalog, Long>{
    
}
