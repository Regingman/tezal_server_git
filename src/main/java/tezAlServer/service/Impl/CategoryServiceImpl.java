package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Category;
import tezAlServer.repo.CategorysRepo;
import tezAlServer.service.CategoryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategorysRepo categorysRepo;

    @Override
    public List<Category> findAll() {
        return categorysRepo.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categorysRepo.findById(id);
    }

    @Override
    public Category save(Category category) {
        category.setCreateDate(LocalDateTime.now());
        category.setUpdateDate(LocalDateTime.now());
        return categorysRepo.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categorysRepo.deleteById(id);
    }
}
