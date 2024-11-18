package sopt.market.review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.market.common.dto.SuccessResponse;
import sopt.market.review.dto.response.ReviewsGetResponse;
import sopt.market.review.service.ReviewService;

import static sopt.market.common.dto.SuccessResponse.success;
import static sopt.market.review.messages.successMessage.GET_REVIEWS;

@RestController
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/v1/products/{productId}/reviews")
    public ResponseEntity<SuccessResponse<ReviewsGetResponse>> getReviews(
            @PathVariable long productId
    ) {
        ReviewsGetResponse response = reviewService.getReviews(productId);
        return ResponseEntity.ok().body(success(GET_REVIEWS.getMessage(), response));
    }
}
