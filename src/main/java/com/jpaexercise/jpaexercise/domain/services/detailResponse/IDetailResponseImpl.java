package com.jpaexercise.jpaexercise.domain.services.detailResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.DetailResponseRepository;
import com.jpaexercise.jpaexercise.persistence.entities.DetailResponse;

import jakarta.transaction.Transactional;

@Service
public class IDetailResponseImpl implements IDetailResponse{

    @Autowired
    private DetailResponseRepository detailResponseRepository;

    @Transactional
    @Override
    public Optional<DetailResponse> delete(Long id) {
        Optional<DetailResponse> optionalDetailResponse = this.detailResponseRepository.findById(id);

        optionalDetailResponse.ifPresent(
            detailResponseFound -> {
                this.detailResponseRepository.delete(detailResponseFound);
            }
        );

        return optionalDetailResponse;
    }

    @Override
    public List<DetailResponse> findAll() {
        return (List<DetailResponse>) this.detailResponseRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<DetailResponse> findById(Long id) {
        return this.detailResponseRepository.findById(id);
    }

    @Override
    public DetailResponse save(DetailResponse detailResponse) {
        return this.detailResponseRepository.save(detailResponse);
    }

    @Override
    public Optional<DetailResponse> update(Long id, DetailResponse detailResponse) {
        Optional<DetailResponse> optionalDetailResponse = this.detailResponseRepository.findById(id);

        // verifica objeto encontrado
        if (optionalDetailResponse.isPresent()){
            DetailResponse detailResponseItem = optionalDetailResponse.orElseThrow();

            // hace respectivos cambios
            detailResponseItem.setResponseOption( detailResponse.getResponseOption() );
            detailResponseItem.setResponseText( detailResponse.getResponseText() );

            // retorna 
            return Optional.of( this.detailResponseRepository.save(detailResponseItem));

        }

        return optionalDetailResponse;
    }
}
