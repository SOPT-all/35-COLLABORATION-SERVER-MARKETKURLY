package sopt.market.product.entity;

public enum DeliveryScope {
    EXPRESS("express"),
    NORMAL("normal");

    private final String deliveryType;

    DeliveryScope(final String deliveryType){
        this.deliveryType = deliveryType;
    }
}
