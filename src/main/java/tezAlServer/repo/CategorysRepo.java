package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Category;

public interface CategorysRepo extends JpaRepository<Category, Long> {
}
