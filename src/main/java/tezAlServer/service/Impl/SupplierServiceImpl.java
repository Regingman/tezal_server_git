package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Supplier;
import tezAlServer.repo.SuppliersRepo;
import tezAlServer.service.SupplierService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SuppliersRepo suppliersRepo;

    @Override
    public List<Supplier> findAll() {
        return suppliersRepo.findAll();
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return suppliersRepo.findById(id);
    }

    @Override
    public Supplier save(Supplier container) {
        container.setCreateDate(LocalDateTime.now());
        container.setUpdateDate(LocalDateTime.now());
        return suppliersRepo.save(container);
    }

    @Override
    public void deleteById(Long id) {
        suppliersRepo.deleteById(id);
    }
}
