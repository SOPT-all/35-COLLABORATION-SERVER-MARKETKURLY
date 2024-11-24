package sopt.market.like.dto.response;

import sopt.market.like.entity.Interest;
import sopt.market.product.entity.CategoryScope;
import sopt.market.product.entity.Product;

import java.util.List;

public record InterestsGetResponse(
        List<InterestGetResponse> products
) {
    public static InterestsGetResponse from(final List<Interest> interests){
        return new InterestsGetResponse(interests.stream().map(InterestGetResponse::from).toList());
    }


    public record InterestGetResponse(
            String name,
            String image,
            int price,
            int discount,
            CategoryScope categoryScope
    ){

        public static InterestGetResponse from(final Interest interest){
            Product product = interest.getProduct();
            return new InterestGetResponse(
                    product.getName(),
                    product.getImage(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getCategory()
            );
        }
    }
}
