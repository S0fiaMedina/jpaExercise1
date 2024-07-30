package com.jpaexercise.jpaexercise.domain.services.survey;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.SurveyRepository;
import com.jpaexercise.jpaexercise.persistence.entities.Survey;

import jakarta.transaction.Transactional;

@Service
public class ISurveyImpl implements ISurvey{
    @Autowired
    private SurveyRepository surveyRepository;

    @Transactional
    @Override
    public Optional<Survey> delete(Long id) {
        Optional<Survey> optionalSurvey = this.surveyRepository.findById(id);

        optionalSurvey.ifPresent(
            surveyFound -> {
                this.surveyRepository.delete(surveyFound);
            }
        );

        return optionalSurvey;
    }

    @Override
    public List<Survey> findAll() {
        return (List<Survey>) this.surveyRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<Survey> findById(Long id) {
        return this.surveyRepository.findById(id);
    }

    @Override
    public Survey save(Survey survey) {
        return this.surveyRepository.save(survey);
    }

    @Override
    public Optional<Survey> update(Long id, Survey survey) {
        Optional<Survey> optionalSurvey = this.surveyRepository.findById(id);

        // verifica objeto encontrado
        if (optionalSurvey.isPresent()){
            Survey surveyItem = optionalSurvey.orElseThrow();

            // hace respectivos cambios
            surveyItem.setName( survey.getName() );
            surveyItem.setDescription( survey.getDescription() );

            // retorna 
            return Optional.of( this.surveyRepository.save(surveyItem));

        }

        return optionalSurvey;
    }
}
