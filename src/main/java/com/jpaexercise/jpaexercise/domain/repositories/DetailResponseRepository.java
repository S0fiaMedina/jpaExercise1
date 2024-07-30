package com.jpaexercise.jpaexercise.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpaexercise.jpaexercise.persistence.entities.DetailResponse;

public interface DetailResponseRepository extends CrudRepository<DetailResponse, Long>{
    
}
