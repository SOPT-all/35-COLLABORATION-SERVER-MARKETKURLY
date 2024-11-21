package sopt.market.product.dto.response;

import sopt.market.product.entity.CategoryScope;
import sopt.market.product.entity.DelieveryScope;
import sopt.market.product.entity.Product;

public record DetailDataGetResponse(
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
        String allergy
) {
    public static DetailDataGetResponse from(final Product product) {
        return new DetailDataGetResponse(
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
                product.getAllergy()
        );
    }
}
