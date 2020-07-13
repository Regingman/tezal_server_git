package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.CustomerDiscount;

public interface CustomerDiscountsRepo extends JpaRepository<CustomerDiscount, Long> {
}
