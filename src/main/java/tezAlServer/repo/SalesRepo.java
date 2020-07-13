package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tezAlServer.domain.Sale;

import java.util.List;

public interface SalesRepo extends JpaRepository<Sale, Long> {
    @Query("select u from Sale u where u.ordersId = ?1")
    List<Sale> allRawMaterialInCart(Long ordersId);

}
