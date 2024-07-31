package com.jpaexercise.jpaexercise.persistence.entities;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Embedded;


@Entity
@Table( name = "surveys")
public class Survey {
    
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message =  "la descripcion del formulario {NotEmpty.error}")
    private String description;

    @NotEmpty(message =  "el nombre del formulario {NotEmpty.error}")
    private String name;

    @Embedded
    Audit audit = new Audit();     


    // relacion con respuestas
    @OneToMany(mappedBy = "survey")
    private List<Response> responses;

    // relacion de preguntas
    @OneToMany(mappedBy = "survey")
    private List<Question> questions;

    // relacion con capitulos
    @OneToMany (mappedBy = "survey")
    private List<Chapter> chapters;

    public Survey() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    


}
