package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Sale;

import java.util.List;
import java.util.Optional;

@Service
public interface SaleService {
    List<Sale> findAll();

    Optional<Sale> findById(Long id);

    Sale save(Sale sale);

    void deleteById(Long id);
}
