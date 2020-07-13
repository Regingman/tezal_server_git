package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tezAlServer.domain.Order;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Order, Long> {
    @Query("select  u from Order u where u.containerId = ?1")
    List<Order> getOrderByRateId(Long containerId);


}
