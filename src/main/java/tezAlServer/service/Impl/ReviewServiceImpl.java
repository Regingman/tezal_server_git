package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Container;
import tezAlServer.domain.Review;
import tezAlServer.repo.ContainersRepo;
import tezAlServer.repo.ReviewsRepo;
import tezAlServer.service.ReviewService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewsRepo reviewsRepo;
    @Autowired
    ContainersRepo containersRepo;

    @Override
    public List<Review> findAll() {
        return reviewsRepo.findAll();
    }

    @Override
    public List<Review> findAllByContainerId(Long id) {
        return reviewsRepo.getReviewByContainerId(id);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewsRepo.findById(id);
    }

    @Override
    public Review save(Review review) {
        Container container = containersRepo.findById(review.getContainerId()).orElse(null);
        review.setContainer(container);
        review.setCreateDate(LocalDateTime.now());
        review.setUpdateDate(LocalDateTime.now());
        return reviewsRepo.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewsRepo.deleteById(id);
    }
}
