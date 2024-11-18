package sopt.market.review.entity.projection;

import java.time.LocalDateTime;

public interface ReviewProjection {

    String getUserName();

    String getContent();

    float getScore();

    boolean isAdd();

    String getImage1();

    String getImage2();

    String getImage3();

    LocalDateTime getCreatedAt();
}
