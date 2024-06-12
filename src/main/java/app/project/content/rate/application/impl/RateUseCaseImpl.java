package app.project.content.rate.application.impl;

import app.project.content.rate.application.RateUseCase;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.domain.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateUseCaseImpl implements RateUseCase {

    private final RateRepository rateRepository;


    @Override
    public Long save(Rate rate) {

        return rateRepository.save(rate);
    }

    @Override
    public Rate findById(Long idRate) {

        return rateRepository.findById(idRate);
    }

    @Override
    public List<Rate> findAll() {

        return rateRepository.findAll();
    }

    @Override
    public Rate update(Rate rate) {

        return rateRepository.update(rate);
    }

    @Override
    public Boolean delete(Long idRate) {

        return rateRepository.delete(idRate);
    }
}
