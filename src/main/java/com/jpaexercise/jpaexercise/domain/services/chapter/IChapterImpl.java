package com.jpaexercise.jpaexercise.domain.services.chapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexercise.jpaexercise.domain.repositories.ChapterRepository;
import com.jpaexercise.jpaexercise.persistence.entities.Chapter;

import jakarta.transaction.Transactional;

@Service
public class IChapterImpl implements IChapter{

    @Autowired
    private ChapterRepository chapterRepository;

    @Transactional
    @Override
    public Optional<Chapter> delete(Long id) {
        Optional<Chapter> optionalChapter = this.chapterRepository.findById(id);

        optionalChapter.ifPresent(
            chapterFound -> {
                this.chapterRepository.delete(chapterFound);
            }
        );

        return optionalChapter;
    }

    @Override
    public List<Chapter> findAll() {
        return (List<Chapter>) this.chapterRepository.findAll(); // convierte de iterable al ojeto en especifico
    }

    @Override
    public Optional<Chapter> findById(Long id) {
        return this.chapterRepository.findById(id);
    }

    @Override
    public Chapter save(Chapter chapter) {
        return this.chapterRepository.save(chapter);
    }

    @Override
    public Optional<Chapter> update(Long id, Chapter chapter) {
        Optional<Chapter> optionalChapter = this.chapterRepository.findById(id);

        // verifica objeto encontrado
        if (optionalChapter.isPresent()){
            Chapter chapterItem = optionalChapter.orElseThrow();

            // hace respectivos cambios
            chapterItem.setChapterNumber( chapter.getChapterNumber() );
            chapterItem.setChapterTitle( chapter.getChapterTitle() );

            // retorna 
            return Optional.of( this.chapterRepository.save(chapterItem));

        }

        return optionalChapter;
    }
}
