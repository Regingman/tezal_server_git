package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Rate;

import java.util.List;
import java.util.Optional;

@Service
public interface RateService {
    List<Rate> findAll();

    List<Rate> findAllById(Long id);

    Optional<Rate> findById(Long id);

    Rate save(Rate rate);

    void deleteById(Long id);
}
