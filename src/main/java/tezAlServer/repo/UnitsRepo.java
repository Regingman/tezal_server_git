package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Unit;

public interface UnitsRepo extends JpaRepository<Unit, Long> {
}
