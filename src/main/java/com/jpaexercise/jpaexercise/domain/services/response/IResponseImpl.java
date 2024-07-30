package com.jpaexercise.jpaexercise.domain.services.response;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.ResponseRepository;
import com.jpaexercise.jpaexercise.persistence.entities.Response;

import jakarta.transaction.Transactional;

@Service
public class IResponseImpl implements IResponse{

    @Autowired
    private ResponseRepository responseRepository;

    @Transactional
    @Override
    public Optional<Response> delete(Long id) {
        Optional<Response> optionalResponse = this.responseRepository.findById(id);

        optionalResponse.ifPresent(
            responseFound -> {
                this.responseRepository.delete(responseFound);
            }
        );

        return optionalResponse;
    }

    @Override
    public List<Response> findAll() {
        return (List<Response>) this.responseRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<Response> findById(Long id) {
        return this.responseRepository.findById(id);
    }

    @Override
    public Response save(Response response) {
        return this.responseRepository.save(response);
    }

    @Override
    public Optional<Response> update(Long id, Response response) {
        Optional<Response> optionalResponse = this.responseRepository.findById(id);

        // verifica objeto encontrado
        if (optionalResponse.isPresent()){
            Response responseItem = optionalResponse.orElseThrow();

            // hace respectivos cambios
            responseItem.setNameRespondant( response.getNameRespondant() );
        
            // retorna 
            return Optional.of( this.responseRepository.save(responseItem));

        }

        return optionalResponse;
    }
}
