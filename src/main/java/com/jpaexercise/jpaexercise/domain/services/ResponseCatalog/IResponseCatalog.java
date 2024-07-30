package com.jpaexercise.jpaexercise.domain.services.ResponseCatalog;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.ResponseCatalog;

public interface IResponseCatalog {
    
    List<ResponseCatalog> findAll();

    Optional<ResponseCatalog> findById(Long id);

    ResponseCatalog save(ResponseCatalog responseCatalog);

    Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog);

    Optional<ResponseCatalog> delete(Long id);
}
