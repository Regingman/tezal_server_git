package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tezAlServer.domain.Container;
import tezAlServer.domain.Rate;

import java.util.List;

public interface RatesRepo extends JpaRepository<Rate, Long> {
    @Query("select  u from Rate u where u.containerId = ?1")
    List<Rate> getRateByRawMaterialId(Long containerId);
}
