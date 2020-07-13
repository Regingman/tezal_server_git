package tezAlServer.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tezAlServer.domain.Container;

import java.util.List;

public interface ContainersRepo extends JpaRepository<Container, Long> {
    @Query("select  u from Container u where u.containerCategoryId = ?1")
    List<Container> getContainerByContainerCategoryId(Long containerCategoryId, Pageable pageable);
}
