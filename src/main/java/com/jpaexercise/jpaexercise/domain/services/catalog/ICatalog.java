package com.jpaexercise.jpaexercise.domain.services.catalog;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.Catalog;

public interface ICatalog {

    List<Catalog> findAll();

    Optional<Catalog> findById(Long id);

    Catalog save(Catalog catalog);

    Optional<Catalog> update(Catalog catalog);

    Optional<Catalog> delete(Long id);

    
}
