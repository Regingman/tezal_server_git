package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sun.misc.JavaAWTAccess;
import tezAlServer.domain.Order;
import tezAlServer.domain.Rate;
import tezAlServer.domain.Sale;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Order, Long> {
    @Query("select  u from Order u where u.containerId = ?1")
    List<Order> getOrderByRateId(Long containerId);


}
