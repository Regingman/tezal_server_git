package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.CustomerDiscount;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerDiscountService {
    List<CustomerDiscount> findAll();

    Optional<CustomerDiscount> findById(Long id);

    CustomerDiscount save(CustomerDiscount customerDiscount);

    void deleteById(Long id);
}
