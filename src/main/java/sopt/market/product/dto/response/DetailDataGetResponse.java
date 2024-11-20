package sopt.market.product.dto.response;

import sopt.market.product.entity.CategoryScope;
import sopt.market.product.entity.DelieveryScope;
import sopt.market.product.entity.Product;

import java.util.List;

public record DetailDataGetResponse(
        List<DetailGetResponse> products
) {
    public static DetailDataGetResponse from(final List<Product> products){
        return new DetailDataGetResponse(
                products.stream()
                        .map(DetailGetResponse::from)
                        .toList()
        );
    }

    public record DetailGetResponse(
            String name,
            Integer price,
            Integer discount,
            String image,
            Integer membersDiscount,
            DelieveryScope delieveryType,
            String seller,
            String origin,
            String packagingType,
            String sellingUnit,
            String weight,
            String expiration,
            Float brix,
            String notification,
            CategoryScope category,
            String livestock,
            String allergy
    ){
        public static DetailGetResponse from(final Product product){
            return new DetailGetResponse(
                    product.getName(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getImage(),
                    product.getMembersDiscount(),
                    product.getDelieveryType(),
                    product.getSeller(),
                    product.getOrigin(),
                    product.getPackagingType(),
                    product.getSellingUnit(),
                    product.getWeight(),
                    product.getExpiration(),
                    product.getBrix(),
                    product.getNotification(),
                    product.getCategory(),
                    product.getLivestock(),
                    product.getAllergy()
            );
        }
    }
}
