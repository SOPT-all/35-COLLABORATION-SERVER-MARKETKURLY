package sopt.market.product.dto.response;

import sopt.market.product.entity.CategoryScope;
import sopt.market.product.entity.DeliveryScope;
import sopt.market.product.entity.Product;

public record DetailDataGetResponse(
        String name,
        Integer price,
        Integer discount,
        Integer discountedPrice,
        String image,
        Integer membersDiscount,
        Integer membersDiscountedPrice,
        DeliveryScope deliveryType,
        String seller,
        String origin,
        String packagingType,
        String sellingUnit,
        String weight,
        String expiration,
        Float brix,
        String notification,
        CategoryScope category,
        String allergy,
        Boolean isInterest
) {
    public static DetailDataGetResponse from(final Product product, final Boolean isInterest) {
        return new DetailDataGetResponse(
                product.getName(),
                product.getPrice(),
                product.getDiscount(),
                product.getDiscountedPrice(),
                product.getImage(),
                product.getMembersDiscount(),
                product.getMembersDiscountedPrice(),
                product.getDeliveryType(),
                product.getSeller(),
                product.getOrigin(),
                product.getPackagingType(),
                product.getSellingUnit(),
                product.getWeight(),
                product.getExpiration(),
                product.getBrix(),
                product.getNotification(),
                product.getCategory(),
                product.getAllergy(),
                isInterest
        );
    }
}
