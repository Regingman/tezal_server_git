package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Order;
import tezAlServer.domain.Rate;
import tezAlServer.domain.Sale;
import tezAlServer.repo.OrdersRepo;
import tezAlServer.repo.RatesRepo;
import tezAlServer.repo.SalesRepo;
import tezAlServer.service.SaleService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SalesRepo salesRepo;
    @Autowired
    RatesRepo ratesRepo;
    @Autowired
    OrdersRepo ordersRepo;

    @Override
    public List<Sale> findAll() {
        return salesRepo.findAll();
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return salesRepo.findById(id);
    }

    @Override
    public Sale save(Sale sale) {
        Rate rate = ratesRepo.findById(sale.getRateId()).orElse(null);
        Order order = ordersRepo.findById(sale.getOrdersId()).orElse(null);
        sale.setOrders(order);
        sale.setRate(rate);
        sale.setCreateDate(LocalDateTime.now());
        sale.setUpdateDate(LocalDateTime.now());
        return salesRepo.save(sale);
    }

    @Override
    public void deleteById(Long id) {
        salesRepo.deleteById(id);
    }
}
