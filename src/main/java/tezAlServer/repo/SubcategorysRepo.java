package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Subcategory;

public interface SubcategorysRepo extends JpaRepository<Subcategory, Long> {
}
