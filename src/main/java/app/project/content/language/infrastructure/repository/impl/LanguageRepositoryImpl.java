package app.project.content.language.infrastructure.repository.impl;

import app.project.content.language.application.mapper.LanguageMapper;
import app.project.content.language.domain.entity.Language;
import app.project.content.language.domain.repository.LanguageRepository;
import app.project.content.language.infrastructure.repository.jpa.LanguageRepositoryJpa;
import app.project.shared.exceptions.NotFoundException;
import app.project.shared.exceptions.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LanguageRepositoryImpl implements LanguageRepository {

    private final LanguageRepositoryJpa languageRepositoryJpa;


    @Override
    public Long save(Language language) {

        return languageRepositoryJpa.save(
                LanguageMapper.INSTANCE.toEntityJpa(language)
        ).getIdLanguage();
    }

    @Override
    public Language findById(Long idLanguage) throws NotFoundException {

        return languageRepositoryJpa.findById(idLanguage)
                .map(LanguageMapper.INSTANCE::toEntity)
                .orElseThrow(); // TODO throw exception bien
    }

    @Override
    public List<Language> findAll() {

        return languageRepositoryJpa.findAll().stream()
                .map(LanguageMapper.INSTANCE::toEntity)
                .toList();
    }

    @Override
    public Language update(Language language) throws NotFoundException, UnprocessableEntityException {

        return null;
    }

    @Override
    public Boolean delete(Long idLanguage) throws NotFoundException {
        return null;
    }
}
