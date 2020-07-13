package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.RawMaterial;

import java.util.List;
import java.util.Optional;

@Service
public interface RawMaterialService {
    List<RawMaterial> findAll();

    Optional<RawMaterial> findById(Long id);

    RawMaterial save(RawMaterial rawMaterial);

    void deleteById(Long id);
}
