package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.User;
import tezAlServer.domain.CustomerDiscount;
import tezAlServer.domain.Discount;
import tezAlServer.repo.UsersRepo;
import tezAlServer.repo.CustomerDiscountsRepo;
import tezAlServer.repo.DiscountsRepo;
import tezAlServer.service.CustomerDiscountService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDiscountServiceImpl implements CustomerDiscountService {
    @Autowired
    CustomerDiscountsRepo customerDiscountsRepo;
    @Autowired
    DiscountsRepo discountsRepo;
    @Autowired
    UsersRepo usersRepo;
    
    @Override
    public List<CustomerDiscount> findAll() {
        return customerDiscountsRepo.findAll();
    }

    @Override
    public Optional<CustomerDiscount> findById(Long id) {
        return customerDiscountsRepo.findById(id);
    }

    @Override
    public CustomerDiscount save(CustomerDiscount customerDiscount) {
        Discount discount = discountsRepo.findById(customerDiscount.getDiscountId()).orElse(null);
        User user = usersRepo.findById(customerDiscount.getClientId()).orElse(null);
        customerDiscount.setDiscount(discount);
        customerDiscount.setUser(user);
        customerDiscount.setCreateDate(LocalDateTime.now());
        customerDiscount.setUpdateDate(LocalDateTime.now());
        return customerDiscountsRepo.save(customerDiscount);
    }

    @Override
    public void deleteById(Long id) {
        customerDiscountsRepo.deleteById(id);
    }
}
