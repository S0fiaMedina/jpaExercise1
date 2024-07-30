package com.jpaexercise.jpaexercise.domain.services.chapter;

import java.util.List;
import java.util.Optional;

import com.jpaexercise.jpaexercise.persistence.entities.Chapter;


public interface IChapter {
    
    List<Chapter> findAll();

    Optional<Chapter> findById(Long id);

    Chapter save(Chapter catalog);

    Optional<Chapter> update(Chapter catalog);

    Optional<Chapter> delete(Long id);
}
