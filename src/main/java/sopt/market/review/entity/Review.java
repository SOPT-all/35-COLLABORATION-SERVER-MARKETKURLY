package sopt.market.review.entity;

import jakarta.persistence.*;
import sopt.market.common.entity.BaseTime;
import sopt.market.member.entity.Member;
import sopt.market.product.entity.Product;

@Entity
public class Review extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String img1;

    String img2;

    String img3;

    String content;

    float score;

    boolean isAdd;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Product product;

    public Review(
            final String img1,
            final String img2,
            final String img3,
            final String content,
            final float score,
            final boolean isAdd,
            final Member member,
            final Product product
    ) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.content = content;
        this.score = score;
        this.isAdd = isAdd;
        this.member = member;
        this.product = product;
    }

    public Review() {

    }

    public Long getId() {
        return id;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getImg3() {
        return img3;
    }

    public String getContent() {
        return content;
    }

    public float getScore() {
        return score;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public Member getMember() {
        return member;
    }

    public Product getProduct() {
        return product;
    }
}
