package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Container;
import tezAlServer.domain.Rate;
import tezAlServer.domain.RawMaterial;
import tezAlServer.repo.ContainersRepo;
import tezAlServer.repo.RatesRepo;
import tezAlServer.repo.RawMaterialsRepo;
import tezAlServer.service.RateService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RatesRepo ratesRepo;
    @Autowired
    ContainersRepo containersRepo;
    @Autowired
    RawMaterialsRepo rawMaterialsRepo;

    @Override
    public List<Rate> findAll() {
        return ratesRepo.findAll();
    }

    @Override
    public List<Rate> findAllById(Long id) {
        return ratesRepo.getRateByRawMaterialId(id);
    }

    @Override
    public Optional<Rate> findById(Long id) {
        return ratesRepo.findById(id);
    }

    @Override
    public Rate save(Rate rate) {
        Container container = containersRepo.findById(rate.getContainerId()).orElse(null);
        RawMaterial rawMaterial = rawMaterialsRepo.findById(rate.getRawMaterialId()).orElse(null);
        rate.setRawMaterial(rawMaterial);
        rate.setContainer(container);
        rate.setCreateDate(LocalDateTime.now());
        rate.setUpdateDate(LocalDateTime.now());
        return ratesRepo.save(rate);
    }

    @Override
    public void deleteById(Long id) {
        ratesRepo.deleteById(id);
    }
}
