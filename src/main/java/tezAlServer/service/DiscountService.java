package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Discount;

import java.util.List;
import java.util.Optional;

@Service
public interface DiscountService {
    List<Discount> findAll();

    Optional<Discount> findById(Long id);

    Discount save(Discount discount);

    void deleteById(Long id);
}
