package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Budget;
import tezAlServer.domain.Container;
import tezAlServer.domain.ContainerCategory;
import tezAlServer.repo.BudgetsRepo;
import tezAlServer.repo.ContainerCategorysRepo;
import tezAlServer.repo.ContainersRepo;
import tezAlServer.service.ContainerService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContainerServiceImpl  implements ContainerService {
    @Autowired
    ContainersRepo containersRepo;
    @Autowired
    BudgetsRepo budgetsRepo;
    @Autowired
    ContainerCategorysRepo containerCategorysRepo;

    @Override
    public List<Container> findAll() {
        return containersRepo.findAll();
    }

    @Override
    public Optional<Container> findById(Long id) {
        return containersRepo.findById(id);
    }

    @Override
    public Container save(Container container) {
        Budget budget = budgetsRepo.findById(container.getBudgetId()).orElse(null);
        ContainerCategory containerCategory = containerCategorysRepo.findById(container.getContainerCategoryId()).orElse(null);
        container.setBudget(budget);
        container.setContainerCategory(containerCategory);
        container.setCreateDate(LocalDateTime.now());
        container.setUpdateDate(LocalDateTime.now());
        return containersRepo.save(container);
    }

    @Override
    public void deleteById(Long id) {
        containersRepo.deleteById(id);
    }

    @Override
    public List<Container> getAllById(Long id, Pageable pageable) {

        return containersRepo.getContainerByContainerCategoryId(id, pageable);
    }
}
