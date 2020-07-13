package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.OrderStatus;
import tezAlServer.repo.OrdersStatusRepo;
import tezAlServer.service.OrderStatusService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    OrdersStatusRepo ordersStatusRepo;

    @Override
    public List<OrderStatus> findAll() {
        return ordersStatusRepo.findAll();
    }

    @Override
    public Optional<OrderStatus> findById(Long id) {
        return ordersStatusRepo.findById(id);
    }

    @Override
    public OrderStatus save(OrderStatus container) {
        container.setCreateDate(LocalDateTime.now());
        container.setUpdateDate(LocalDateTime.now());
        return ordersStatusRepo.save(container);
    }

    @Override
    public void deleteById(Long id) {
        ordersStatusRepo.deleteById(id);
    }
}
