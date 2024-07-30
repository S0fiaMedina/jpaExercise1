package com.jpaexercise.jpaexercise.domain.services.detailResponse;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.DetailResponse;

public interface IDetailResponse {
    List<DetailResponse> findAll();

    Optional<DetailResponse> findById(Long id);

    DetailResponse save(DetailResponse detailResponse);

    Optional<DetailResponse> update(Long id, DetailResponse detailResponse);

    Optional<DetailResponse> delete(Long id);
}
