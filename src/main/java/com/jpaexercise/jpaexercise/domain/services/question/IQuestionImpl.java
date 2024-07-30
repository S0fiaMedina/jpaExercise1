package com.jpaexercise.jpaexercise.domain.services.question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.QuestionRepository;
import com.jpaexercise.jpaexercise.persistence.entities.Question;

import jakarta.transaction.Transactional;

@Service
public class IQuestionImpl implements IQuestion{
    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    @Override
    public Optional<Question> delete(Long id) {
        Optional<Question> optionalQuestion = this.questionRepository.findById(id);

        optionalQuestion.ifPresent(
            questionFound -> {
                this.questionRepository.delete(questionFound);
            }
        );

        return optionalQuestion;
    }

    @Override
    public List<Question> findAll() {
        return (List<Question>) this.questionRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<Question> findById(Long id) {
        return this.questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Optional<Question> update(Long id, Question question) {
        Optional<Question> optionalQuestion = this.questionRepository.findById(id);

        // verifica objeto encontrado
        if (optionalQuestion.isPresent()){
            Question questionItem = optionalQuestion.orElseThrow();

            // hace respectivos cambios
            questionItem.setCommentQuestion( question.getCommentQuestion() );
            questionItem.setQuestionText( question.getQuestionText() );
            questionItem.setResponseType( question.getResponseType()) ;
            questionItem.setQuestionNumber( question.getQuestionNumber());

            // retorna 
            return Optional.of( this.questionRepository.save(questionItem));

        }

        return optionalQuestion;
    }
}
