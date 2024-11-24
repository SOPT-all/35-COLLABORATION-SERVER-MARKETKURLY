package sopt.market.like.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.market.like.dto.response.InterestsGetResponse;
import sopt.market.like.entity.Interest;
import sopt.market.like.repository.InterestRepository;
import sopt.market.member.entity.Member;
import sopt.market.member.repository.MemberRepository;
import sopt.market.product.entity.Product;
import sopt.market.product.repository.ProductRepository;

import java.util.List;

@Service
public class InterestService {

    private final InterestRepository interestRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public InterestService(InterestRepository interestRepository, MemberRepository memberRepository, ProductRepository productRepository) {
        this.interestRepository = interestRepository;
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
    }

    public void addInterest(final long productId, final long memberId) {
        Product product = findProductById(productId);
        Member member = findMemberById(memberId);
        if (interestExists(member, product)) {
            saveInterest(member, product);
        }
    }

    @Transactional
    public void deleteInterest(final long productId, final long memberId) {
        Product product = findProductById(productId);
        Member member = findMemberById(memberId);
        interestRepository.deleteByMemberAndProduct(member, product);
    }


    public InterestsGetResponse getInterests(final long memberId) {
        Member member = findMemberById(memberId);
        List<Interest> interests = interestRepository.findAllByMember(member);
        return InterestsGetResponse.from(interests);
    }

    private Product findProductById(long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않은 프로덕트입니다."));
    }

    private Member findMemberById(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않은 멤버입니다."));
    }

    private boolean interestExists(Member member, Product product) {
        return interestRepository.findByMemberAndProduct(member, product).isEmpty();
    }

    private void saveInterest(Member member, Product product) {
        interestRepository.save(Interest.of(member, product));
    }
}
