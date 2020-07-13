package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Purchase;

public interface PurchasesRepo extends JpaRepository<Purchase, Long> {
}
