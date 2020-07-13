package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.OrderStatus;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderStatusService {
    List<OrderStatus> findAll();

    Optional<OrderStatus> findById(Long id);

    OrderStatus save(OrderStatus orderStatus);

    void deleteById(Long id);
}
