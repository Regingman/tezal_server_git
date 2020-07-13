package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Purchase;

import java.util.List;
import java.util.Optional;

@Service
public interface PurchaseService {
    List<Purchase> findAll();

    Optional<Purchase> findById(Long id);

    Purchase save(Purchase purchase);

    void deleteById(Long id);
}
