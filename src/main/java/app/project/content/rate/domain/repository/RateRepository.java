package app.project.content.rate.domain.repository;

import app.project.content.rate.domain.entity.Rate;

import java.util.List;

public interface RateRepository {

    Long save(Rate rate);

    Rate findById(Long idRate);

    List<Rate> findAll();

    Rate update(Rate rate);

    Boolean delete(Long idRate);
}
