package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.OrderStatus;

public interface OrdersStatusRepo extends JpaRepository<OrderStatus, Long> {
}
