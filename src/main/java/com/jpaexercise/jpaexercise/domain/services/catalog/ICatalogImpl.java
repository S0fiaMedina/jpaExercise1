package com.jpaexercise.jpaexercise.domain.services.catalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.CatalogRepository;
import com.jpaexercise.jpaexercise.persistence.entities.Catalog;

import jakarta.transaction.Transactional;

@Service
public class ICatalogImpl implements ICatalog{

    @Autowired
    private CatalogRepository catalogRepository;

    @Transactional
    @Override
    public Optional<Catalog> delete(Long id) {
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(id);

        optionalCatalog.ifPresent(
            catalogFound -> {
                this.catalogRepository.delete(catalogFound);
            }
        );

        return optionalCatalog;
    }

    @Override
    public List<Catalog> findAll() {
        return (List<Catalog>) this.catalogRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return this.catalogRepository.findById(id);
    }

    @Override
    public Catalog save(Catalog catalog) {
        return this.catalogRepository.save(catalog);
    }

    @Override
    public Optional<Catalog> update(Long id, Catalog catalog) {
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(id);

        // verifica objeto encontrado
        if (optionalCatalog.isPresent()){
            Catalog catalogItem = optionalCatalog.orElseThrow();

            // hace respectivos cambios
            catalogItem.setName( catalog.getName() );
            catalogItem.setResponseCatalogs( catalog.getResponseCatalogs() );

            // retorna 
            return Optional.of( this.catalogRepository.save(catalogItem));

        }

        return optionalCatalog;
    }
    
}
