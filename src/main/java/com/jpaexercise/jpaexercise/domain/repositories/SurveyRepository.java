package com.jpaexercise.jpaexercise.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpaexercise.jpaexercise.persistence.entities.Survey;

public interface SurveyRepository extends CrudRepository<Survey, Long>{

    

}
