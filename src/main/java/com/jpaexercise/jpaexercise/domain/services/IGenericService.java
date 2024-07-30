package com.jpaexercise.jpaexercise.domain.services;

import java.util.List;
import java.util.Optional;


public interface IGenericService<T> {
    
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T objGeneric);

    Optional<T> update(T objGeneric);

    Optional<T> delete(Long id);
}
