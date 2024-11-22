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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final InterestRepository interestRepository ;
    private final MemberRepository memberRepository;

    public ProductService(
            ProductRepository productRepository,
            InterestRepository interestRepository,
            MemberRepository memberRepository){
        this.productRepository = productRepository;
        this.interestRepository = interestRepository;
        this.memberRepository = memberRepository;
    }

    public MainDataGetResponse getMainData(){

        List<Product> sorted5Products = productRepository.findTop5ByView();

        List<Product> products = productRepository.getRandomProducts(10);

        List<Product> mainTopProducts = products.subList(0,5);
        List<Product> mainBottomProducts = products.subList(5,10);

        return MainDataGetResponse.from(mainTopProducts, sorted5Products, mainBottomProducts);
    }

    public DetailDataGetResponse getDetailData(Long productId, Long memberId){

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new EntityNotFoundException("해당 상품이 없습니다."));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new EntityNotFoundException("일치하는 유저가 없습니다));
        Optional<Interest> interest = interestRepository.findByMemberAndProduct(member, product);
        boolean isInterest = interest.isPresent();

        return DetailDataGetResponse.from(product, isInterest);
    }
}
