package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Unit;

import java.util.List;
import java.util.Optional;

@Service
public interface UnitService {
    List<Unit> findAll();

    Optional<Unit> findById(Long id);

    Unit save(Unit unit);

    void deleteById(Long id);
}
