package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tezAlServer.domain.Container;
import tezAlServer.domain.Review;

import java.util.List;

public interface ReviewsRepo extends JpaRepository<Review, Long> {
    @Query("select  u from Review u where u.containerId = ?1")
    List<Review> getReviewByContainerId(Long containerId);
}
