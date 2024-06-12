package app.project.content.rate.infrastructure.repository.impl;

import app.project.content.rate.application.mapper.RateMapper;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.domain.repository.RateRepository;
import app.project.content.rate.infrastructure.repository.jpa.RateRepositoryJpa;
import app.project.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RateRepositoryImpl implements RateRepository {

    private final RateRepositoryJpa rateRepositoryJpa;


    @Override
    public Long save(Rate rate) {

        return rateRepositoryJpa.save(
                RateMapper.INSTANCE.toEntityJpa(rate)
        ).getIdRate();
    }

    @Override
    public Rate findById(Long idRate) throws NotFoundException {

        return rateRepositoryJpa.findById(idRate)
                .map(RateMapper.INSTANCE::toEntity)
                .orElseThrow(() -> new NotFoundException(Rate.class, idRate))
                ;
    }

    @Override
    public List<Rate> findAll() {

        return rateRepositoryJpa.findAll().stream()
                .map(RateMapper.INSTANCE::toEntity)
                .toList();
    }

    @Override
    public Rate update(Rate rate) {

        var rateJpa = rateRepositoryJpa.findById(rate.getIdRate())
                .orElseThrow(
                        () -> new NotFoundException(Rate.class, rate.getIdRate())
                )
                ;

        // TODO validate
        rateJpa.setPricePerHour(rate.getPricePerHour());

        var updatedRateJpa = rateRepositoryJpa.save(rateJpa);

        return RateMapper.INSTANCE.toEntity(updatedRateJpa);
    }

    @Override
    public Boolean delete(Long idRate) {

        rateRepositoryJpa.delete(
                rateRepositoryJpa.findById(idRate)
                        .orElseThrow(() -> new NotFoundException(Rate.class, idRate))
        );

        return true;
    }
}
