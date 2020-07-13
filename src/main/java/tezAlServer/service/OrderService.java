package tezAlServer.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Order;
import tezAlServer.domain.Sale;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> findAll();

    List<Order> findAllById(Long id);

    Optional<Order> findById(Long id);

    Order save(Order order);

    void deleteById(Long id);

    void proceedToCheckout(List<Sale> sale);

    void createCart(Long containerId, Long clientId, Sale sale);

    List<Sale> allRateInCart(Long orderId);

    void clearAllRateInCart(Long orderId);

}
