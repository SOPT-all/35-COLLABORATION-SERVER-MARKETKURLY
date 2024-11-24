package sopt.market.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.market.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
