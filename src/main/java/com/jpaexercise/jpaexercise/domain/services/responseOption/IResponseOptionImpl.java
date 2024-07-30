package com.jpaexercise.jpaexercise.domain.services.responseOption;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.ResponseOptionRepository;
import com.jpaexercise.jpaexercise.persistence.entities.ResponseOption;

import jakarta.transaction.Transactional;

@Service
public class IResponseOptionImpl implements IResponseOption{
    
    @Autowired
    private ResponseOptionRepository responseOptionRepository;

    @Transactional
    @Override
    public Optional<ResponseOption> delete(Long id) {
        Optional<ResponseOption> optionalResponseOption = this.responseOptionRepository.findById(id);

        optionalResponseOption.ifPresent(
            responseOptionFound -> {
                this.responseOptionRepository.delete(responseOptionFound);
            }
        );

        return optionalResponseOption;
    }

    @Override
    public List<ResponseOption> findAll() {
        return (List<ResponseOption>) this.responseOptionRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<ResponseOption> findById(Long id) {
        return this.responseOptionRepository.findById(id);
    }

    @Override
    public ResponseOption save(ResponseOption responseOption) {
        return this.responseOptionRepository.save(responseOption);
    }

    @Override
    public Optional<ResponseOption> update(Long id, ResponseOption responseOption) {
        Optional<ResponseOption> optionalResponseOption = this.responseOptionRepository.findById(id);

        // verifica objeto encontrado
        if (optionalResponseOption.isPresent()){
            ResponseOption responseOptionItem = optionalResponseOption.orElseThrow();

            // hace respectivos cambios
            responseOptionItem.setCommentResponse( responseOption.getCommentResponse() );
            responseOptionItem.setOptionText( responseOption.getOptionText() );
            responseOption.setOptionValue( responseOption.getOptionValue());

            // retorna 
            return Optional.of( this.responseOptionRepository.save(responseOptionItem));

        }

        return optionalResponseOption;
    }
}
