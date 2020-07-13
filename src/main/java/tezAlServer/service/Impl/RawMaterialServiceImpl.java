package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.RawMaterial;
import tezAlServer.domain.Subcategory;
import tezAlServer.domain.Unit;
import tezAlServer.repo.RawMaterialsRepo;
import tezAlServer.repo.SubcategorysRepo;
import tezAlServer.repo.UnitsRepo;
import tezAlServer.service.RawMaterialService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialServiceImpl implements RawMaterialService {
    @Autowired
    RawMaterialsRepo rawMaterialsRepo;
    @Autowired
    SubcategorysRepo subcategorysRepo;
    @Autowired
    UnitsRepo unitsRepo;

    @Override
    public List<RawMaterial> findAll() {
        return rawMaterialsRepo.findAll();
    }

    @Override
    public Optional<RawMaterial> findById(Long id) {
        return rawMaterialsRepo.findById(id);
    }

    @Override
    public RawMaterial save(RawMaterial rawMaterial) {
        Unit unit = unitsRepo.findById(rawMaterial.getUnitId()).orElse(null);
        Subcategory subcategory = subcategorysRepo.findById(rawMaterial.getSubcategoryId()).orElse(null);
        rawMaterial.setUnit(unit);
        rawMaterial.setSubcategory(subcategory);
        rawMaterial.setCreateDate(LocalDateTime.now());
        rawMaterial.setUpdateDate(LocalDateTime.now());
        return rawMaterialsRepo.save(rawMaterial);
    }

    @Override
    public void deleteById(Long id) {
        rawMaterialsRepo.deleteById(id);
    }
}
