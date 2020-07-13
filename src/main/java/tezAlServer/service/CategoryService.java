package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Category;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    void deleteById(Long id);
}
