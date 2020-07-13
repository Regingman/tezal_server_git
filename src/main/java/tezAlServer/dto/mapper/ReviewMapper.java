package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Review;
import tezAlServer.dto.model.ReviewDto;

import java.util.List;

@Mapper
public interface ReviewMapper {
    ReviewDto toReviewDto(Review review);

    List<ReviewDto> toReviewDtos(List<Review> reviews);

    Review toReview(ReviewDto reviewDto);
}
