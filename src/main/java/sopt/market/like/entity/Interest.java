package sopt.market.like.entity;

import jakarta.persistence.*;
import sopt.market.common.entity.BaseTime;
import sopt.market.member.entity.Member;
import sopt.market.product.entity.Product;

@Entity
public class Interest extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne
    Member member;

    @JoinColumn(name = "product_id")
    @ManyToOne
    Product product;

    private Interest(Member member, Product product) {
        this.member = member;
        this.product = product;
    }

    protected Interest() {

    }

    public static Interest of(final Member member, final Product product){
        return new Interest(member, product);
    }

    public Member getMember() {
        return member;
    }

    public Product getProduct() {
        return product;
    }
}
