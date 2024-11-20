package sopt.market.product.dto.response;

import sopt.market.product.entity.Product;

import java.util.List;

public record MainDataGetResponse(
        List<MainGetResponse> products
) {
    public static MainDataGetResponse from(final List<Product> products){
        return new MainDataGetResponse(
                products.stream()
                        .map(MainGetResponse::from)
                        .toList()
        );
    }

    public record MainGetResponse(
            Long id,
            String name,
            Integer price,
            Integer discount,
            String image
    ){
        public static MainGetResponse from(final Product product){
            return new MainGetResponse(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getImage()
            );
        }
    }
}
