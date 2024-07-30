package com.jpaexercise.jpaexercise.domain.services.responseOption;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.ResponseOption;

public interface IResponseOption {
    List<ResponseOption> findAll();

    Optional<ResponseOption> findById(Long id);

    ResponseOption save(ResponseOption responseOption);

    Optional<ResponseOption> update( Long id, ResponseOption responseOption);

    Optional<ResponseOption> delete(Long id);

}
