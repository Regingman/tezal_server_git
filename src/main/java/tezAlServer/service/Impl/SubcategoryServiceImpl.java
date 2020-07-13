package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Category;
import tezAlServer.domain.Subcategory;
import tezAlServer.repo.CategorysRepo;
import tezAlServer.repo.SubcategorysRepo;
import tezAlServer.service.SubcategoryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {
    @Autowired
    SubcategorysRepo subcategorysRepo;
    @Autowired
    CategorysRepo categorysRepo;

    @Override
    public List<Subcategory> findAll() {
        return subcategorysRepo.findAll();
    }

    @Override
    public Optional<Subcategory> findById(Long id) {
        return subcategorysRepo.findById(id);
    }

    @Override
    public Subcategory save(Subcategory subcategory) {
        Category category = categorysRepo.findById(subcategory.getCategoryId()).orElse(null);
        subcategory.setCategory(category);
        subcategory.setCreateDate(LocalDateTime.now());
        subcategory.setUpdateDate(LocalDateTime.now());
        return subcategorysRepo.save(subcategory);
    }

    @Override
    public void deleteById(Long id) {
        subcategorysRepo.deleteById(id);
    }
}
