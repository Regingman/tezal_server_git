package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Budget;
import tezAlServer.repo.BudgetsRepo;
import tezAlServer.service.BudgetService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    private BudgetsRepo budgetsRepo;


    @Override
    public List<Budget> findAll() {
        return budgetsRepo.findAll();
    }

    @Override
    public Optional<Budget> findById(Long id) {
        return budgetsRepo.findById(id);
    }

    @Override
    public Budget save(Budget budget) {
        budget.setCreateDate(LocalDateTime.now());
        budget.setUpdateDate(LocalDateTime.now());
        return budgetsRepo.save(budget);
    }

    @Override
    public void deleteById(Long id) {
        budgetsRepo.deleteById(id);
    }
}
