package sopt.market.product.dto.response;

import com.sun.tools.javac.Main;
import sopt.market.product.entity.Product;

import java.util.List;

public record MainDataGetResponse(
        List<MainGetResponse> mainTopProducts,
        List<MainGetResponse> mainMiddleProducts,
        List<MainGetResponse> mainBottomData
) {
    public static MainDataGetResponse from(
            final List<Product> topProducts,
            final List<Product> middleProducts,
            final List<Product> bottomProducts
    ){
        return new MainDataGetResponse(
                topProducts.stream().map(MainGetResponse::from).toList(),
                middleProducts.stream().map(MainGetResponse::from).toList(),
                bottomProducts.stream().map(MainGetResponse::from).toList()
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
