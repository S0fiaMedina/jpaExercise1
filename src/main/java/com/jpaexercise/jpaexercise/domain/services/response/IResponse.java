package com.jpaexercise.jpaexercise.domain.services.response;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.Response;

public interface IResponse {
    List<Response> findAll();

    Optional<Response> findById(Long id);

    Response save(Response response);

    Optional<Response> update(Response response);

    Optional<Response> delete(Long id);
}
