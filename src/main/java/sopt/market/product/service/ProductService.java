package sopt.market.product.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.stereotype.Service;
import sopt.market.like.entity.Interest;
import sopt.market.like.repository.InterestRepository;
import sopt.market.member.entity.Member;
import sopt.market.member.repository.MemberRepository;
import sopt.market.product.dto.response.DetailDataGetResponse;
import sopt.market.product.dto.response.MainDataGetResponse;
import sopt.market.product.entity.Product;
import sopt.market.product.repository.ProductRepository;
import sopt.market.review.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final InterestRepository interestRepository ;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    public ProductService(
            ProductRepository productRepository,
            InterestRepository interestRepository,
            MemberRepository memberRepository,
            ReviewRepository reviewRepository){
        this.productRepository = productRepository;
        this.interestRepository = interestRepository;
        this.memberRepository = memberRepository;
        this.reviewRepository = reviewRepository;
    }

    public MainDataGetResponse getMainData(){

        List<Product> sorted5Products = productRepository.findTop5ByView();

        List<Product> products = productRepository.getRandomProducts(10);

        List<Product> mainTopProducts = products.subList(0,5);
        List<Product> mainBottomProducts = products.subList(5,10);

        mainTopProducts.forEach(product -> product.setReviewCount(reviewRepository.countByProduct(product)));
        sorted5Products.forEach(product -> product.setReviewCount(reviewRepository.countByProduct(product)));
        mainBottomProducts.forEach(product -> product.setReviewCount(reviewRepository.countByProduct(product)));

        return MainDataGetResponse.from(mainTopProducts, sorted5Products, mainBottomProducts);
    }

    public DetailDataGetResponse getDetailData(Long productId, Long memberId){

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new EntityNotFoundException("해당 상품이 없습니다."));

        Member member = memberRepository.findById(memberId).orElse(null);

        boolean isInterest = false;

        if(member != null) {
            Optional<Interest> interest = interestRepository.findByMemberAndProduct(member, product);
            isInterest = interest.isPresent();
        }
        return DetailDataGetResponse.from(product, isInterest);
    }
}
