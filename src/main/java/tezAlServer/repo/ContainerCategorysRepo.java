package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.ContainerCategory;

public interface ContainerCategorysRepo extends JpaRepository<ContainerCategory, Long> {
}
