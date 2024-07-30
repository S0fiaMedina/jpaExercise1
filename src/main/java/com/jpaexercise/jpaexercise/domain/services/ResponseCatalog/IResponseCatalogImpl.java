package com.jpaexercise.jpaexercise.domain.services.ResponseCatalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.ResponseCatalogRepository;
import com.jpaexercise.jpaexercise.persistence.entities.ResponseCatalog;

import jakarta.transaction.Transactional;

@Service
public class IResponseCatalogImpl implements IResponseCatalog{
    @Autowired
    private ResponseCatalogRepository responseCatalogRepository;

    @Transactional
    @Override
    public Optional<ResponseCatalog> delete(Long id) {
        Optional<ResponseCatalog> optionalResponseCatalog = this.responseCatalogRepository.findById(id);

        optionalResponseCatalog.ifPresent(
            responseCatalogFound -> {
                this.responseCatalogRepository.delete(responseCatalogFound);
            }
        );

        return optionalResponseCatalog;
    }

    @Override
    public List<ResponseCatalog> findAll() {
        return (List<ResponseCatalog>) this.responseCatalogRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<ResponseCatalog> findById(Long id) {
        return this.responseCatalogRepository.findById(id);
    }

    @Override
    public ResponseCatalog save(ResponseCatalog responseCatalog) {
        return this.responseCatalogRepository.save(responseCatalog);
    }

    @Override
    public Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog) {
        Optional<ResponseCatalog> optionalResponseCatalog = this.responseCatalogRepository.findById(id);

        // verifica objeto encontrado
        if (optionalResponseCatalog.isPresent()){
            ResponseCatalog responseCatalogItem = optionalResponseCatalog.orElseThrow();

            // hace respectivos cambios
            responseCatalogItem.setResponseOption( responseCatalog.getResponseOption() );
            responseCatalogItem.setResponseText( responseCatalog.getResponseText() );

            // retorna 
            return Optional.of( this.responseCatalogRepository.save(responseCatalogItem));

        }

        return optionalResponseCatalog;
    }
}
