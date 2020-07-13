package tezAlServer.repo;

import com.sun.image.codec.jpeg.JPEGDecodeParam;
import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Purchase;

public interface PurchasesRepo extends JpaRepository<Purchase, Long> {
}
