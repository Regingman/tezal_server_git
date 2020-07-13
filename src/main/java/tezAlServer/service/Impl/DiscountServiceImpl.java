package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Container;
import tezAlServer.domain.Discount;
import tezAlServer.repo.ContainersRepo;
import tezAlServer.repo.DiscountsRepo;
import tezAlServer.service.DiscountService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    DiscountsRepo discountsRepo;
    @Autowired
    ContainersRepo containersRepo;

    @Override
    public List<Discount> findAll() {
        return discountsRepo.findAll();
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return discountsRepo.findById(id);
    }

    @Override
    public Discount save(Discount discount) {
        Container container = containersRepo.findById(discount.getContainerId()).orElse(null);
        discount.setContainer(container);
        discount.setCreateDate(LocalDateTime.now());
        discount.setUpdateDate(LocalDateTime.now());
        return discountsRepo.save(discount);
    }

    @Override
    public void deleteById(Long id) {
        discountsRepo.deleteById(id);
    }
}
