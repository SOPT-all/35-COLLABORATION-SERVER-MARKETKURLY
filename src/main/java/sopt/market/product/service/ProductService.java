package sopt.market.product.service;

import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.stereotype.Service;
import sopt.market.product.dto.response.DetailDataGetResponse;
import sopt.market.product.dto.response.MainDataGetResponse;
import sopt.market.product.entity.Product;
import sopt.market.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public MainDataGetResponse getMainData(){

        List<Product> sorted5Products = productRepository.findTop5ByView();

        List<Product> products = productRepository.getRandomProducts(10);

        List<Product> mainTopProducts = products.subList(0,5);
        List<Product> mainBottomProducts = products.subList(5,10);

        return MainDataGetResponse.from(mainTopProducts, sorted5Products, mainBottomProducts);
    }

    public DetailDataGetResponse getDetailData(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 상품이 없습니다."));
        return DetailDataGetResponse.from(product);
    }
}
