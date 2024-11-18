package sopt.market.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sopt.market.review.entity.Review;
import sopt.market.review.entity.projection.ReviewProjection;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r.member.name AS userName, r.content AS content, r.score AS score, " +
            "r.isAdd AS isAdd, r.img1 AS image1, r.img2 AS image2, r.img3 AS image3, r.createdAt AS createdAt " +
            "FROM Review r WHERE r.product.id = :productId")
    List<ReviewProjection> findAllReviewsByProductId(@Param("productId") long productId);
}