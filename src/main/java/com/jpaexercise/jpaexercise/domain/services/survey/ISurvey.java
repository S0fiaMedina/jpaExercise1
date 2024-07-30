package com.jpaexercise.jpaexercise.domain.services.survey;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.Survey;

public interface ISurvey {

    List<Survey> findAll();

    Optional<Survey> findById(Long id);

    Survey save(Survey survey);

    Optional<Survey> update(Long id, Survey survey);

    Optional<Survey> delete(Long id);
}
