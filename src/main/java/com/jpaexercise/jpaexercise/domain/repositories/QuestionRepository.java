package com.jpaexercise.jpaexercise.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpaexercise.jpaexercise.persistence.entities.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
    
}
