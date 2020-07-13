package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Supplier;

import java.util.List;
import java.util.Optional;

@Service
public interface SupplierService {

    List<Supplier> findAll();

    Optional<Supplier> findById(Long id);

    Supplier save(Supplier supplier);

    void deleteById(Long id);
}
