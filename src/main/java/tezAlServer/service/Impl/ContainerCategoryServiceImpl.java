package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.ContainerCategory;
import tezAlServer.repo.ContainerCategorysRepo;
import tezAlServer.service.ContainerCategoryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContainerCategoryServiceImpl implements ContainerCategoryService {
    @Autowired
    ContainerCategorysRepo containerCategorysRepo;


    @Override
    public List<ContainerCategory> findAll() {
        return containerCategorysRepo.findAll();
    }

    @Override
    public Optional<ContainerCategory> findById(Long id) {
        return containerCategorysRepo.findById(id);
    }

    @Override
    public ContainerCategory save(ContainerCategory container) {
        container.setCreateDate(LocalDateTime.now());
        container.setUpdateDate(LocalDateTime.now());
        return containerCategorysRepo.save(container);
    }

    @Override
    public void deleteById(Long id) {
        containerCategorysRepo.deleteById(id);
    }
}
