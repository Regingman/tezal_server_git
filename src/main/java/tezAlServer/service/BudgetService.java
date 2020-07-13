package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Budget;

import java.util.List;
import java.util.Optional;

@Service
public interface BudgetService {
    List<Budget> findAll();

    Optional<Budget> findById(Long id);

    Budget save(Budget budget);

    void deleteById(Long id);
}
