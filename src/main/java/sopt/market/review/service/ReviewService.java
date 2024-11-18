package sopt.market.review.service;

import org.springframework.stereotype.Service;
import sopt.market.review.dto.response.ReviewsGetResponse;
import sopt.market.review.entity.projection.ReviewProjection;
import sopt.market.review.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewsGetResponse getReviews(final long productId) {
        List<ReviewProjection> allReviewsByProductId = reviewRepository.findAllReviewsByProductId(productId);
        return ReviewsGetResponse.from(allReviewsByProductId);
    }

}
