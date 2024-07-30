package com.jpaexercise.jpaexercise.domain.services.question;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.Question;

public interface IQuestion {
    List<Question> findAll();

    Optional<Question> findById(Long id);

    Question save(Question question);

    Optional<Question> update(Question detailResponse);

    Optional<Question> delete(Long id);
}
