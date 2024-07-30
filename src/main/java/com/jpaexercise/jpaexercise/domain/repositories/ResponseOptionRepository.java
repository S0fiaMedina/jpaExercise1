package com.jpaexercise.jpaexercise.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpaexercise.jpaexercise.persistence.entities.ResponseOption;

public interface ResponseOptionRepository extends CrudRepository<ResponseOption, Long>{
    
}
