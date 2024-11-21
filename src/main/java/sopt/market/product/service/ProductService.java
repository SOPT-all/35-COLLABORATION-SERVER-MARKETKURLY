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
        List<Product> allProducts = productRepository.findAll();
        List<Product> sorted5Products = allProducts.stream()
                .sorted((p1,p2)-> Integer.compare(p2.getView(), p1.getView()))
                .limit(5)
                .toList();

        List<Product> products = productRepository.getRandomProducts(10);

        List<Product> combinedProducts = new ArrayList<>(products);
        combinedProducts.addAll(sorted5Products);

        return MainDataGetResponse.from(combinedProducts);
    }

    public DetailDataGetResponse getDetailData(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 상품이 없습니다."));
        return DetailDataGetResponse.from(product);
    }
}
