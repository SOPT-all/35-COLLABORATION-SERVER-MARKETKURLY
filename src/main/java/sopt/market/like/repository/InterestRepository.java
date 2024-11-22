package sopt.market.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.market.like.entity.Interest;
import sopt.market.member.entity.Member;
import sopt.market.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface InterestRepository extends JpaRepository<Interest,Long> {

    Optional<Interest> findByMemberAndProduct(Member member, Product product);

    List<Interest> findAllByMember(Member member);

    void deleteByMemberAndProduct(Member member, Product product);
}
