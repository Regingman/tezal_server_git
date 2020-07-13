package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Discount;

public interface DiscountsRepo extends JpaRepository<Discount, Long> {
}
