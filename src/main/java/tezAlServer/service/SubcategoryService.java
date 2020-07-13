package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Subcategory;

import java.util.List;
import java.util.Optional;

@Service
public interface SubcategoryService {
    List<Subcategory> findAll();

    Optional<Subcategory> findById(Long id);

    Subcategory save(Subcategory subcategory);

    void deleteById(Long id);
}
