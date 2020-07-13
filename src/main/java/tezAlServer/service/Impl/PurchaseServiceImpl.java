package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Purchase;
import tezAlServer.repo.PurchasesRepo;
import tezAlServer.service.PurchaseService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchasesRepo purchasesRepo;

    @Override
    public List<Purchase> findAll() {
        return purchasesRepo.findAll();
    }

    @Override
    public Optional<Purchase> findById(Long id) {
        return purchasesRepo.findById(id);
    }

    @Override
    public Purchase save(Purchase container) {
        container.setCreateDate(LocalDateTime.now());
        container.setUpdateDate(LocalDateTime.now());
        return purchasesRepo.save(container);
    }

    @Override
    public void deleteById(Long id) {
        purchasesRepo.deleteById(id);
    }
}
