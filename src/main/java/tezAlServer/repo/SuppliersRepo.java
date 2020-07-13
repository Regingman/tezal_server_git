package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Supplier;

public interface SuppliersRepo extends JpaRepository<Supplier, Long> {
}
