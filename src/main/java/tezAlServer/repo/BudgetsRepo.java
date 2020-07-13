package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Budget;

public interface BudgetsRepo extends JpaRepository<Budget, Long> {
}
