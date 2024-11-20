package sopt.market.product.entity;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 100)
    String name;

    @Column(nullable = false, length = 10)
    @Enumerated(value = EnumType.STRING)
    DelieveryScope delieveryType;

    @Column(nullable = false, length = 30)
    String seller;

    @Column(nullable = false)
    Integer price;

    @Column(nullable = false)
    Integer discount;

    @Column(nullable = false)
    Integer membersDiscount;

    @Column(nullable = false)
    String image;

    @Column(length = 10)
    String origin;

    @Column(nullable = false, length = 20)
    String packagingType;

    @Column(nullable = false, length = 10)
    String sellingUnit;

    @Column(nullable = false, length = 15)
    String weight;

    @Column(length = 50)
    String expiration;

    @Column
    Float brix;

    @Column(nullable = false, length = 300)
    String notification;

    @Column(nullable = false, length=30)
    @Enumerated(value = EnumType.STRING)
    CategoryScope category;

    @Column(length = 50)
    String livestock;

    String allergy;

    @Column(nullable = false)
    Integer view;

    public Product(
            Long id,
            String name,
            DelieveryScope deliveryType,
            String seller,
            Integer price,
            Integer discount,
            Integer membersDiscount,
            String image,
            String origin,
            String packagingType,
            String sellingUnit,
            String weight,
            String expiration,
            Float brix,
            String notification,
            CategoryScope category,
            String livestock,
            String allergy,
            Integer view
    )
    {
            this.id = id;
            this.name = name;
            this.delieveryType = deliveryType;
            this.seller = seller;
            this.price = price;
            this.discount = discount;
            this.membersDiscount = membersDiscount;
            this.image = image;
            this.origin = origin;
            this.packagingType = packagingType;
            this.sellingUnit = sellingUnit;
            this.weight = weight;
            this.expiration = expiration;
            this.brix = brix;
            this.notification = notification;
            this.category = category;
            this.livestock = livestock;
            this.allergy = allergy;
            this.view = view;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DelieveryScope getDelieveryType() {
        return delieveryType;
    }

    public String getSeller() {
        return seller;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Integer getMembersDiscount() {
        return membersDiscount;
    }

    public String getImage() {
        return image;
    }

    public String getOrigin() {
        return origin;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public String getSellingUnit() {
        return sellingUnit;
    }

    public String getWeight() {
        return weight;
    }

    public String getExpiration() {
        return expiration;
    }

    public Float getBrix() {
        return brix;
    }

    public String getNotification() {
        return notification;
    }

    public CategoryScope getCategory() {
        return category;
    }

    public String getLivestock() {
        return livestock;
    }

    public String getAllergy() {
        return allergy;
    }

    public Integer getView() {
        return view;
    }
}
