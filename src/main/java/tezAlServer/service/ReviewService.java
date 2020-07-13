package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Review;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {
    List<Review> findAll();
    List<Review> findAllByContainerId(Long id);

    Optional<Review> findById(Long id);

    Review save(Review review);

    void deleteById(Long id);

}
