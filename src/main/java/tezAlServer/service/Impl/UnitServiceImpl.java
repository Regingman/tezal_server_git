package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Unit;
import tezAlServer.repo.UnitsRepo;
import tezAlServer.service.UnitService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    UnitsRepo unitsRepo;

    @Override
    public List<Unit> findAll() {
        return unitsRepo.findAll();
    }

    @Override
    public Optional<Unit> findById(Long id) {
        return unitsRepo.findById(id);
    }

    @Override
    public Unit save(Unit container) {
        container.setCreateDate(LocalDateTime.now());
        container.setUpdateDate(LocalDateTime.now());
        return unitsRepo.save(container);
    }

    @Override
    public void deleteById(Long id) {
        unitsRepo.deleteById(id);
    }
}
