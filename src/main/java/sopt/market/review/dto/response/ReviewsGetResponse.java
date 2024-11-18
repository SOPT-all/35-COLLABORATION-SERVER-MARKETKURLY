package sopt.market.review.dto.response;

import sopt.market.review.entity.projection.ReviewProjection;

import java.time.LocalDateTime;
import java.util.List;

public record ReviewsGetResponse(
        List<ReviewGetResponse> reviews
) {

    public static ReviewsGetResponse from(final List<ReviewProjection> reviews) {
        return new ReviewsGetResponse(reviews.stream().map(ReviewGetResponse::from).toList());
    }

    public record ReviewGetResponse(
            String userName,
            String content,
            float score,
            boolean isAdd,
            String image1,
            String image2,
            String image3,
            LocalDateTime createdAt
    ) {

        public static ReviewGetResponse from(final ReviewProjection review) {
            return new ReviewGetResponse(
                    review.getUserName(),
                    review.getContent(),
                    review.getScore(),
                    review.isAdd(),
                    review.getImage1(),
                    review.getImage2(),
                    review.getImage3(),
                    review.getCreatedAt()
            );
        }
    }
}
